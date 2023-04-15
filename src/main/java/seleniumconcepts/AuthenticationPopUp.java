package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopUp {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		//move to element
		//parent to child menu
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		options.merge(capabilities);
		driver = new ChromeDriver(options);

		ElementUtil eleUtil = new ElementUtil(driver);
		
		// Pass username and password in get
		// used for server logins etc
		
		// username and password should not be having "@"
		
		String userName = "admin";
		String password = "admin";
		String url = "@the-internet.herokuapp.com/basic_auth";
				

		driver.get("https://" + userName + ":" + password + url);
		
		
		//Other approch to handle this is "CDP tool in Selenium 4 
		
	}

}
