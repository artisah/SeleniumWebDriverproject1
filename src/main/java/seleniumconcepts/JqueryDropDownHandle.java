package seleniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {

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

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();

		By choices = By.xpath("//span[@class='comboTreeItemTitle']");

		// Single value selection
		// selectChoice(choices, "choice 1");

		// multi selection
		 //selectChoice(choices, "choice 1", "choice 2");

		// All selections
		//selectChoice(choices, "all");
		
		// Single value selection when value does not exists
		// selectChoice(choices, "choice 8");
		 
		// multi selection when value does not existsone or more 
		selectChoice(choices, "choice 1", "choice 2", "choice 8");

	}

	public static void selectChoice(By locator, String... value) {

		List<WebElement> choicesList = driver.findElements(locator);
		boolean flag = false;

		if (!value[0].equalsIgnoreCase("all")) {
			for (WebElement e : choicesList) {
				String text = e.getText();

				for (int i = 0; i < value.length; i++) {
					if (text.equals(value[i])) {
						flag = true;
						System.out.println(text);
						e.click();
						flag = false;
						break;
					}
				}

			}

		}
		else {
			try {
				for (WebElement e : choicesList) {
					String text = e.getText();
					System.out.println(text);
					e.click();
					flag = true;
					
				}
				
			} catch (ElementNotInteractableException e) {
				System.out.println("All choices are over .....");
			}		
			
		}
		
		if (flag == false) {
			System.out.println("choice is not avaiable");
		}

	}

}
