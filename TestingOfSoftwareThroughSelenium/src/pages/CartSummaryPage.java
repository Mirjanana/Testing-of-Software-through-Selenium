package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartSummaryPage extends BasicPage{

	public CartSummaryPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getClearAllButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"cartSummary\"]/div/div[1]/a[2]"));
	}
	public void deleteAllFromChart() {
		this.getClearAllButton().click();
	}

}
