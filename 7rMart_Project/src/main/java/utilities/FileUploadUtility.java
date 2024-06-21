package utilities;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public static void  fileUploadSendkey(WebElement element, String path) {
		element.sendKeys(path);

}
}
