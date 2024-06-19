package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminUsersAdd;
import pages.LoginClass;
import utilities.ExcelUtility;

public class AdminUsersAddTest extends BaseClass {
  @Test
  public void adminSearchPage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "login");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "login");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUserName(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.signin();
		String usernamevalues =ExcelUtility.getStringData(1, 0, "AdminPageAddUsers");
		String passwordvalues = ExcelUtility.getStringData(1, 1, "AdminPageAddUsers");
		String usertypevalues = ExcelUtility.getStringData(1, 2, "AdminPageAddUsers");
		AdminUsersAdd admins = new AdminUsersAdd (driver);
		admins.adminpaged();
		admins.enternew();
		admins.enterusername(usernamevalues);
		admins.enterpassword(passwordvalues);
		admins.enterusertype(usertypevalues);
		admins.savein();
		boolean adminpageuserisadded = admins.admin();
		assertTrue(adminpageuserisadded , " Constants.ERRORMESSAGEFORUSER");
		
		
		
}
}

