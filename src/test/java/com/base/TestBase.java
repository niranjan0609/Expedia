package com.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.grid.selenium.node.FirefoxMutator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.HashMap;

public class TestBase {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            case "ie":
                driver = initInternetExplorer(appURL);
                break;
            default:
                System.out.println("browser : " + browserType
                        + " is invalid, Launching Firefox as browser of choice..");
                driver = initFirefoxDriver(appURL);
        }
        return driver;
    }

    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome with new profile..");
		/*System.setProperty("webdriver.chrome.driver", driverPath
				+ "chromedriver.exe");*/
        WebDriverManager.chromedriver().setup();
        String downloadFilepath = "C:\\Users\\niranjan.t\\Downloads\\TestData\\";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching firefox browser..");
		/*System.setProperty("webdriver.gecko.driver", driverPath
				+ "geckodriver.exe");*/
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    private static WebDriver initInternetExplorer(String appURL) {
        System.out.println("Launching firefox browser..");
		/*System.setProperty("webdriver.chrome.driver", driverPath
				+ "chromedriver.exe");*/
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    @Parameters({ "browserType", "appURL" })
    @BeforeTest(alwaysRun = true)
    public void initializeTestBaseSetup(@Optional("chrome") String browserType, @Optional("https://www.expedia.com") String appURL, ITestContext context) {		try {
        //test.log(Status.INFO, "Opening browser "+browserType);
        System.out.println("Intializing browser...." + browserType);
        driver = setDriver(browserType, appURL);
        context.setAttribute("driver", driver);

    } catch (Exception e) {
        System.out.println("Error....." );
        e.printStackTrace();
    }
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
