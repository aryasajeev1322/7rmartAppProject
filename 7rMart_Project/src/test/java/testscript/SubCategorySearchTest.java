package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;


import pages.LoginClass;

import pages.SubCategorySearch;

import utilities.ExcelUtility;

public class SubCategorySearchTest extends BaseClass {
  @Test(description="verify categoryname is able to locate Subcategory page")
  public void subCategoryPage() throws IOException {
	  String usernamevalue = ExcelUtility.getStringData(1, 0, "login");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "login");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUserName(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.signin();
		
		String categoryvalue = ExcelUtility.getStringData(1, 0, "SubCateSearch");
		String subcategoryvalue = ExcelUtility.getStringData(1, 1, "SubCateSearch");
		SubCategorySearch categors = new SubCategorySearch(driver);
		categors.manageCategory();
		categors.search();
		categors.entercategory(categoryvalue);
		categors.entersubcategory(subcategoryvalue);
		categors.searched();
		boolean categorynameisFound= categors.Subcategorynamesearch(subcategoryvalue);
		assertTrue(categorynameisFound ," Constants.ERRORMESSAGEFORSUBCATEGORYSEARCH");
		
		
}
}
