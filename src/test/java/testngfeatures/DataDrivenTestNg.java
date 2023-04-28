package testngfeatures;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestNg {
	
	@DataProvider
	public Object[][] loginTestData() {
		return new Object[][] {
			{"abc@gmail.com", "123"},
			{"pqr@gmail.com", "456"},
			{"xyz@gmail.com", "789"}
		};
	}
	
	
	@Test(dataProvider = "loginTestData")
	public void loginTest(String username, String password) {
		Assert.assertTrue(loLogin(username, password));
	}
	
	
	public boolean loLogin(String username, String password ) {
		System.out.println("User name: " + username);
		System.out.println("Password: " + password);
		System.out.println("PLogin successfull");
		return true;
		
	}

}
