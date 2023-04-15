package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

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

		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
		
		WebElement contentParent = driver.findElement(By.className("menulink"));
		
		//move to mainm menu
		
		Actions act = new Actions(driver);
		
		act.moveToElement(contentParent).perform(); // perform()OR build().perform() is neccessary for action 
		//act.moveToElement(contentParent).build().perform(); //if multiple actions then build().perform()
		Thread.sleep(3000);
		
		
		//Always use text displayed in UI not in DOm for linktext(as in this case dom it displayed lowercase but on Ui uppercase.
		driver.findElement(By.linkText("COURSES")).click();
		
	}

}
