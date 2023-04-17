package seleniumconcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		//Implicitly Wait
		// Dynamic wait
		// Its only applicable for WebElements - FindElement or FindElements
		// not applicable for non web elements: title, url, alert etc
		//global wait

		//move to element
		//parent to child menu
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		options.merge(capabilities);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		
		// Due to implicitly wait and "Test
		// id is wrong, it will wait for 10 seconds before throwing "NoSuchElemetException Exception"
		WebElement emailId = driver.findElement(By.id("test"));
		emailId.sendKeys("AA@aaa.com");
	}
}
	
	