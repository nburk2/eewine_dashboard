package dashboard

import dashboard.data.Driver

class BootStrap {

    def init = { servletContext ->
        testData()
    }
    def destroy = {
    }

    def testData() {
        def drivers = []
        drivers << new Driver([firstName:"Doug", lastName:"Arroyo",medCardExpDate:new GregorianCalendar(2017, Calendar.SEPTEMBER, 18).time, driversLicenseExpDate:new GregorianCalendar(2024, Calendar.OCTOBER, 16).time, hazmatExpDate: new GregorianCalendar(2021, Calendar.NOVEMBER, 1).time])
        drivers << new Driver([firstName:"Jason", lastName:"Asplundh",medCardExpDate:new GregorianCalendar(2018, Calendar.JUNE, 2).time, driversLicenseExpDate:new GregorianCalendar(2018, Calendar.APRIL, 4).time, hazmatExpDate: new GregorianCalendar(2019, Calendar.MAY, 1).time])
        drivers << new Driver([firstName:"Josh", lastName:"Ayers",medCardExpDate:new GregorianCalendar(2017, Calendar.SEPTEMBER, 15).time, driversLicenseExpDate:new GregorianCalendar(2021, Calendar.NOVEMBER, 16).time, hazmatExpDate: new GregorianCalendar(2018, Calendar.OCTOBER, 11).time])
        drivers << new Driver([firstName:"Lazaro", lastName:"Chua",medCardExpDate:new GregorianCalendar(2018, Calendar.FEBRUARY, 3).time, driversLicenseExpDate:new GregorianCalendar(2017, Calendar.JULY, 30).time, hazmatExpDate: new GregorianCalendar(2021, Calendar.JANUARY, 1).time])
        drivers << new Driver([firstName:"Bryan", lastName:"Ciaccio",medCardExpDate:new GregorianCalendar(2018, Calendar.JANUARY, 9).time, driversLicenseExpDate:new GregorianCalendar(2019, Calendar.FEBRUARY, 4).time, hazmatExpDate: new GregorianCalendar(2019, Calendar.MARCH, 1).time])
        drivers << new Driver([firstName:"Steve", lastName:"Cunningham",medCardExpDate:new GregorianCalendar(2019, Calendar.APRIL, 1).time, driversLicenseExpDate:new GregorianCalendar(2017, Calendar.OCTOBER, 10).time, hazmatExpDate: new GregorianCalendar(2020, Calendar.FEBRUARY, 1).time])
        drivers << new Driver([firstName:"Mike", lastName:"Downs",medCardExpDate:new GregorianCalendar(2017, Calendar.OCTOBER, 10).time, driversLicenseExpDate:new GregorianCalendar(2020, Calendar.SEPTEMBER, 14).time, hazmatExpDate: new GregorianCalendar(2022, Calendar.APRIL, 1).time])
        drivers << new Driver([firstName:"Robert", lastName:"Fox",medCardExpDate:new GregorianCalendar(2017, Calendar.JULY, 22).time, driversLicenseExpDate:new GregorianCalendar(2020, Calendar.OCTOBER, 12).time, hazmatExpDate: new GregorianCalendar(2019, Calendar.NOVEMBER, 1).time])
        drivers << new Driver([firstName:"Keven", lastName:"Kinard",medCardExpDate:new GregorianCalendar(2018, Calendar.FEBRUARY, 9).time, driversLicenseExpDate:new GregorianCalendar(2020, Calendar.SEPTEMBER, 9).time, hazmatExpDate: new GregorianCalendar(2022, Calendar.MARCH, 1).time])
        drivers << new Driver([firstName:"Clay", lastName:"Lanham",medCardExpDate:new GregorianCalendar(2019, Calendar.APRIL, 6).time, driversLicenseExpDate:new GregorianCalendar(2020, Calendar.MAY, 14).time, hazmatExpDate: new GregorianCalendar(2022, Calendar.JANUARY, 1).time])
        drivers << new Driver([firstName:"Vernon", lastName:"Lewis",medCardExpDate:new GregorianCalendar(2018, Calendar.MARCH, 7).time, driversLicenseExpDate:new GregorianCalendar(2020, Calendar.JUNE, 2).time, hazmatExpDate: new GregorianCalendar(2022, Calendar.JANUARY, 1).time])
        drivers << new Driver([firstName:"Rodeny", lastName:"Martin", hazmatExpDate: new GregorianCalendar(2022, Calendar.JANUARY, 1).time])
        drivers << new Driver([firstName:"Carlton", lastName:"Murphy",medCardExpDate:new GregorianCalendar(2017, Calendar.SEPTEMBER, 14).time, driversLicenseExpDate:new Date(), hazmatExpDate: new Date()])
        drivers << new Driver([firstName:"Cliff", lastName:"Musick",medCardExpDate:new Date(), driversLicenseExpDate:new Date(), hazmatExpDate: new Date()])
        drivers << new Driver([firstName:"Robert", lastName:"Quansah",medCardExpDate:new Date(), driversLicenseExpDate:new Date(), hazmatExpDate: new Date()])
        drivers << new Driver([firstName:"Lee", lastName:"Toliver",medCardExpDate:new Date(), driversLicenseExpDate:new Date(), hazmatExpDate: new Date()])
        drivers << new Driver([firstName:"Rico", lastName:"Walker",medCardExpDate:new Date(), driversLicenseExpDate:new Date(), hazmatExpDate: new Date()])
        drivers << new Driver([firstName:"Gary", lastName:"Washburn",medCardExpDate:new Date(), driversLicenseExpDate:new Date(), hazmatExpDate: new Date()])
        drivers << new Driver([firstName:"Anthony", lastName:"Woodson",medCardExpDate:new Date(), driversLicenseExpDate:new Date(), hazmatExpDate: new Date()])
        drivers.each { driver ->
            driver.save()
        }

    }
}
