package seleniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		// WAP:
		// 1. print total links
		// 2. print the text of each link
		// 3. print href value of each link

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		options.merge(capabilities);
		driver = new ChromeDriver(options);

		ElementUtil eleUtil = new ElementUtil(driver);

		driver.get("https://amazon.com");

		System.out.println(driver.getTitle());

		List<WebElement> linkList = driver.findElements(By.tagName("a"));

		// 1. print total links
		System.out.println("Total Links are  " + linkList.size());

		// 2. print the text of each link
		// 3. print href value of each link
		
		
		//Using enhanced for loop
//		int indexLinkCounter = 0;
//		
//		for (WebElement link : total_links) {
//			
//			String linkText = link.getText();
//
//			if (!linkText.isEmpty()) {
//				System.out.println(indexLinkCounter + ":" + linkText);		
//			}	
//			
//			System.out.println(link.getAttribute("href"));
//			indexLinkCounter++;
//
//		}
		
		//Using index based for loop
		for (int i = 0; i < linkList.size(); i ++) {
			
			String linkText = linkList.get(i).getText();

			if (!linkText.isEmpty()) {
				System.out.println(i + ":" + linkText);
			}

			System.out.println(linkList.get(i).getAttribute("href"));
			
			
		}

	}

}
