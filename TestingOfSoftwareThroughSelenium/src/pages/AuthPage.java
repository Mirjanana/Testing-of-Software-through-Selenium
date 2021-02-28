package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasicPage{

	public AuthPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getProfileButton() {
		return this.driver.findElement
				(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li/a"));
	}
	public WebElement getMyAccountButton () {
		return this.driver.findElement
				(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li/div/ul/li[1]/a"));
	}
	public WebElement getLogOut() {
		return this.driver.findElement
				(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li/div/ul/li[2]/a"));
	}
	public void logOut() {
		this.getProfileButton().click();;
		this.getLogOut().click();
	}
}
