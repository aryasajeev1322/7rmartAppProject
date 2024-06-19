package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews {
	WebDriver driver;
	public  ManageNews(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	} 
	@FindBy(css = "a.small-box-footer[href*='/admin/list-news']")
	WebElement manage_news;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement search;
	@FindBy(xpath="//input[@class='form-control']")WebElement title;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement search_button;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")WebElement searchtitle;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;
	public void managenews() {
		manage_news.click();	
		}
	public void search() {
		search.click();
	}
	public void enter_title(String titles) {
		title.sendKeys(titles);
	}
	public void click_searchbutton() {
		search_button.click();
		
	}
	public boolean managedd(String search_title) {
	return searchtitle.getText().contains(search_title);
}
	public boolean alert() {
		return alert.isDisplayed();

	}
	

}
