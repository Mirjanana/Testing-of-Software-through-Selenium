package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest{

	@Test (priority = 0)
	public void addMealToChart() throws InterruptedException {
		this.driver.get(baseUrl +"meal/lobster-shrimp-chicken-quesadilla-combo");
		this.locationPopUpPage.closeLocationPage();
		this.locationPopUpPage.getLocationHeader().click();
		this.mealPage.addMealToCart("3");
		String firstPartOfMessage = "The Following Errors Occurred:";
		String secondPartOfMessage= "Please Select Location";
		Assert.assertTrue(this.notifPage.showMessage().contains(firstPartOfMessage),
				"[ERROR]: Message for add to chart is not valid");
		Assert.assertTrue(this.notifPage.showMessage().contains(secondPartOfMessage),
				"[ERROR]: Message for add to chart is not valid");
		this.notifPage.waitUntilMessageDisapear();
		this.locationPopUpPage.addLocation("City Center - Albany");
		Thread.sleep(3000);
		this.mealPage.addMealToCart("2");
		String messageForAddedToCart = "Meal Added To Cart";
		Assert.assertTrue(this.notifPage.showMessage().contains(messageForAddedToCart),
			"[ERROR]: Message for add to chart is not valid");
	}
	@Test (priority = 1)
	public void addMealToFavourite() throws InterruptedException {
		this.driver.get(baseUrl +"meal/lobster-shrimp-chicken-quesadilla-combo");
		this.locationPopUpPage.closeLocationPage();
		//Thread.sleep(5000);
		this.mealPage.favouriteMeal();
		String message = "Please login first!";
		//Thread.sleep(10000);
		Assert.assertTrue(this.notifPage.showMessage().contains(message),
				"[ERROR]: Message for log in first is not valid");
		this.driver.get(baseUrl + "/guest-user/login-form");
		this.logInPage.userLogIn(email, password);
		this.driver.get(baseUrl +"meal/lobster-shrimp-chicken-quesadilla-combo");
		this.mealPage.favouriteMeal();
		//Thread.sleep(5000);
		String messageForFavouriteMeal = "Product has been added to your favorites.";
		Assert.assertTrue(this.notifPage.showMessage().contains(messageForFavouriteMeal),
				"[ERROR]: Message for favourite meal is not valid");
	}
	@Test (priority =2)
	public void clearChartTest() throws IOException, InterruptedException {
		this.driver.get(baseUrl + "meals");
		this.locationPopUpPage.addLocation("City Center - Albany");
		
		File file = new File("data/Data (2).xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("Meals");
		
		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			String mealUrl = sheet.getRow(i).getCell(0).getStringCellValue();
			double quantity = sheet.getRow(i).getCell(1).getNumericCellValue();

			this.driver.get(mealUrl);
			String quantityString = String.valueOf(quantity);
			this.mealPage.addMealToCart(quantityString);
			SoftAssert sa = new SoftAssert();
			String message = "Meal Added To Cart";
			sa.assertTrue(this.notifPage.showMessage().contains(message),
				"[ERROR]: Message for adding meal is not valid");
			this.cartSummeryPage.deleteAllFromCart();
			String messageForDeleting = "All meals removed from Cart successfully";
			sa.assertTrue(this.notifPage.showMessage().contains(messageForDeleting),
				"[ERROR]: Message for deleting from chart is not valid");
			
	}
		fis.close();
		wb.close();
	}
}
