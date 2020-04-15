package week1.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4assignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		// enter the Username
		driver.findElementById("username").sendKeys("demosalesmanager");
		// enter the Password
		driver.findElementById("password").sendKeys("crmsfa");
		// click Login
		WebElement signClick = driver.findElementByClassName("decorativeSubmit");
		signClick.click();
		// click CRM/SFA link
		driver.findElementByLinkText("CRM/SFA").click();
		// click Leads link
		driver.findElementByLinkText("Leads").click();
		// click Find leads
		driver.findElementByLinkText("Find Leads").click();
		// click on Email
		driver.findElementByLinkText("Email").sendKeys(Keys.ENTER);
		// enter Email
		driver.findElementByName("emailAddress").sendKeys("babu@testleaf.com");
		// click find leads button
		driver.findElementById("ext-gen334").click();
		Thread.sleep(5000);
		// capture name of first resulting lead
		String firstname = driver.findElementByLinkText("Babu").getText();
		String lastname = driver.findElementByLinkText("M").getText();
		System.out.println("lead first name:"+firstname);
		System.out.println("lead last name:"+lastname);
		// click first resulting lead
		driver.findElementByLinkText("10014").click();
		// click Duplicate lead
		driver.findElementByLinkText("Duplicate Lead").click();
		// get tile and verify the title as duplicate lead
		String title = driver.getTitle();
		System.out.println(title);
		WebElement eleleads = driver.findElementById("sectionHeaderTitle_leads");
		String titlename = eleleads.getText();
		System.out.println(titlename);
		// click create lead
		driver.findElementByName("submitButton").click();
		// close the browser
		driver.close();
		
	}

}
