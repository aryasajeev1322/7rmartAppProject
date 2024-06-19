package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {

	WebDriver driver;

	public LoginClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement uname;
	@FindBy(xpath = "//input[@name='password']")
	WebElement pswd;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signin;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;
	


	public void enterUserName(String username) {
		uname.sendKeys(username);
	}

	public void enterPassword(String password) {
		pswd.sendKeys(password);
	}

	public void signin() {
		signin.click();
	}

	public boolean dashboard() {
		return dashboard.isDisplayed();

	}
	public boolean alert() {
		return alert.isDisplayed();

	}
	

}
