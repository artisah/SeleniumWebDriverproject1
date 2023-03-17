package seleniumconcepts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);

	}

	/**
	 * Function to click on button with BY locator
	 * 
	 * @param locator
	 */

	public void doClick(By locator) {
		getElement(locator).click();
		;
	}

	// Overloaded doClick based on String locator
	public void doClick(String locatorType, String locatorValue) {
		getElement(getBy(locatorType, locatorValue)).click();

	}

	// Overloaded method using with String locator
	public void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);

	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public String doGetAttributr(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}

	public int getElementCount(By locator) {
		return getElements(locator).size();
	}

	public void getElementsText(By locator) {
		List<WebElement> eleList = getElements(locator);

		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);

		}
	}

	/**
	 * This method returns list of elements text
	 * 
	 * @param locator
	 * @return
	 */
	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList();

		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}
		}

		return eleTextList;
	}

	/**
	 * This method returns the list of elements attribute value
	 * 
	 * @param locator
	 * @param attributeValue
	 * @return
	 */
	public List<String> getElementsAttributeList(By locator, String attributeValue) {

		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList();

		for (WebElement e : eleList) {
			String attrVal = e.getAttribute(attributeValue);
			if (!attrVal.isEmpty()) {
				eleAttrList.add(attrVal);
			}
		}
		return eleAttrList;

	}
	
	public void clickOnLink( By locator, String linkText) {
		List<WebElement> langList = getElements(locator);
		
		for (WebElement e : langList) {
			String text = e.getText();
			
			if (text.contains(linkText)) {
				e.click();
				break;
			}
			
		
		}
	}

	public By getBy(String locatorType, String locatorValue) {

		By locator = null;

		switch (locatorType) {
		case "id":
			locator = By.id(locatorValue);
			break;

		case "name":
			locator = By.name(locatorValue);
			break;

		case "classname":
			locator = By.className(locatorValue);
			break;

		case "xpath":
			locator = By.xpath(locatorValue);
			break;

		case "cssselector":
			locator = By.cssSelector(locatorValue);
			break;

		case "linktext":
			locator = By.linkText(locatorValue);
			break;

		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;

		case "tagname":
			locator = By.tagName(locatorValue);
			break;

		default:
			break;
		}

		return locator;
	}

}
