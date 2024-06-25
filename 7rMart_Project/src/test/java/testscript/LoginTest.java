package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginClass;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass {

	@Test(groups = { "regression" }, description = "verify user is able to login valid crenditials")

	public void verifyTheUserAbleToLoginValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "login");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "login");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUserName(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.signin();
		boolean homepageisloaded = loginclass.dashboard();
		assertTrue(homepageisloaded, "homepage is not loaded properly");

	}

	@Test(description = "verify user is able to login valid password crenditials")
	@Parameters("browser")
	public void verifyTheInvalidPassword(String browser) throws IOException {
		String usernamevalue = ExcelUtility.getStringData(2, 0, "login");
		String pwdvalue = ExcelUtility.getStringData(2, 1, "login");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUserName(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.signin();
		boolean alertdisplayed = loginclass.alert();
		assertTrue(alertdisplayed, "alert is not displayed");

	}

	@Test(description = "verify user is able to login valid username crenditials")
	@Parameters({ "username", "password" })
	public void verifyTheInvalidUsername(String usernames, String passwords) throws IOException {
		
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUserName(usernames);
		loginclass.enterPassword(passwords);
		loginclass.signin();
		boolean alertdisplayed = loginclass.alert();
		assertTrue(alertdisplayed, "alert is not displayed");

	}

	@Test(retryAnalyzer = retry.Retry.class, description = "verify user is able to login invalid crenditials")
	public void verifyTheInvalidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(4, 0, "login");
		String pwdvalue = ExcelUtility.getStringData(4, 1, "login");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUserName(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.signin();
		boolean alertdisplayed = loginclass.alert();
		assertTrue(alertdisplayed, "alert is not displayed ");

	}
}
