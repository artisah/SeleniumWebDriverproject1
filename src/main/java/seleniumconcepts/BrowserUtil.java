package seleniumconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * This method is used to initilized the driver
	 * 
	 * @param browser
	 * @return
	 */

	public WebDriver launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
//			Using downloaded Exe
//			System.setProperty("webdriver.chrome.driver", "/Users/development/downloads/chromedriver");
//			driver = new ChromeDriver();

//			Using WebDrivermanger
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*"); 
			
			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			options.merge(capabilities);
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "/Users/development/downloads/geckodriver");
//			driver = new FirefoxDriver();

			// UsingWebDrivermanager

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("safari")) {

			driver = new SafariDriver(); // for safari no need to set System.setproperty, its there in Selenium
		} else {
			System.out.println("Please pass correct browser" + browser);
		}

		return driver; // no browser name/browser name not in if condition, then null will be returned
	}

	/**
	 * This method navigates to passed url
	 * 
	 * @param url
	 */
	public void enterUrl(String url) {

		if (url.contains("http") || url.contains("https")) {
			driver.get(url);
		} else {
			System.out.println("Incorrect Url");
		}
	}

	/**
	 * return Page Title
	 * 
	 * @return
	 */

	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * This method return current page Url
	 * 
	 * @return
	 */
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void closeBrowser() {
		driver.close();
	}

}
