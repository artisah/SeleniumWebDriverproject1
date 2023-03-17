package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterPage {

	static WebDriver driver;

	public static void main(String[] args) {
		
		By registerLink = By.linkText("Register");
		
		By firstName = By.id("input-firstname");	
		By lastname = By.name("lastname");
		By email = By.xpath("//input[@type='email'and @name='email']");
		By password = By.cssSelector("#input-password");
		//By newletterRadio = By.xpath("//label[@for = 'input-newsletter-yes']");
		
		By newletterRadio = RelativeLocator.with(By.tagName("input")).toLeftOf(By.xpath("//label[@for = 'input-newsletter-yes']"));

		
		
		By privacypolicyCheckbox = By.xpath("//input[@type='checkbox'and @name='agree']");
		By continueBtn = By.xpath("//button[text() = 'Continue']");
		
		//By successsregisterText = By.

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
		
		
		//Click on register link in home page
		 eleUtil.doClick(registerLink);
		 
		 eleUtil.doSendKeys(firstName, "Firstname");
		 eleUtil.doSendKeys(lastname, "Lastname"); 
		 eleUtil.doSendKeys(email, "test@gmail.com");
		 eleUtil.doSendKeys(password, "test123");
		 

		 // click on the compose button as soon as the "compose" button is visible
		 
		 eleUtil.doClick(newletterRadio);
		// eleUtil.doClick(privacypolicyCheckbox);
		// eleUtil.doClick(continueBtn);
		

	}

}
