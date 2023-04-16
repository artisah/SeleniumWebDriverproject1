package seleniumconcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitforUrl {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// move to element
		// parent to child menu
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		options.merge(capabilities);
		driver = new ChromeDriver(options);

		ElementUtil eleUtil = new ElementUtil(driver);

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.findElement(By.linkText("Register")).click();
		String url = waitForUrlContains("account/register", 5);
		System.out.println(url);

	}

	public static String waitForUrlContains(String urlFraction, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		} else {
			return null;
		}

	}
	
	
	public static String waitForUrlToBe(String url, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		if (wait.until(ExpectedConditions.urlContains(url))) {
			return driver.getCurrentUrl();
		} else {
			return null;
		}

	}

}
