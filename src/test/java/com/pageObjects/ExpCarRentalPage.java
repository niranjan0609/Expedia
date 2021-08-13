package com.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpCarRentalPage {
    private static final Logger log = LogManager.getLogger(ExpCarRentalPage.class);

    private WebDriver driver;
    private WebDriverWait wait;

    //Expedia HomePage Locators
    private By autoPopUp = By.xpath("//div[contains(@class, 'uitk-menu-container-autoposition')]");
    private By CarRentalLink = By.xpath("//ul/li[@class='uitk-tab']/following::a/span[text()='Cars']");

    private By clickPickUpTextField = By.xpath("//button[@data-stid='location-field-locn-menu-trigger']");

    private By enterPickUpLocation = By.xpath("//input[@id='location-field-locn']");

    private By pickUpLocationList= By.xpath("//div[@id='location-field-locn-menu']/div/ul[@data-stid='location-field-locn-results']/li");
    private By selectPickUpLocation= By.xpath("//div[@id='location-field-locn-menu']/div/ul[@data-stid='location-field-locn-results']/li[1]");
    //location-field-loc2-results
    private By dropLocationInputField = By.xpath("//button[@data-stid='location-field-loc2-menu-trigger']");
    private By enterDropLocation = By.xpath("//input[@id='location-field-loc2']");
    private By dropLocationList= By.xpath("//ul[@data-stid='location-field-loc2-results']/li");
    private By selectDropLocation= By.xpath("//div[@id='location-field-locn-menu']/div/ul[@data-stid='location-field-loc2-results']/li[1]");

    private By clickPickUpDateField = By.xpath("//input[@id='d1']/button");
    private By clickDropDateField = By.xpath("//input[@id='d2']/button");
    //private By selectDate = By.xpath("//table/tbody/tr/following::td/button[@aria-label='Aug 19, 2021']");
    private By datePicker = By.xpath("div[@class='uitk-date-picker date-picker-menu']");
    String selectDateStr = "//table/tbody/tr/following::td/button[@aria-label='%s']";
    private By doneBtn = By.xpath("//button[@data-stid='apply-date-picker']/span");

    private By selectPickUpTime = By.xpath("//select[@aria-label='Pick-up time']");
    private By selectDropOffTime = By.xpath("//select[@aria-label='Drop-off time']");
    private By searchBtn = By.xpath("//button[@data-testid='submit-button']");
    private By economyCheckBox = By.xpath("//input[@id='economy']");
    private By isCheckedEconomy = By.xpath("//input[@id='economy' and contains(@class, 'checked')]");
    private By selectSortCars = By.xpath("//select[@id='cars-sort-dropdown']"); //
    private By reserveBtn = By.xpath("//div[@id='offer-cards-list']/ol/li[1]/following::a[1]/button");


    //div[@class='uitk-date-picker-month'][1]/table/tbody/tr/following::td/button[@aria-label='Aug 19, 2021']



    //Expedia CarRentalPage Locators




    public ExpCarRentalPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        wait = new WebDriverWait(driver, 120);
    }

    public void waitUntilAutoLoginClose() {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(autoPopUp)));
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public void clickCarRentalOnHomepage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CarRentalLink));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(CarRentalLink)));
        driver.findElement(CarRentalLink).click();
    }








    public void enterName() {
    }

    public void selectCountryCode() {
    }

    public void enterPhoneNo() {
    }

    public void addRentalProtectAddon() {
    }

    public void enterNameOnCard() {
    }

    public void enterCardNo() {
    }

    public void selectCardExpiryDate() {
    }

    public void enterCVV() {
    }

    public void enterBillingZipCode() {
    }

    public void enterConfirmationEmailID() {
    }

    public void choosePassword() {
    }

    public void confirmPassword() {
    }

    public void clickReserveNowBtn() {
    }

    public void clickPickUpField() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(clickPickUpTextField)));
        driver.findElement(clickPickUpTextField).click();
    }

    public void enterPickupLocation(String pickLocation) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(enterPickUpLocation)));
        driver.findElement(enterPickUpLocation).sendKeys(pickLocation);

    }

    public void selectPickUpLocation() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(pickUpLocationList)));
        driver.findElement(selectPickUpLocation).click();
    }

    public void clickDropField() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(dropLocationInputField)));
        driver.findElement(dropLocationInputField).click();
    }

    public void enterDropLocation(String dropLocation) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(enterDropLocation)));
        driver.findElement(enterDropLocation).sendKeys(dropLocation);
    }

    public void selectDropLocation() {
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(dropLocationList)));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(dropLocationList)));
        driver.findElement(selectDropLocation).click();
    }

    public void clickPickUpDate() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(clickPickUpDateField)));
        driver.findElement(clickPickUpDateField).click();
    }

    public void selectPickupDate(String date) {
        By dateToSelect = By.xpath(String.format(selectDateStr, date));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(datePicker)));
        driver.findElement(dateToSelect).sendKeys();
    }

    public void selectDropOffDate(String date) {
        By dateToSelect = By.xpath(String.format(selectDateStr, date));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(datePicker)));
        driver.findElement(dateToSelect).sendKeys();
    }


    public void clickDoneButton() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(doneBtn)));
        driver.findElement(doneBtn).click();
    }

     public void enterPickupTime(String pickUpTime) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(selectPickUpTime)));
        Select ptime = new Select(driver.findElement(selectPickUpTime));
        ptime.selectByVisibleText(pickUpTime);
    }

    public void enterDropTime(String dropTime) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(selectDropOffTime)));
        Select dtime = new Select(driver.findElement(selectDropOffTime));
        dtime.selectByVisibleText(dropTime);
    }

    public void clickOnSearchBtn() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(CarRentalLink)));
        driver.findElement(CarRentalLink).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(selectSortCars)));

    }

    public void selectCarType() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(economyCheckBox)));
        driver.findElement(economyCheckBox).click();
        boolean selected = driver.findElement(isCheckedEconomy).isDisplayed();
        log.debug("Is locator displayed.." +selected);
        boolean isSelected = driver.findElement(economyCheckBox).isSelected();
        log.debug("Is locator selected.." +isSelected);
    }

    public void sortResults(String sortByValue) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(selectSortCars)));
        Select sort = new Select(driver.findElement(selectSortCars));
        sort.selectByVisibleText(sortByValue);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(reserveBtn)));
    }

    public void clickOnReserveBtn() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(reserveBtn)));
        driver.findElement(reserveBtn).click();
    }
}
