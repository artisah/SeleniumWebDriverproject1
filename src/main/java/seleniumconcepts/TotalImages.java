package seleniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {

	static WebDriver driver;

	public static void main(String[] args) {

		// WAP:
		// 1. print total Images
		// 2. print the alt of each image
		// 3. print src value of each image

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

		By images = By.tagName("img");

		List<WebElement> imagesList = driver.findElements(images);

		// 1. print total images
		System.out.println("Total images are  " + imagesList.size());
		
		for (WebElement image : imagesList) {
			
			System.out.println("Image ALT Text is   " + image.getAttribute("alt"));
			System.out.println("Image SRC is   " + image.getAttribute("src"));
			
		}

	}

}
