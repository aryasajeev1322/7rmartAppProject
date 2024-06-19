package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginClass;
import pages.ManagePageAddUser;
import utilities.ExcelUtility;

public class ManagePageAddUserTest extends BaseClass {
	@Test
	public void verifyTheUserAbleToLoginValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "login");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "login");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUserName(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.signin();

		String title = ExcelUtility.getStringData(1, 0, "ManagePgeAddUser");
		String Descriptionval = ExcelUtility.getStringData(1, 1, "ManagePgeAddUser");
		String pagevalue = ExcelUtility.getStringData(1, 2, "ManagePgeAddUser");
		String imagevalue = ExcelUtility.getStringData(1, 3, "ManagePgeAddUser");
		ManagePageAddUser managepagadduser = new ManagePageAddUser(driver);
		managepagadduser.managePage();
		managepagadduser.click_new_button();
		managepagadduser.enter_title(title);
		managepagadduser.enter_description(Descriptionval);
		managepagadduser.enter_page(pagevalue);
		managepagadduser.choosefile(imagevalue);
		managepagadduser.save_button();
		boolean managepagealert = managepagadduser.alert();
		assertTrue(managepagealert, Constants.MANAGEPAGEUSERADD);

	}

}
