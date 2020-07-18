package Test.com.muthuAltimetrik;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectsRepo.*;

import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Local;

public class TestCaseOne {

	WebDriver driver;
	ExtentReports reports;

	@BeforeTest()
	public void LaunchDriver() throws MalformedURLException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

	}

	@Test(priority = 0)
	public void TestCaseOne() throws IOException, ParseException, InterruptedException, AWTException {
		// ExtentTest test = reports.startTest("TestCaseOne");
		AmazonFirstPage objFirst = new AmazonFirstPage(driver);
		objFirst.ClickMobileLink();

		AmazonMobileSelectionPage objFeatured = new AmazonMobileSelectionPage(driver);
		objFeatured.SelectionofBrand();
		objFeatured.checking4();
		OrderMobile om = new OrderMobile(driver);
		om.verifyNewPage();
		om.SelectQuantity();

		/*
		 * reports.endTest(test); reports.flush();
		 */
	}

	@Test(priority = 1, enabled = false)
	public void TestCaseTwo() throws InterruptedException {
		// ExtentTest test = reports.startTest("TestCaseTwo");
		AmazonFirstPage objFirst = new AmazonFirstPage(driver);
		Assert.assertEquals(objFirst.objLanButton1().isDisplayed(), true);
		// test.log(LogStatus.PASS, objFirst.objLanButton1().getText());
		objFirst.moveToLanguage();
		Assert.assertEquals(objFirst.objEnglish1().isDisplayed(), true);
		Assert.assertEquals(objFirst.objhindi1().isDisplayed(), true);
		// reports.endTest(test);
		// reports.flush();
	}

	@Test(priority = 2)
	public void TestCaseThree() throws IOException, InterruptedException {
		driver.get("https://easyupload.io/");
		easyupload eu = new easyupload(driver);
		eu.ClickUploadSection();
		eu.verifyPwd();

	}

	@AfterTest()
	public void QuitDriver() {
		driver.quit();
	}

}
