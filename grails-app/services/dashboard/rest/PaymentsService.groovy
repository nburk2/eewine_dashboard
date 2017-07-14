package dashboard.rest

import grails.transaction.Transactional
import grails.util.Holders
import net.authorize.Environment;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CreateTransactionRequest;
import net.authorize.api.contract.v1.CreateTransactionResponse;
import net.authorize.api.contract.v1.CustomerAddressType;
import net.authorize.api.contract.v1.CustomerDataType;
import net.authorize.api.contract.v1.OpaqueDataType;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.contract.v1.TransactionRequestType;
import net.authorize.api.contract.v1.TransactionResponse;
import net.authorize.api.contract.v1.TransactionTypeEnum;
import net.authorize.api.controller.CreateTransactionController;
import net.authorize.api.controller.base.ApiOperationBase

import java.math.RoundingMode;

@Transactional(readOnly = true)
class PaymentsService {

    def config = Holders.config
    def apiLoginId = config.APILOGINID
    def transactionKey = config.TRANSACTIONKEY

    def authorizeAndCapture(params) {
        //Common code to set for all requests
        ApiOperationBase.setEnvironment(Environment.PRODUCTION);

        MerchantAuthenticationType merchantAuthenticationType  = new MerchantAuthenticationType() ;
        merchantAuthenticationType.setName(apiLoginId);
        merchantAuthenticationType.setTransactionKey(transactionKey);
        ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);

        // Populate the payment data
        PaymentType paymentType = new PaymentType();
        OpaqueDataType OpaqueData = new OpaqueDataType();
        OpaqueData.setDataDescriptor(params.datadesc ?: "COMMON.ACCEPT.INAPP.PAYMENT");
        OpaqueData.setDataValue(params.dataValue ?: "eyJjb2RlIjoiNTBfMl8wNjAwMDUzQ0REOEM2NjVDNkU1RkY3REIwQzMwMjI1QjA4QjZDMTlDMzVBNEM5NzFFMDU3RTgyNjBFOTkyQjVBN0FDRjU3NkQ4NENFMzNGNTg0N0ZCOERGRDc5NDgzNzE2MURGNzc1IiwidG9rZW4iOiI5NDk5MzY2NjkyNTY3MTA0MDA0NjAzIiwidiI6IjEuMSJ9");
        paymentType.setOpaqueData(OpaqueData);

        //Customer Info
        CustomerDataType customerData = new CustomerDataType()
        customerData.setEmail(params.email)


        //Bill To
        CustomerAddressType billTo = new CustomerAddressType()
        billTo.setFirstName(params.firstName)
        billTo.setLastName(params.lastName)
        billTo.setCompany(params.company ?: "")
        billTo.setAddress(params.address)
        billTo.setCity(params.city)
        billTo.setState(params.state)
        billTo.setZip(params.zipCode)
        billTo.setCountry(params.country)
        billTo.setPhoneNumber(params.phoneNumber)

        // Create the payment transaction request
        TransactionRequestType txnRequest = new TransactionRequestType();
        txnRequest.setTransactionType(TransactionTypeEnum.AUTH_CAPTURE_TRANSACTION.value());
        txnRequest.setCustomer(customerData)
        txnRequest.setBillTo(billTo)
        txnRequest.setPayment(paymentType);
        txnRequest.setAmount(new BigDecimal(params.amount).setScale(2, RoundingMode.CEILING));

        // Make the API Request
        CreateTransactionRequest apiRequest = new CreateTransactionRequest();
        apiRequest.setTransactionRequest(txnRequest);
        CreateTransactionController controller = new CreateTransactionController(apiRequest);
        controller.execute();


        CreateTransactionResponse response = controller.getApiResponse();

        if (response!=null) {
            // If API Response is ok, go ahead and check the transaction response
            if (response.getMessages().getResultCode() == MessageTypeEnum.OK) {
                TransactionResponse result = response.getTransactionResponse();
                if(result.getMessages() != null){
//                    System.out.println("Successfully created transaction with Transaction ID: " + result.getTransId());
//                    System.out.println("Response Code: " + result.getResponseCode());
                    System.out.println("Message Code: " + result.getMessages().getMessage().get(0).getCode());
                    System.out.println("Description: " + result.getMessages().getMessage().get(0).getDescription());
//                    System.out.println("Auth Code: " + result.getAuthCode());
                }
                else {
                    System.out.println("Failed Transaction.");
                    if(response.getTransactionResponse().getErrors() != null){
                        System.out.println("Error Code: " + response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
                        System.out.println("Error message: " + response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
                    }
                }
            }
            else {
                System.out.println("Failed Transaction.");
                if(response.getTransactionResponse() != null && response.getTransactionResponse().getErrors() != null){
                    System.out.println("Error Code: " + response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
                    System.out.println("Error message: " + response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
                }
                else {
                    System.out.println("Error Code: " + response.getMessages().getMessage().get(0).getCode());
                    System.out.println("Error message: " + response.getMessages().getMessage().get(0).getText());
                }
            }
        }
        else {
            System.out.println("Null Response.");
        }

        return response

    }
}
