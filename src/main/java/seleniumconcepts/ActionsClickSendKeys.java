package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickSendKeys {

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

		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		
		By fnName = By.id("input-firstname");
		By lnName = By.id("input-lastname");
		
		By btnContinue = By.xpath("//button[text()='Continue']");
		
		
		Actions act = new Actions(driver);
		
		act.sendKeys(driver.findElement(fnName), "firstname").perform();  // single action, so only perform().
		act.sendKeys(driver.findElement(lnName), "lastname").perform();
		//act.click(driver.findElement(btnContinue)).perform();
		act.moveToElement(driver.findElement(btnContinue)).perform();
		driver.findElement(btnContinue).click();
		
		
		
		

	}

}
