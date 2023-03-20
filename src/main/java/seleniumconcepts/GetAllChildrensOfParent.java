package seleniumconcepts;

import java.awt.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllChildrensOfParent {

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

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		System.out.println(driver.getTitle());

		By footerLinksList = By.xpath("//footer//a");
		
		java.util.List<String> hrefList = eleUtil.getElementsAttributeList(footerLinksList, "href");
		
		for (String href : hrefList) {
			System.out.println(href);
		}
		

//		java.util.List<WebElement> eleList = driver.findElements(footerLinksList);
//		java.util.List<String> eleAttrList = new ArrayList();
//
//		System.out.println(eleList);
//
//		for (WebElement e : eleList) {
//			String attrVal = e.getAttribute("href");
//			if (!attrVal.isEmpty()) {
//				System.out.println(attrVal);
//				eleAttrList.add(attrVal);
//			}
//		}

	}
}
