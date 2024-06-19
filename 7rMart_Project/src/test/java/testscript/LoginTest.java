package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginClass;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass {
	/*
	 * @DataProvider(name="Credentials") public Object[][] testData() {// data
	 * provider Object[][] input = new Object[2][2]; input[0][0] = "admin";
	 * input[0][1] = "admin"; input[1][0] = "admin@123"; input[1][1] = "admin123";
	 * return input; }
	 */
	@Test(groups = {
			"regression" }/* dataProvider = "Credentials" */, description = "verify user is able to login valid crenditials")
	
	public void verifyTheUserAbleToLoginValidCredentials(/* String name,String password */) throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "login");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "login");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUserName(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.signin();
		boolean homepageisloaded = loginclass.dashboard();
		assertTrue(homepageisloaded, "homepage is not loaded properly");

	}

	@Test(description="verify user is able to login valid password crenditials")
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

	@Test(description="verify user is able to login valid username crenditials")
	@Parameters({ "username", "password" })
	public void verifyTheInvalidUsername(String usernames, String passwords) throws IOException {
		String usernamevalue = ExcelUtility.getStringData(3, 0, "login");
		String pwdvalue = ExcelUtility.getStringData(3, 1, "login");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUserName(usernames);
		loginclass.enterPassword(passwords);
		loginclass.signin();
		boolean alertdisplayed = loginclass.alert();
		assertTrue(alertdisplayed, "alert is not displayed");

	}

	@Test(retryAnalyzer = retry.Retry.class,description="verify user is able to login invalid crenditials")
	public void verifyTheInvalidCredentials()throws IOException {
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
