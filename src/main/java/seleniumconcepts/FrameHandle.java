package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

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

		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		//driver.switchTo().frame(1); // by ondex of frame
		driver.switchTo().frame("main");
		
		
		
		WebElement header = driver.findElement(By.xpath("/html/body/h2"));
		
		String text = header.getText();
		System.out.println(text);
		
		//Switch back to parent window/frame  from child frame
		//Selects either the first frame on the page, or the main document when a page contains iframes.
		driver.switchTo().defaultContent();
		
		// Selenium 4 method added
		//Change focus to the parent context. If the current context is the top level browsing context, the context remains unchanged.
		//driver.switchTo().parentFrame()
		
		

	}

}
