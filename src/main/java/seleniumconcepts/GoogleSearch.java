package seleniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		options.merge(capabilities);
		driver = new ChromeDriver(options);

		ElementUtil eleUtil = new ElementUtil(driver);

		driver.get("https://www.google.com/");

	//	System.out.println(driver.getTitle());
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		Thread.sleep(3000);
		
		List<WebElement> suggestionList = driver.findElements(By.xpath("//ul[@role='listbox']//div[contains(@class,'wM6W7d')]//span"));
		
		System.out.println(suggestionList);
		
		for (WebElement suggeston : suggestionList) {
			
			String text = suggeston.getText();
			System.out.println(text);
			
			if (text.equals("selenium python")) {
				System.out.println("The Search Text is found  " + text);
				suggeston.click();
				break;
			}
			
		}
		
		
		
	}
}
