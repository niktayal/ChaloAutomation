package com.org.chalo.tests;

import com.org.chalo.base.TestBase;
import com.org.chalo.pages.*;
import com.org.chalo.util.Constants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.lang.reflect.Method;

public class HomePageElementsTest extends TestBase {

    private HomePage homePage;
    LoginPageTest login = new LoginPageTest();

    RegisterEtimPage etimRegister = new RegisterEtimPage();
    PrepaidCardMasterPage prepaidCardMaster = new PrepaidCardMasterPage();
    CrewMasterPage crewMaster = new CrewMasterPage();
    EtimConfigurationPage etimConfig = new EtimConfigurationPage();
    RouteMasterPage routeMaster = new RouteMasterPage();
    VehicleMasterPage vehicleMaster = new VehicleMasterPage();
    OperatorPage operator = new OperatorPage();
    ServiceMasterPage serviceMaster = new ServiceMasterPage();
    CollectionPage collection = new CollectionPage();
    SpotTicketPage spotTicket = new SpotTicketPage();
    WaybillsPage waybills = new WaybillsPage();
    WaybillSignOffPage waybillSignOff = new WaybillSignOffPage();
    WaybillSummaryPage waybillSummary = new WaybillSummaryPage();
    SpotTicketReportPage spotTicketReport = new SpotTicketReportPage();
    CityPage city = new CityPage();
    AccountPage account = new AccountPage();
    DepotPage depot = new DepotPage();
    CitySwitch citySwitch = new CitySwitch();

    @BeforeMethod
    public void setUp(Method method) throws InterruptedException, AWTException {
        initialization();
        homePage = new HomePage();
        log.info(Constants.LINE);

        if(!driver.getCurrentUrl().contains("home")){

            log.info("The user is not logged in into the website");
            login.testMethod();
        }

        else {
            log.info("The user is already logged in into the website");
        }
    }

    @Test(priority = 1, description = "This method is testing if all the menu options are enabled")
    void menuOptionsEnable() throws AWTException, InterruptedException {

        log.info("The menu options check is been started");
        homePage.getMenuOptionsIsClickable();
        log.info("The menu options check is been stopped");

        try {
            Assert.assertTrue(true);
        } catch (Exception e) {
            log.error("-->Deliberately Failed Menu Options Enable Method: {}", e.getMessage());
            Assert.fail();
        }
    }

    @Test(priority = 2, description = "This method is testing if all the menu options are redirecting to the correct page")
    void checkRedirectionOfAllPages() throws AWTException, InterruptedException {

        log.info("The menu options redirection check is been started");

        //new RegisterEtimPage();
        etimRegister.checkRedirectionOfEtimPage();

        //new PrepaidCardMasterPage();
        prepaidCardMaster.checkRedirectionOfPrepaidCardMasterPage();

        //new CrewMasterPage();
        crewMaster.checkRedirectionOfCrewMasterPage();

        //new EtimConfigurationPage();
        etimConfig.checkRedirectionOfEtimConfigurationPage();

        //new RouteMasterPage();
        routeMaster.checkRedirectionOfRouteMasterPage();

        //new VehicleMasterPage();
        vehicleMaster.checkRedirectionOfVehicleMasterPage();

        //new OperatorPage();
        operator.checkRedirectionOfOperatorPage();

        //new ServiceMasterPage();
        serviceMaster.checkRedirectionOfServiceMasterPage();

        //new CollectionPage();
        collection.checkRedirectionOfCollectionPage();

        //new SpotTicketPage();
        spotTicket.checkRedirectionOfSpotTicketPage();

        //new WaybillsPage();
        waybills.checkRedirectionOfWaybillsPage();

        //new WaybillsSignOffPage();
        waybillSignOff.checkRedirectionOfWaybillSignOffPage();

        //new WaybillsSummaryPage();
        waybillSummary.checkRedirectionOfWaybillSummaryPage();

        //new SpotTicketReportPage();
        spotTicketReport.checkRedirectionOfSpotTicketReportPage();

        //new CityPage();
        city.checkRedirectionOfCityPage();

        //new AccountPage();
        account.checkRedirectionOfAccountPage();

        //new DepotPage();
        depot.checkRedirectionOfDepotPage();

        log.info("The menu options redirection check is been stopped");

        try {
            Assert.assertTrue(true);
        } catch (Exception e) {
            log.error("-->Deliberately Failed Check Redirection Of All Pages Method: {}", e.getMessage());
            Assert.fail();
        }
    }

    @Test(priority = 3, description = "This method is testing the city and depot switching")
    void switchCity() throws AWTException, InterruptedException {

        log.info("The city switch check is been started");

        WebElement citySwitchForm = getElement(properties.getProperty("switchCityForm"));
        if(citySwitchForm.isDisplayed()) {
            citySwitch.clickSwitch();
            citySwitch.clickSelectCity();
            citySwitch.enterCity(properties.getProperty("switchCity"));
            //citySwitch.enterAgency(properties.getProperty("switchAgency"));
            citySwitch.enterAccount(properties.getProperty("switchAccount"));
            citySwitch.clickConfirmButton();

            city.checkRedirectionOfCityPage();
            String switchedCity = getElement(properties.getProperty("confirmCity")).getText();
            String expectedCity = properties.getProperty("switchCity");

            Assert.assertEquals(switchedCity, expectedCity, "The city is been switched successfully");

        }

        else {
            log.info("The city switch form does not displayed");
        }

        log.info("The city switch check is been stopped");

        try {
            Assert.assertTrue(true);
        } catch (Exception e) {
            log.error("-->Deliberately Failed Menu Options Enable Method: {}", e.getMessage());
            Assert.fail();
        }
    }

    @AfterMethod
    public void tearDown() {
        log.info(Constants.LINE);
        driver.close();
    }
}
