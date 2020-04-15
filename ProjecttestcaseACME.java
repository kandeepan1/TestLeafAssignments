package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ProjecttestcaseACME {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get URL
		driver.get("https://acme-test.uipath.com/account/login");
		// enter Username
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		driver.findElementById("email").sendKeys(Keys.TAB);
		// enter password
		driver.findElementById("password").sendKeys("leaf@12");
		// click Login
		driver.findElementById("buttonLogin").click();
		// mouse over on Vendors **************************
		WebElement ele = driver.findElementByXPath("//button[text()[normalize-space()='Vendors']]");
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();
		// click Search vendor		
		driver.findElementByLinkText("Search for Vendor").click();
		// enter vendor name
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		// click Search
		driver.findElementById("buttonSearch").click();
		// find the country name based on Vendor
        String country = driver.findElementByXPath("//td[text()='France']").getText();
        System.out.println("country name:"+country);
		// click Logout
		driver.findElementByLinkText("Log Out").click();
		// close Browser
		driver.close();
	}

}
