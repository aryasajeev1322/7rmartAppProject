package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePageClass {
	WebDriver driver;

	public ManagePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-page')and contains(@class,'small-box-footer')]")
	WebElement managepage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	@FindBy(xpath = "//input[@type='text']")
	WebElement title;
	@FindBy(xpath = "//button[@value='sr']")
	WebElement searchin;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alerts;

	public void manage() {
		managepage.click();
	}

	public void search() {
		search.click();
	}

	public void entertitle(String titles) {
		title.sendKeys(titles);
	}

	public void searches() {
		searchin.click();
	}

	public boolean alertin() {
		return alerts.isDisplayed();
	}

	public boolean managed() {
		return managepage.isDisplayed();
	}

}
