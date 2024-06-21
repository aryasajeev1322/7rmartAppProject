package testscript;

import utilities.ScreenshotCaptureUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
	public ScreenshotCaptureUtility screenshot;
	public Properties properties;
	public FileInputStream fis;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void intializeBrowser(String browser) throws Exception {
		try {
			properties=new Properties();
			fis=new FileInputStream(Constants.CONFIGFILE);
			properties.load(fis);
		}
		catch(FileNotFoundException ecxception) {
			ecxception.printStackTrace();
		}
		
		driver = new ChromeDriver();
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("browser is not correct");
		}

		
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void browserQuit(ITestResult itestresult) throws IOException {
		// driver.close();
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			screenshot = new ScreenshotCaptureUtility();
			screenshot.captureFailureScreenShot(driver, itestresult.getName());
		}
	}
}
