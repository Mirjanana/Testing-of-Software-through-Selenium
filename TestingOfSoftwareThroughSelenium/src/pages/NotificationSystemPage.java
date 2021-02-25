package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage{

	protected WebDriverWait waiter;
	
	public NotificationSystemPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getMessage() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or "
				+ "contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}
	public String showMessage () {
		return this.getMessage().getText();
	}
	public void waitUntilMessageDisapear() {
		this.waiter = new WebDriverWait(driver, 30);
		waiter.until(ExpectedConditions.attributeContains(this.driver.findElement(By.xpath("//*[contains(@class, 'system_message')]")), "style", "display: none;"));
	}

}
