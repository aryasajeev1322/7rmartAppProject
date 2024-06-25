package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginClass;
import pages.AdminUsers;
import utilities.ExcelUtility;

public class AdminUsersTest extends BaseClass {
	@Test
	public void verifyTheUserAbleToLoginValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "login");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "login");

		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUserName(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.signin();

		String username = ExcelUtility.getStringData(1, 0, "AdminUser");
		String usertype = ExcelUtility.getStringData(1, 1, "AdminUser");
		AdminUsers manageuserpage = new AdminUsers(driver);
		manageuserpage.manageUsers();
		manageuserpage.search();
		manageuserpage.entername( username);
		manageuserpage.selectUserType(usertype );
		manageuserpage.searchbutton();

		boolean isUserFound = manageuserpage.isUserInSearchResults(username);
		assertTrue(isUserFound, "User not found in search results!");

	}

}
