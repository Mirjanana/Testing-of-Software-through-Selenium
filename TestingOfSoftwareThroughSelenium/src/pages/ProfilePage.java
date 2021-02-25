package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage extends BasicPage{

	protected JavascriptExecutor executor;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	public WebElement getFirstName() {
		this.driver.findElement(By.name("user_first_name")).clear();
		return this.driver.findElement(By.name("user_first_name"));
	}
	public WebElement getLastName() {
		this.driver.findElement(By.name("user_last_name")).clear();
		return this.driver.findElement(By.name("user_last_name"));
	}
	public WebElement getAddress() {
		this.driver.findElement(By.name("user_address")).clear();
		return this.driver.findElement(By.name("user_address"));
	}
	public WebElement getPhone() {
		this.driver.findElement(By.name("user_phone")).clear();
		return this.driver.findElement(By.name("user_phone"));
	}
	public WebElement getZipCode() {
		this.driver.findElement(By.name("user_zip")).clear();
		return this.driver.findElement(By.name("user_zip"));
	}
	public Select getUserCounty() {
		Select element = new Select(this.driver.findElement(By.name("user_country_id")));
		return element;
	}
	public Select getUserState() {
		Select element = new Select(this.driver.findElement(By.name("user_state_id")));
		return element;
	}
	public Select getUserCity() {
		Select element = new Select(this.driver.findElement(By.name("user_city")));
		return element;
	}
	public WebElement getButtonSave() {
		return this.driver.findElement(By.name("btn_submit"));
	}
	public WebElement getUploadPicture() {
		//return this.driver.findElement(By.xpath("//*[@id=\"profileInfo\"]/div/div[1]/div/a"));
		return this.driver.findElement(By.xpath("//a[@title='Uplaod']"));
	}
	public WebElement getRemovePicture() {
		return this.driver.findElement(By.className("remove"));
	}
	public void getInputType() {
		js.executeScript("arguments[0].click();",getUploadPicture() );
	}
	public void uploadPicture (String imgPath) {
		getInputType();
		this.driver.findElement(By.xpath("//input[@type='file']")).sendKeys(imgPath);
		//pozvati test, da bi uhvatila polje input i prosledila mu ovaj String
	}
	public void removePicture() {
		js.executeScript("arguments[0].click();",getRemovePicture());
	}
	public void changeDataOfUser(String userName, String lastName, String address, String phoneNumber,
			String zipCode, int country, int state, int city) throws InterruptedException {
		this.getFirstName().sendKeys(userName);
		this.getLastName().sendKeys(lastName);
		this.getAddress().sendKeys(address);
		this.getPhone().sendKeys(phoneNumber);
		this.getZipCode().sendKeys(zipCode);
		this.getUserCounty().selectByIndex(country); 
		Thread.sleep(2000);
		this.getUserState().selectByIndex(state);
		Thread.sleep(10000);
		this.getUserCity().selectByIndex(city);
		this.getButtonSave().click();
	}
}
