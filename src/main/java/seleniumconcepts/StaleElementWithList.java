package seleniumconcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementWithList {

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

	
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("document.body.style.zoom = '80%';");
		
		// set the zoom level to 80% 
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		//js.executeScript("document.body.style.zoom='80%'");
		
		By footers = By.xpath("(//ul[@class='list-unstyled'])[8]//a");
		
    	List<WebElement>  footerList = driver.findElements(footers);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	
    	
    	for (int i = 0; i < footerList.size(); i++) {
    		List<WebElement> footerListNew = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footers));
    		js.executeScript("arguments[0].click();", footerListNew.get(i));
    		Thread.sleep(2000);
    		driver.navigate().back();  		
    	}

	}

}
