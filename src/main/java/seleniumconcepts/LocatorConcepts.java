package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcepts {
	
	static WebDriver driver;
	
	

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		options.merge(capabilities);
		driver = new ChromeDriver(options);
		
//		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		System.out.println(driver.getTitle());	
	

		
		//Approch 1 : not god practice
		//in by.id, id is static method, as we calling it from class name.method name.
//		driver.findElement(By.id("input-email")).sendKeys("test@aa.com"); 
//		driver.findElement(By.id("input-password")).sendKeys("abc123"); 
		
//		//Approch2: better than Approch 1 but still not best
//		
//		WebElement email = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		email.sendKeys("test@aa.com");
//		password.sendKeys("abc123");
		
		//Approch 3: by locator -  better approch
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement emailId = driver.findElement(email);
//		WebElement pwd = driver.findElement(password);
//		
//		pwd.sendKeys("test@aa.com");
//		pwd.sendKeys("abc123");
		
		
		//Approch 4 : By locator with generic methods
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		
//		
//		getElement(email).sendKeys("est@aa.com");
//		getElement(password).sendKeys("abc123");
		
//		
//		//Approch 5: By locator + getelement and action generic element
//		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(email, "est@aa.com");
//		doSendKeys(password, "abc123");
		
		
	  //Approch 6: By locator + getelement and action generic element from class(ElemetUtil)
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		
//		eleUtil.doSendKeys(email, "est@aa.com");
//		eleUtil.doSendKeys(password, "abc123");
		
		
	//Approch 7: STring locator with By,+ getelement and action generic element from class(ElemetUtil)
		
		String email = "input-email";
		String password = "input-password";
		
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id", email, "est@aa.com");
		eleUtil.doSendKeys("id", password, "abc123");
	}
		
		
		
		
		
	
		
		

	

}
