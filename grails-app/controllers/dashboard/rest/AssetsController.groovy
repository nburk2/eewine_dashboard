package dashboard.rest

import dashboard.fuelaccounts.Accounts
import dashboard.fuelaccounts.Assets

class AssetsController {

    def index() { }
    def addAssets() {
        def assets = request.JSON.assets
        assets.each { asset ->
            def newAsset = new Assets()
            newAsset.assetId = asset.assetId
            newAsset.barcode = asset.barcode
            newAsset.account = Accounts.findByNumber(asset.assetId.toInteger())

            newAsset.save()
        }

        respond([status:200, message:"added new accounts"])
    }

    def getAssets() {
        int num = request.JSON.accountNumber.toInteger()
        Accounts account = Accounts.findByNumber(num)
        def assets = Assets.findAllByAccount(account,[sort:"barcode"])

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
