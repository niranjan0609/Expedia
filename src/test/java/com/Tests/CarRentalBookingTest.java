package com.Tests;

import java.io.File;
import java.util.*;
import com.base.TestBase;
import com.pageObjects.ExpCarRentalPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CarRentalBookingTest extends TestBase {
    private static final Logger log = LogManager.getLogger(CarRentalBookingTest.class);

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Parameters({ "pickLocation", "dropLocation", "pickDate", "dropDate", "pickTime", "dropTime", "custName", "phNo","name","cNo","code", "zcode","email","pwd", "cPwd" })
    @Test
    public void bookRentalCar() throws InterruptedException {

        log.debug("Test started...");
        ExpCarRentalPage expPage = new ExpCarRentalPage(driver);

        expPage.clickCarRentalOnHomepage();
        expPage.clickPickUpField();
        expPage.enterPickupLocation("Bengaluru");
        expPage.selectPickUpLocation();
        expPage.clickDropField();
        expPage.enterDropLocation("Hebbal");
        expPage.selectDropLocation();

        expPage.clickPickUpDate();
        expPage.selectPickupDate("Aug 17, 2021");
        expPage.selectDropOffDate("Aug 19, 2021");
        expPage.clickDoneButton();
        expPage.enterPickupTime("10:00 am");
        expPage.enterDropTime("5:30 pm");
        expPage.clickOnSearchBtn();

        expPage.selectCarType();
        expPage.sortResults("");
        expPage.clickOnReserveBtn();
/*
        expPage.enterName(custName);
        expPage.selectCountryCode();
        expPage.enterPhoneNo(phNo);
        expPage.addRentalProtectAddon();
        expPage.enterNameOnCard(name);
        expPage.enterCardNo(cNo);
        expPage.selectCardExpiryDate();
        expPage.enterCVV(code);
        expPage.enterBillingZipCode(zcode);
        expPage.enterConfirmationEmailID(email);
        expPage.choosePassword(pwd);
        expPage.confirmPassword(cPwd);
        expPage.clickReserveNowBtn();*/



    }

    @AfterMethod
    public void testTearDown() {

    }

}
