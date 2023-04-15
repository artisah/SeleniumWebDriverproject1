package seleniumconcepts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		//Javascript pop up - also called pop up/modal pop up
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		options.merge(capabilities);
		driver = new ChromeDriver(options);

		ElementUtil eleUtil = new ElementUtil(driver);

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.name("proceed")).click();
		
		//Alert will pop up
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		
		System.out.println(text);
		
		alert.accept(); // Click on "Ok" button
		//alert.dismiss(); // cancel pop up ,just like clciking esc key	
		
		//alert.sendKeys("testing");
		
		
	}

}
