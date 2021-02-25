package tests;



import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{

	@BeforeClass
	public void logInTest () {
		this.driver.get(baseUrl + "/guest-user/login-form");
		this.locationPopUpPage.closeLocationPage();
		this.logInPage.userLogIn(email, password);
		Assert.assertEquals(this.notifPage.showMessage(), "Login Successfull",
				"[ERROR]: Message for logIn is not valid");
		this.driver.navigate().to(baseUrl + "/member/profile");
	}
	@Test
	public void editProfileTest () throws InterruptedException {
		this.profilePage.changeDataOfUser("Mirjana", "Arezina", "Njegoseva 7", "062-987-654", "10000", 2, 3, 1);
		Assert.assertEquals(this.notifPage.showMessage(), "Setup Successful",
				"[ERROR]: Change of data are not done properly");
	}
	@Test
	public void changeProfileImageTest() throws IOException, InterruptedException {
		String imgPath = new File("img/slika2.jpg").getCanonicalPath();
		this.profilePage.uploadPicture(imgPath);
		Thread.sleep(3000);
		Assert.assertEquals(this.notifPage.showMessage(), "Profile Image Uploaded Successfully",
				"[ERROR]: Update of profile picture is not done properly");
		Thread.sleep(3000);
		this.notifPage.waitUntilMessageDisapear();
		this.profilePage.removePicture();
		Assert.assertEquals(this.notifPage.showMessage(), "Profile Image Deleted Successfully",
				"[ERROR]: Removal of profile picture is not done properly");
		this.notifPage.waitUntilMessageDisapear();
	}
	@AfterClass
	public void logOut() {
		this.authPage.logOut();
		Assert.assertEquals(this.notifPage.showMessage(), "Logout Successfull!",
				"[ERROR]: Log out is not done properly");
	}
}
