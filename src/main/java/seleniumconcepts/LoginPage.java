package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public static void main(String[] args) {
		
		By email = By.id("input-email");
		By password = By.id("input-password");
		
		BrowserUtil browserUtil = new BrowserUtil();
		WebDriver driver = browserUtil.launchBrowser("chrome");
		
        driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		System.out.println(driver.getTitle());	
		
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doSendKeys(email, "est@aa.com");
		eleUtil.doSendKeys(password, "abc123");
		
		browserUtil.closeBrowser();
	
		
		
	}

}
