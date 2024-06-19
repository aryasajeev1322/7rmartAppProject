package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SubCategorySearch {
	WebDriver driver;

	public SubCategorySearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'/admin/list-sub-category')and contains(@class,'small-box-footer')]")
	WebElement categories;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement category;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement subcatego;
	@FindBy(xpath = "//button[@value='sr']")
	WebElement searchin;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement searchtitle;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alerts;

	public void manageCategory() {
		categories.click();
	}

	public void search() {
		search.click();
	}

	public void entercategory(String categoryvalue) {
		Select select1 = new Select(category);
		select1.selectByVisibleText("Electronics");
	}

	public void entersubcategory(String categoryi) {
		subcatego.sendKeys(categoryi);
	}

	public void searched() {
		searchin.click();
	}

	public boolean alertin() {
		return alerts.isDisplayed();
	}

	public boolean Subcategorynamesearch(String titleseachin) {
		return searchtitle.getText().contains(titleseachin);
	}

}
