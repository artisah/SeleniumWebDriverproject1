package seleniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick {

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

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		Actions act = new Actions(driver);
		
		//Right Click element
		act.contextClick(rightClickEle).perform();
		
		List<WebElement> ContextMenuOptions = driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[contains(@class, 'context-menu-icon')]"));
		
		
		for ( WebElement e : ContextMenuOptions) {
			String text = e.getText();
			System.out.println(text);
			
			if (text.equals("Copy")) {
				e.click();
				break;
				
			}
		}
	}

}
