package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

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

		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement sourceEle = driver.findElement(By.id("draggable"));
		
		WebElement targetEle = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		
//		//As multiple actions .build() is also required
//	    act.clickAndHold(sourceEle).moveToElement(targetEle)
//	    .release()  //Releases the mouse button at the last known mouse coordinates.
//	    .build()
//	    .perform();
		
		
		//second method 
		
		act.dragAndDrop(sourceEle, targetEle).perform();
		
		
		

	}

}
