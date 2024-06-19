package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginClass;
import pages.ManagePageClass;
import utilities.ExcelUtility;

public class ManagePageTest extends BaseClass {
 @Test
		public void verifyTheUserIsAbleToManagePage() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(1, 0, "login");
			String pwdvalue = ExcelUtility.getStringData(1, 1, "login");
			LoginClass loginclass = new LoginClass(driver);
			loginclass.enterUserName(usernamevalue);
			loginclass.enterPassword(pwdvalue);
			loginclass.signin();
			
			String titlevalue = ExcelUtility.getStringData(1, 0, "Managepage");
			ManagePageClass manages = new ManagePageClass  (driver);
			manages.manage();
			manages.search();
			manages.entertitle(titlevalue);
			manages.searches();
			boolean pageTitleSearchIsFound = manages.managed();
			assertTrue(pageTitleSearchIsFound," Constants.ERRORMESSAGEFORUSER");
			
		}

		
		}

