package Objects;

import java.util.List;
import Objects.AmazonFirstPage;
import Objects.UtilityFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BooksFirstPage {

	WebDriver driver;

	@FindBy(xpath = "//div[@data-category='books']")
	WebElement objsubHeader;

	public BooksFirstPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory aj = new AjaxElementLocatorFactory(this.driver, 20);
		PageFactory.initElements(aj, this);
	}

	public boolean ValidateSubHeadersOrder() {
		boolean flag = true;
		AmazonFirstPage pg = new AmazonFirstPage(driver);
		UtilityFunction uf = new UtilityFunction(driver);
		uf.MoveTo(pg.objBooks);

		pg.objBooks.click();
		String temp = "Books;Advanced Search;New Releases & Pre-orders;Best Sellers;;Browse Genres;;Children's & Young Adult;;Textbooks;;Exam Central;;All Indian Languages;";
		String[] arr = temp.split(";", -1);
		List<WebElement> li = objsubHeader.findElements(By.tagName("span"));
		if (arr.length != li.size()) {
			flag = false;
			return flag;
		}
		for (int i = 0; i < arr.length; i++) {
			if (li.get(i).getText().equals(arr[i]))
				continue;
			else {
				flag = false;
				break;
			}
		}

		return flag;

	}

}
