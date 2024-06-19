package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginClass;
import pages.SubCategoryAdd;

import utilities.ExcelUtility;

public class SubCategoryAddTest extends BaseClass {
  @Test
  public void verifyTheUserAbleToLoginValidCredentials() throws IOException {
		 String usernamevalue = ExcelUtility.getStringData(1, 0, "login");
	     String pwdvalue = ExcelUtility.getStringData(1, 1, "login");
	     
	     	LoginClass loginclass = new LoginClass(driver);
	        loginclass.enterUserName(usernamevalue);
	        loginclass.enterPassword(pwdvalue);
	        loginclass.signin();
	        
	        String categoryvalue = ExcelUtility.getStringData(1, 0, "SubCategoryAddItem");
			String subcategoryvalue = ExcelUtility.getStringData(1, 1, "SubCategoryAddItem");
			String imagevalue = ExcelUtility.getStringData(1, 2, "SubCategoryAddItem");
			SubCategoryAdd categors = new SubCategoryAdd(driver);
			
			categors.manageCategoryNew();
			categors.newCategory();
			categors.entercategory(categoryvalue);
			categors.entersubcategory(subcategoryvalue);
			categors.imageupload(imagevalue);
			categors.savedin();
			boolean subcategoryuserAdded= categors.alertin();
			assertTrue(subcategoryuserAdded ,"subcategoryuserisnotAdded");
			
			
  }
   
  }
