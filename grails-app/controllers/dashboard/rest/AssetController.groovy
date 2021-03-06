package dashboard.rest

import dashboard.fuelaccounts.Accounts
import dashboard.fuelaccounts.Asset

import com.bertramlabs.plugins.SSLRequired
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Secured(["permitAll"])
@SSLRequired
@Transactional
class AssetController {

    static allowedMethods = [getAssets: "POST",addAssets: "POST",editAsset:"POST"]

    def index() { }

    def addAssets() {

        def assets = request.JSON.assets

        assets.each { asset ->
            def newAsset = Asset.findOrCreateByAssetId(asset.assetId)
            newAsset.assetId = asset.assetId
            newAsset.barcode = asset.barcode
            newAsset.tankNum = asset.tankNum
            newAsset.description = asset.description
            newAsset.account = Accounts.findByNumber(asset.accountNumber.toInteger())

            newAsset.save()
//            if(newAsset.hasErrors()) {
//                respond([status:400, error:newAsset.errors])
//                return
//            }
        }

        respond([status:200, message:"imported new assets"])
    }

    def getAssets() {
        int num = request.JSON.accountId.toInteger()
        int tankNum = request.JSON.tankNum.toInteger()
        Accounts account = Accounts.findById(num)
        def assets = Asset.findAllByAccountAndTankNum(account,tankNum,[sort:"barcode"])

        respond([status:200, account:account, assets:assets])
    }

    def editAsset() {
        def asset = request.JSON.asset
        def account = Accounts.findById(asset.accountId.toInteger())
        def newAsset = Asset.findByAssetIdAndAccount(asset.assetId.toInteger(), account)

        if(asset.comdataCardNum) {
            newAsset.comdataCardNum = asset.comdataCardNum.toLong()
        }

        if(asset.department) {
            newAsset.department = asset.department
        }

        newAsset.save(flush:true, failOnError: true)
        if(newAsset.hasErrors()) {
            respond([status:200, message:"Asset error: " + newAsset.errors])
        }

        respond([status:200, message:"updated Asset: " + newAsset.barcode])
    }

}
