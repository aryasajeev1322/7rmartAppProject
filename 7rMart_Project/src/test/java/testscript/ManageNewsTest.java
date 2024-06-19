package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginClass;
import pages.ManageNews;
import utilities.ExcelUtility;

public class ManageNewsTest extends BaseClass {
	@Test
	public void verifyTheUserAbleToLoginValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "login");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "login");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUserName(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.signin();
		
		String titlevalue = ExcelUtility.getStringData(1, 0, "manage_news");
		ManageNews managenews = new ManageNews(driver);
		managenews.managenews();
		managenews.search();
		managenews.enter_title(titlevalue);
		managenews.click_searchbutton();
		boolean managenewspage = managenews.managedd(titlevalue);
		assertTrue(managenewspage,"manage news  is not loaded properly ");
	}
}
