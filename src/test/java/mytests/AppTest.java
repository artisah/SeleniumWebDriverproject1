package mytests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	
	//Global Pre condition
	// Pre condition
	//test steps + assertions (avt vs expected result)
	// Post Steps
	
/**
 * 	Before Suit executed
	Before Test executed
	Before Class executed
		Before Method executed
		Test2 executed
		After Method executed
		
		Before Method executed
		Test3 executed
		After Method executed
		
		Before Method executed
		Test1 executed
		After Method executed
	After Class executed
	After Test executed
	After Suit executed
	
	
	Tests are picked on alphabetically order
 */
	
	@BeforeSuite
	public void beforeSuitMethod() {
		System.out.println("Before Suit executed");	
	}
	
	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("Before Test executed");	
	}
	
	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("Before Class executed");	
	}
	
	@BeforeMethod
	public void beforeMethodMethod() {
		System.out.println("Before Method executed");	
	}
	
	@Test
	public void TestMethod() {
		System.out.println("Test1 executed");	
	}
	@Test
	public void Test2Method() {
		System.out.println("Test2 executed");	
	}
	
	@Test
	public void Test3Method() {
		System.out.println("Test3 executed");	
	}
	
	
	@AfterMethod
	public void afterMethodMethod() {
		System.out.println("After Method executed");	
	}
	
	@AfterClass
	public void afterClassMethod() {
		System.out.println("After Class executed");	
	}
	
	@AfterTest
	public void afterTestMethod() {
		System.out.println("After Test executed");	
	}
	
	@AfterSuite
	public void afterSuitMethod() {
		System.out.println("After Suit executed");	
	}
	

}
