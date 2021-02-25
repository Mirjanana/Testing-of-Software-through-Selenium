package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopUpPage;
import pages.LogInPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;


public abstract class BasicTest {

	protected String baseUrl="http://demo.yo-meals.com/";
	protected String email = "customer@dummyid.com";
	protected String password = "12345678a";
	protected WebDriver driver;
	protected LocationPopUpPage locationPopUpPage;
	protected JavascriptExecutor executor;
	protected LogInPage logInPage;
	protected NotificationSystemPage notifPage;
	protected ProfilePage profilePage;
	protected AuthPage authPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSummeryPage;
	
	@BeforeClass
	public void setUp () {
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		//this.waiter = new WebDriverWait(driver, 30);
		this.logInPage = new LogInPage(driver);
		this.locationPopUpPage = new LocationPopUpPage(driver, executor);
		this.notifPage = new NotificationSystemPage(driver);
		this.profilePage = new ProfilePage (driver);
		this.authPage = new AuthPage (driver);
		this.mealPage=new MealPage(driver);
		this.cartSummeryPage = new CartSummaryPage(driver);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod 
	public void screenShots () {
		
	}
//	@AfterClass
//	public void closeAplication () {
//		this.driver.close();
//	}

}
