package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends BasicPage{

	public LogInPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getUsername () {
		this.driver.findElement(By.name("username")).clear();
		return this.driver.findElement(By.name("username"));
	}
	public WebElement getPassword () {
		this.driver.findElement(By.name("password")).clear();
		return this.driver.findElement(By.name("password"));
	}
	public WebElement getButtonSubmitLogIn () {
		return this.driver.findElement(By.name("btn_submit"));
	}
	public void userLogIn(String username, String password) {
		this.getUsername().sendKeys(username);
		this.getPassword().sendKeys(password);
		this.getButtonSubmitLogIn().click();
	}
}
