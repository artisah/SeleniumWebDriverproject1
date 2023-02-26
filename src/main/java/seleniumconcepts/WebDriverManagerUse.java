package seleniumconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author development
 *
 */

public class WebDriverManagerUse {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		/*
		 * WebDriverManager.chromedriver().setup();
		 * WebDriverManager.firefoxdriver().setup();
		 * WebDriverManager.edgedriver().setup();
		 * WebDriverManager.operadriver().setup();
		 * WebDriverManager.chromiumdriver().setup()
		 * WebDriverManager.iedriver().setup();
		 */

		/*
		 * As of version 5, WebDriverManager also provides a manager for Safari (called
		 * safaridriver()). The case of the Safari browser is particular since this
		 * browser does not require to manage its driver to work with Selenium WebDriver
		 * (in other words, the Safari driver is built-in within the browser).
		 * Nevertheless, WebDriverManager provides this manager to be used in the
		 * WebDriver builder (especially with Docker).
		 */

		/* if you want any particulat driverversion/browser version 
		 * 
		 * WebDriverManager.chromedriver().driverVersion("81.0.4044.138").setup();
		 * WebDriverManager.firefoxdriver().browserVersion("75").setup();
		 */
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");
		System.out.println(driver.getTitle());

		driver.quit();

	}

}
