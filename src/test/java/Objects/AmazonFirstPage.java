package Objects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AmazonFirstPage {
	
	@FindBy(xpath="//a[text()='Mobiles']")
	WebElement objMobiles;
	UtilityFunction ut;
	WebDriver driver;

	public AmazonFirstPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory al=new AjaxElementLocatorFactory(driver,2000);
		PageFactory.initElements(al,this);
		ut=new UtilityFunction();
	}
	
	public void ClickMobileLink() throws IOException {
		ut.TakesScreenshotdriver("firstScreen", driver);
		objMobiles.click();
		
	}
	
}
