package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryClass {

	WebDriver driver;
	public  CategoryClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	} 
	@FindBy(css = "a.small-box-footer[href*='/admin/list-category']")
	WebElement manage_category;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement search;
	@FindBy(xpath="//input[@class='form-control']")WebElement category;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement search_button;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement searchResultCategory;
	public void manage_category() {
		manage_category.click();
	}
	public void click_search() {
		search.click();
	}
	public void enter_category(String cate) {
		category.sendKeys(cate);
	}
	public void search_button() {
		search_button.click();
	}
	public boolean managedd(String search_category) {
		return searchResultCategory.getText().contains(search_category);
	}
}
