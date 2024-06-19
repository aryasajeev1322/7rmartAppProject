package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.FileUpload;

public class SubCategoryAdd {
	WebDriver driver;

	public SubCategoryAdd(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.small-box-footer[href*='/admin/list-sub-category']")
	WebElement sub_category;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement enternew;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement category;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement subcatego;
	@FindBy(xpath = "//input[@type='file']")
	WebElement images;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saved;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alerts;

	public void manageCategoryNew() {
		sub_category.click();
	}

	public void newCategory() {
		enternew.click();
	}

	public void entercategory(String categoryvalue) {
		Select select1 = new Select(category);
		select1.selectByVisibleText("Electronics");
	}

	public void entersubcategory(String categoryi) {
		subcatego.sendKeys(categoryi);
	}

	public void imageupload(String image) {

		FileUpload.fileUploadSendkey(images, image);
	}

	public void savedin() {
		saved.click();
	}

	public boolean alertin() {
		return alerts.isDisplayed();
	}

	public boolean newCategoryAdd() {
		return sub_category.isDisplayed();
	}
}
