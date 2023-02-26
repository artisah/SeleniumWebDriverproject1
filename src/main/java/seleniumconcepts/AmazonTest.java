package seleniumconcepts;

public class AmazonTest {

	public static void main(String[] args) {
		
		BrowserUtil browserutil = new BrowserUtil();
		browserutil.launchBrowser("chrome");
		browserutil.enterUrl("https://www.amazon.com/");
		System.out.println(browserutil.getPageUrl());
		browserutil.quitBrowser();
		

	}

}
