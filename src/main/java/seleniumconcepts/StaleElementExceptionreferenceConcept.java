package seleniumconcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementExceptionreferenceConcept {

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

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By id = By.id("Form_getForm_Name");
		WebElement fn = driver.findElement(id);
		fn.sendKeys("abcd");
		driver.navigate().refresh();
		//fn.sendKeys("pqrs"); //stale element reference: element is not attached to the page document
		
		
		//Way 1: to handle stale element
//		fn = driver.findElement(id);
//		fn.sendKeys("pqrs");

		
		//WAy 2 handle stale element using FluentWait/WebDriverWait.
		FluentWait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(StaleElementReferenceException.class);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(id)).sendKeys("pqrs");
	}

}
