package Test.com.muthuAltimetrik;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import Objects.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseOne {

	WebDriver driver;

	@BeforeTest()
	public void LaunchDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		
	 
	}

	@Test()
	public void TestCaseOne() throws IOException, ParseException, InterruptedException, AWTException {

		AmazonFirstPage objFirst = new AmazonFirstPage(driver);
		objFirst.ClickMobileLink();
		AmazonMobileSelectionPage objFeatured = new AmazonMobileSelectionPage(driver);
		objFeatured.SelectionofBrand();
		objFeatured.checking4();
		OrderMobile om=new OrderMobile(driver);
		om.verifyNewPage();
		om.SelectQuantity();  
	
	}
	

@AfterTest()
	public void QuitDriver() {
		driver.quit();
	}
}
