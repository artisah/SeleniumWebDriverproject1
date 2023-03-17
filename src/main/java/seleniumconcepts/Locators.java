package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		//There are total 8 locators: id, name, classname, xpath, cssselector, linktext, partiallinktext, tagname
		
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
		
		
		//1. By ID: ALways Unique
		   //driver.findElement(By.id("input-email")).sendKeys("test@aa.com"); 
		
		//2, By Name : Can be Duplicate
		//driver.findElement(By.name("email")).sendKeys("test@aa.com"); 
		
		// 3. By classname: Can be duplicate
		//driver.findElement(By.className("form-control")).sendKeys("test@aa.com"); 
		
		//4. By Xpath
//		driver.findElement(By.xpath("//*[@id = 'input-email']")).sendKeys("test@aa.com"); 
//		driver.findElement(By.xpath("//button[text() = 'Login']")).click();
		
		
		//5. By CSSSelector
//	//	driver.findElement(By.cssSelector("#input-email")).sendKeys("test@aa.com");
//		
//		By emailId = By.cssSelector("#input-email");
//		By pwd = By.cssSelector("#input-password");
//		By loginBtn = By.cssSelector("#form-login > button");
//		
//		
//		eleUtil.doSendKeys(emailId, "test@aa.com");
//		eleUtil.doSendKeys(pwd, "abcd");
//		eleUtil.doClick(loginBtn);
		
		//6 by linktext
//		driver.findElement(By.linkText("Register")).click();	
		
		//7 by Partial LinkText
//		driver.findElement(By.partialLinkText("Forgotten")).click();	
		
		//8 By tagname
		By tagnameValue = By.tagName("h2");
		String h2Text = eleUtil.doGetText(tagnameValue);    //driver.findElement(By.tagName("h2")).getText();
		System.out.println(h2Text);
		
		//Difference getText vs getAttribute
		By emailId = By.cssSelector("#input-email");
		eleUtil.doSendKeys(emailId, "test@aa.com");
		String valueOfAttribute = eleUtil.doGetAttributr(emailId, "value");
		System.out.println(valueOfAttribute);
		
		
		
		

	}

}
