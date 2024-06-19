package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginClass;
import pages.CategoryClass;
import utilities.ExcelUtility;

public class CategoryTest extends BaseClass {
	@Test
	public void verifyTheUserAbleToLoginValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "login");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "login");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUserName(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.signin();

		String categoryvalue = ExcelUtility.getStringData(1, 0, "ManageCategorySearch");
		CategoryClass managecategory = new CategoryClass(driver);
		managecategory.manage_category();
		managecategory.click_search();
		managecategory.enter_category(categoryvalue);
		managecategory.search_button();
		boolean pageTitleSearchIsFound = managecategory.managedd(categoryvalue);
		assertTrue(pageTitleSearchIsFound, " Constants.ERRORMESSAGEFORUSER");

	}
}
