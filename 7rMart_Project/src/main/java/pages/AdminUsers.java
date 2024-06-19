package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsers {
	WebDriver driver;

	public AdminUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement manageusers;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement firstsearch;
	@FindBy(xpath = "//input[@name='un']")
	WebElement uname;
	@FindBy(id = "ut")
	WebElement usertype;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	WebElement submit;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement searchResultTitle;

	public void manageUsers() {
		manageusers.click();
	}

	public void search() {
		firstsearch.click();
	}

	public void entername(String username) {
		uname.sendKeys("Zayn");
	}

	public void selectUserType() {
		Select select = new Select(usertype);
		select.selectByIndex(1);
	}

	public void searchbutton() {
		submit.click();
	}

	public boolean isUserInSearchResults(String userName) {
		return searchResultTitle.getText().contains(userName);

	}
}