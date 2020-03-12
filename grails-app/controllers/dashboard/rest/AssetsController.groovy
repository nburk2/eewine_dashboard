package dashboard.rest

import dashboard.fuelaccounts.Accounts
import dashboard.fuelaccounts.Assets

class AssetsController {

    def index() { }
    def addAssets() {
        def assets = request.JSON.assets
        println("here")
        respond([status:200, message:assets])
        return
        assets.each { asset ->
            def newAsset = new Assets()
            newAsset.assetId = asset.assetId
            newAsset.barcode = asset.barcode
            newAsset.tankNum = asset.tankNum
            newAsset.account = Accounts.findByNumber(asset.accountNumber.toInteger())

            if(newAsset.hasErrors()) {
                respond([status:400, error:newAsset.errors])
            }

            newAsset.save(flush:true, failOnError: true)
        }

        respond([status:200, message:"added new accounts"])
    }

    def getAssets() {
        int num = request.JSON.accountNumber.toInteger()
        int tankNum = request.JSON.tankNum.toInteger()
        Accounts account = Accounts.findByNumber(num)
        def assets = Assets.findAllByAccountAndTankNum(account,tankNum,[sort:"barcode"])

        respond([status:200, account:account, assets:assets])
    }

    def editAsset() {
        def asset = request.JSON.asset
        def account = Accounts.findById(asset.accountId.toInteger())
        def newAsset = Assets.findByAssetIdAndAccount(asset.assetId.toInteger(), account)

        if(asset.comdataCardNum) {
            newAsset.comdataCardNum = asset.comdataCardNum
        }

        if(asset.barcode) {
            newAsset.barcode = asset.barcode
        }

        newAsset.save(flush:true, failOnError: true)
        if(newAsset.hasErrors()) {
            println(newAsset.erros)
        }

        respond([status:200, message:"updated Asset: " + newAsset.barcode])
    }

}
