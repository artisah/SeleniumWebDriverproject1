package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementExceptionConcept {
	
		static WebDriver driver;

		public static void main(String[] args) {
			
			
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*"); 
			
			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			options.merge(capabilities);
			driver = new ChromeDriver(options);
			
			ElementUtil eleUtil = new ElementUtil(driver);
			
			
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			
			System.out.println(driver.getTitle());	
			
			By Email = By.id("input-email1");  

			// org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: 
			
			eleUtil.doSendKeys(Email, "test@test.com");
			
			

	}

}
