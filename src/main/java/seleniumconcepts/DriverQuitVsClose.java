package seleniumconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverQuitVsClose {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");
		System.out.println(driver.getTitle());

		// Case1:
//		driver.quit();
//		
//		driver.get("https://google.com"); 
//		// at above  line you will get exception as " org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?"
//		

//		// case2:
		driver.close();
//		driver.get("https://google.com");
		// at above line you will get " org.openqa.selenium.NoSuchSessionException:
		// invalid session id"

		// to solve these exception launch browser again, so that new session id will be
		// created.

	    driver = new ChromeDriver();

		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		
		
		// This concept is used in estNg when we use setup and tear down @BeforeMethod and @AfterMethod respectively.

	}

}
