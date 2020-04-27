package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AmazonMobileSelectionPage {

	WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),\"Featured brands in mobiles\")]")
	WebElement ObjFeatured;
	@FindBy(xpath="//div[@class='acs-ln-links']/descendant::ul/li/a[text()='Apple']")
	WebElement ObjApple;
	@FindBy(xpath="//i[@class='a-icon a-icon-star-medium a-star-medium-4']")
	WebElement Obj4;
	@FindBy(xpath="(//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom'])[1]")
	WebElement ObjFour;
	@FindBy(xpath="//a[text()=\"See all customer reviews\"]")
	WebElement ObjPopup;
	
	public AmazonMobileSelectionPage(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory al=new AjaxElementLocatorFactory(driver,20);
		PageFactory.initElements(al,this);
	}
	
	
	public void SelectionofBrand() {
		ObjFeatured.click();
		ObjApple.click();
		Obj4.click();
	}
	
	public void checking4() throws InterruptedException {
		Actions act=new Actions(driver);
		act.moveToElement(ObjFour);
		act.build().perform();
		Assert.assertEquals(ObjPopup.isDisplayed(),true);
		System.out.println(ObjPopup.getText());
	}
	
}
