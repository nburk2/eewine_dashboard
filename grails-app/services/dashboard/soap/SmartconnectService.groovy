package dashboard.soap

import grails.converters.XML
import org.grails.web.json.JSONObject
import wslite.soap.SOAPClient
import wslite.soap.SOAPResponse
import grails.transaction.Transactional

@Transactional
class SmartconnectService {

    def getTransactions() {
        //http://192.168.10.244/WSSmartConnect17/cUtility.asmx local smartconnect url
        String url = 'http://192.168.10.244/WSSmartConnect17/CTransaction.asmx'
        String action = "http://www.addsys.com/GetARTransactions"

        SOAPClient client = new SOAPClient("${url}")

        SOAPResponse resp = client.send(SOAPAction: action,
                """<?xml version='1.0' encoding='UTF-8'?>
                       <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:add="http://www.addsys.com/">
                       <soap:Header/>
                       <soap:Body>
                          <add:GetARTransactions>
                             <add:p_iCompanyID>1</add:p_iCompanyID>
                             <add:p_lAccountNum>71</add:p_lAccountNum>
                             <add:p_iTankNum>1</add:p_iTankNum>
                             <add:p_iServiceNum>0</add:p_iServiceNum>
                             <add:p_iLocationNum>0</add:p_iLocationNum>
                             <add:p_dteFromDate>2001-05-01</add:p_dteFromDate>
                             <add:p_dteToDate>2020-05-31</add:p_dteToDate>
                             <add:p_lMaxRows>5</add:p_lMaxRows>
                             <!--Optional:-->
                             <add:p_sSysUser>WebUser</add:p_sSysUser>
                             <add:p_lErrorCode>0</add:p_lErrorCode>
                          </add:GetARTransactions>
                       </soap:Body>
                    </soap:Envelope>"""
        )

        def listOfTransactions = createListOfItemsFromString(resp.text)
        println listOfTransactions
//        listOfItems
    }

    def createListOfItemsFromString(String xmlText) {
        def xmlstring= new XmlParser().parseText(xmlText)
        def transSize = xmlstring.'soap:Body'.GetARTransactionsResponse.GetARTransactionsResult.'diffgr:diffgram'.DSGetARTransactions.GetARTransactions.size()
        def transactions = xmlstring.'soap:Body'.GetARTransactionsResponse.GetARTransactionsResult.'diffgr:diffgram'.DSGetARTransactions.GetARTransactions

        def listOfItems = []
        for(int i = 0; i < transSize;i ++) {
            listOfItems << transactions[0].children().collectEntries {
                [it.name().toString().substring(it.name().toString().lastIndexOf("}") + 1), it.text()]
            }
        }

        listOfItems
    }

    def getAccounts() {
        String url = 'http://192.168.10.244/WSSmartConnect17/CTransaction.asmx'
        String action = "http://www.addsys.com/GetARTransactions"

        SOAPClient client = new SOAPClient("${url}")

        SOAPResponse resp = client.send(SOAPAction: action,
                """<?xml version='1.0' encoding='UTF-8'?>
                       <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:add="http://www.addsys.com/">
                       <soap:Header/>
                       <soap:Body>
                          <add:GetARTransactions>
                             <add:p_iCompanyID>1</add:p_iCompanyID>
                             <add:p_lAccountNum>71</add:p_lAccountNum>
                             <add:p_iTankNum>1</add:p_iTankNum>
                             <add:p_iServiceNum>0</add:p_iServiceNum>
                             <add:p_iLocationNum>0</add:p_iLocationNum>
                             <add:p_dteFromDate>2001-05-01</add:p_dteFromDate>
                             <add:p_dteToDate>2020-05-31</add:p_dteToDate>
                             <add:p_lMaxRows>5</add:p_lMaxRows>
                             <!--Optional:-->
                             <add:p_sSysUser>WebUser</add:p_sSysUser>
                             <add:p_lErrorCode>0</add:p_lErrorCode>
                          </add:GetARTransactions>
                       </soap:Body>
                    </soap:Envelope>"""
        )

        def listOfAccounts = createListOfItemsFromString(resp.text)
        println listOfAccounts
    }

    def getDeliveryLocations() {
        String url = 'http://192.168.10.244/WSSmartConnect17/CTransaction.asmx'
        String action = "http://www.addsys.com/GetARTransactions"

        SOAPClient client = new SOAPClient("${url}")

        SOAPResponse resp = client.send(SOAPAction: action,
                """<?xml version='1.0' encoding='UTF-8'?>
                       <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:add="http://www.addsys.com/">
                       <soap:Header/>
                       <soap:Body>
                          <add:GetARTransactions>
                             <add:p_iCompanyID>1</add:p_iCompanyID>
                             <add:p_lAccountNum>71</add:p_lAccountNum>
                             <add:p_iTankNum>1</add:p_iTankNum>
                             <add:p_iServiceNum>0</add:p_iServiceNum>
                             <add:p_iLocationNum>0</add:p_iLocationNum>
                             <add:p_dteFromDate>2001-05-01</add:p_dteFromDate>
                             <add:p_dteToDate>2020-05-31</add:p_dteToDate>
                             <add:p_lMaxRows>5</add:p_lMaxRows>
                             <!--Optional:-->
                             <add:p_sSysUser>WebUser</add:p_sSysUser>
                             <add:p_lErrorCode>0</add:p_lErrorCode>
                          </add:GetARTransactions>
                       </soap:Body>
                    </soap:Envelope>"""
        )

        println resp.text
//        def listOfDeliveryLocations = createListOfItemsFromString(resp.text)
//        println listOfDeliveryLocations
    }
}
