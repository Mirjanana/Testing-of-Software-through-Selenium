package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MealPage extends BasicPage{

	public MealPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getAddToCartButton() {
		return this.driver.findElement
				(By.xpath("//*[@id=\"body\"]/section[1]/div/div/div[2]/div/div[3]/div[2]/a"));
	}
	public WebElement getFavouriteMeal() {
		return this.driver.findElement(By.id("item_119"));
	}
	public WebElement quantityButton() {
		return this.driver.findElement(By.name("product_qty"));
	}
	public void addMealToCart(String quantity) {
		this.quantityButton().click();
		this.quantityButton().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		this.quantityButton().sendKeys(quantity);
		this.getAddToCartButton().click();
	}
	public void favouriteMeal() {
		this.getFavouriteMeal().click();
	}
}
