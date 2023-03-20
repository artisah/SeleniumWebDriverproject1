package seleniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownAllOption {

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

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
		//HTMl Tag - Select
		By countrySelect = By.id("Form_getForm_Country");
		
		WebElement countryEle = driver.findElement(countrySelect);
		
		Select countryDp = new Select(countryEle);
		List<WebElement> optionList = countryDp.getOptions();
		
		System.out.println(optionList.size());
		
		for ( WebElement optionvalue: optionList) {
			System.out.println(optionvalue.getText());		
			
		}
		
		

	}

}
