package tests;



import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{

	
	@Test (priority =2)
	public void editProfileTest () throws InterruptedException {
		this.driver.get(baseUrl + "/guest-user/login-form");
		this.locationPopUpPage.closeLocationPage();
		this.logInPage.userLogIn(email, password);
		String messageLogIn = "Login Successfull";
		Assert.assertTrue(this.notifPage.showMessage().contains(messageLogIn), 
				"[ERROR]: Message for logIn is not valid");
		this.driver.navigate().to(baseUrl + "/member/profile");
		this.profilePage.changeDataOfUser("Mirjana", "Arezina", "Njegoseva 7", "062-987-654", "10000", 
				2, 2, 1);
		String messageSetupSuccessful = "Setup Successful";
		Assert.assertTrue(this.notifPage.showMessage().contains(messageSetupSuccessful),
				"[ERROR]: Change of data are not done properly");
		this.authPage.logOut();
		Assert.assertEquals(this.notifPage.showMessage(), "Logout Successfull!",
				"[ERROR]: Log out is not done properly");
	}
	@Test (priority =3)
	public void changeProfileImageTest() throws IOException, InterruptedException {
		this.driver.get(baseUrl + "/guest-user/login-form");
		this.locationPopUpPage.closeLocationPage();
		this.logInPage.userLogIn(email, password);
		String messageLogIn = "Login Successfull";
		Assert.assertTrue(this.notifPage.showMessage().contains(messageLogIn), 
				"[ERROR]: Message for logIn is not valid");
		this.driver.navigate().to(baseUrl + "/member/profile");
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
		this.authPage.logOut();
		Assert.assertEquals(this.notifPage.showMessage(), "Logout Successfull!",
				"[ERROR]: Log out is not done properly");
	}

}
