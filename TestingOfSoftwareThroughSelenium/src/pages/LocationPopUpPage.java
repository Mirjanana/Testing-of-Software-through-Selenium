package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopUpPage extends BasicPage{
	
	protected JavascriptExecutor executor;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public LocationPopUpPage(WebDriver driver,JavascriptExecutor executor) {
		super(driver);
		this.executor = executor;
	}
	public WebElement getLocationHeader () {
		return this.driver.findElement(By.xpath("//*[@class='location-selector']/a"));
	}
	public WebElement getButtonClose () {
		return this.driver.findElement(By.xpath("//*[@id=\"location-popup\"]/div/div/div/div/a"));
	}
	public WebElement getKeyword() {
		return this.driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}
	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	public WebElement getLocationInput() {
		return this.driver.findElement(By.xpath("//*[@id='location_id']"));
	}
	public WebElement getSubmit() {
		return this.driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}
	public void openLocation () {
		this.getLocationHeader().click();
	}
	public void addLocation (String locationName) {
		//this.getLocationHeader().click();
		this.getKeyword().click();
		String number = this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1];", getLocationInput(),number);
		js.executeScript("arguments[0].click();",getSubmit());
	}
	public void closeLocationPage() {
		getButtonClose().click();
	}
	

}
