package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload;

public class ManagePageAddUser {

	WebDriver driver;

	public ManagePageAddUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-page')and contains(@class,'small-box-footer')]")
	WebElement managepages;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement new_button;
	@FindBy(id = "title")
	WebElement add_title;
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement add_description;
	@FindBy(id = "page")
	WebElement add_page;
	@FindBy(id = "main_img")
	WebElement choose_file;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement submit_button;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public void managePage() {
		managepages.click();
	}

	public void click_new_button() {
		new_button.click();
	}

	public void enter_title(String titlename) {
		add_title.sendKeys(titlename);
	}

	public void enter_description(String descrip) {
		add_description.sendKeys(descrip);
	}

	public void enter_page(String pagename) {
		add_page.sendKeys(pagename);
	}

	public void choosefile(String location) {

		FileUpload.fileUploadSendkey(choose_file, location);
	}

	public void save_button() {
		submit_button.click();

	}

	public boolean alert() {
		return alert.isDisplayed();

	}

}
