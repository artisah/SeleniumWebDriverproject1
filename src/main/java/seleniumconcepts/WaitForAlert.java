package seleniumconcepts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlert {

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

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.name("proceed")).click();
		
//		driver.findElement(By.name("proceed")).click();
//		driver.switchTo().alert(); // if alert not present, it will give NoAlertPresentException
		
//		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
//		
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // No need to write driver.switchTo().alert().
//		
//		alert.accept();
		
		waitForAlert(5);
		acceptAlert(5);
			
	}
	
	public static Alert  waitForAlert(int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return  wait.until(ExpectedConditions.alertIsPresent()); // No need to write driver.switchTo().alert().
	}
	
	public static String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();	
	}
	
	public static void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}
	
	public static void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	
	// Write method for waitforlementPresenceByFluentWait
	
	

}
