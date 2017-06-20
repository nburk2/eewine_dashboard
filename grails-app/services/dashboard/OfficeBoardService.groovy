package dashboard

import grails.transaction.Transactional
import grails.util.Holders
import grails.plugins.rest.client.RestBuilder

@Transactional
class OfficeBoardService {

    def config = Holders.config
    def rest = new RestBuilder()

    def getWeather() {
        def weatherkey = config.WEATHER_KEY
        def resp = rest.get("http://api.wunderground.com/api/${weatherkey}/hourly/q/VA/Manassas.json")
        def forecast = resp.json?.hourly_forecast
        def forecastMap = [:]
        if(forecast) {
            forecastMap = [[hour:"Now",temp:forecast[0].temp.english,condition:forecast[0].condition, icon:forecast[0].icon_url]]
            (0..4).each { hour ->
                forecastMap << [hour:getHour(forecast[hour * 2 + 1].FCTTIME.hour), temp:forecast[hour*2 + 1].temp.english, condition:forecast[hour*2 + 1].condition, icon:forecast[hour*2 + 1].icon_url]
            }
        }

        forecastMap
    }

    private static def getHour(def hour) {
        switch (hour) {
            case "0": hour = "12AM"
                break
            case "1": hour = "1AM"
                break
            case "2": hour = "2AM"
                break
            case "3": hour = "3AM"
                break
            case "4": hour = "4AM"
                break
            case "5": hour = "5AM"
                break
            case "6": hour = "6AM"
                break
            case "7": hour = "7AM"
                break
            case "8": hour = "8AM"
                break
            case "9": hour = "9AM"
                break
            case "10": hour = "10AM"
                break
            case "11": hour = "11AM"
                break
            case "12": hour = "12PM"
                break
            case "13": hour = "1PM"
                break
            case "14": hour = "2PM"
                break
            case "15": hour = "3PM"
                break
            case "16": hour = "4PM"
                break
            case "17": hour = "5PM"
                break
            case "18": hour = "6PM"
                break
            case "19": hour = "7PM"
                break
            case "20": hour = "8PM"
                break
            case "21": hour = "9PM"
                break
            case "22": hour = "10PM"
                break
            case "23": hour = "11PM"
                break
        }
        hour
    }

}
