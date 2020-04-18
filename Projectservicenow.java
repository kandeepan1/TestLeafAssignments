package week3.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class Projectservicenow {

	public static void main(String[] args) throws InterruptedException {
		// Set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		// Open the chrome driver
		ChromeDriver driver = new ChromeDriver();
		// Load the URL
		driver.get("https://dev92474.service-now.com/");
		// implicitly wait 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Max the Window
		driver.manage().window().maximize();
		// Switch to frame
		driver.switchTo().frame("gsft_main");
		// Enter the user name
		driver.findElementById("user_name").sendKeys("admin");
		// Enter the password
		driver.findElementById("user_password").sendKeys("India@123");
		// click login
		driver.findElementById("sysverb_login").click();
		Thread.sleep(3000);
		// Enter Incident in the filder
		driver.findElementById("filter").sendKeys("incident");
		// Click Enter
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		// Click Create New
		driver.findElementByXPath("(//div[text()='Create New'])[1]").click();
		Thread.sleep(3000);
		// Switch to new frame
		driver.switchTo().frame("gsft_main");
		// get the text of number field
		String incNumn = driver.findElementById("incident.number").getAttribute("value");
		System.out.println("Incident Number:"+incNumn);
		// Click on the Search Button 
		driver.findElementById("lookup.incident.caller_id").click();
		Thread.sleep(3000);
		// Switch to next window
		Set<String> allWind = driver.getWindowHandles();
		List<String> ls = new ArrayList<String>(allWind);
		driver.switchTo().window(ls.get(1));
		driver.manage().window().maximize();
		// Choose 1st name
		driver.findElementByLinkText("Abel Tuter").click();
		// Back to parent window
		driver.switchTo().window(ls.get(0));
		// Switch to Frame
		driver.switchTo().frame("gsft_main");
		// Select the Software in dropdown
		WebElement dropdown1 = driver.findElementById("incident.category");
		Select dd1 = new Select(dropdown1);
		dd1.selectByVisibleText("Software");
		Thread.sleep(2000);
		// Select the Email in dropdown
		WebElement dropdown2 = driver.findElementById("incident.subcategory");
		Select dd2 = new Select(dropdown2);
		dd2.selectByVisibleText("Email");
		// Select the Walk-In in Contact type Field
		WebElement dropdown3 = driver.findElementById("incident.contact_type");
		Select dd3 = new Select(dropdown3);
		dd3.selectByVisibleText("Walk-in");
		// Select state as In-Progress
		WebElement dropdown4 = driver.findElementById("incident.state");
		Select dd4 = new Select(dropdown4);
		dd4.selectByVisibleText("In Progress");
		// Select Urgency as High
		WebElement dropdown5 = driver.findElementById("incident.urgency");
		Select dd5 = new Select(dropdown5);
		dd5.selectByValue("1");
		// Click on the search button in Assignment Group
		driver.findElementById("lookup.incident.assignment_group").click();
		// Switch to new window
		Set<String> allWind1 = driver.getWindowHandles();
		List<String> ls1 = new ArrayList<String>(allWind1);
		driver.switchTo().window(ls1.get(1));
		driver.manage().window().maximize();
		// Choose last residing value opened in new window
		driver.findElementByLinkText("Openspace").click();
		// Switch to parent window
		driver.switchTo().window(ls1.get(0));
		// Switch to frame
		driver.switchTo().frame("gsft_main");
		// Enter Short Description
		driver.findElementById("incident.short_description").sendKeys("Creating Incident for the purpose of management");
		// Click Submit button
		driver.findElementById("sysverb_insert_bottom").click();
		// Enter the incident number newly created and Click Enter
		driver.findElementByXPath("(//input[@placeholder='Search'])[1]").sendKeys(incNumn,Keys.ENTER);
		Thread.sleep(3000);
		// Click on newly created Incident Displayed
		driver.findElementByXPath("//a[@class='linked formlink']").click();
		Thread.sleep(3000);
		// Verify the Incident Number
		String inN = driver.findElementById("incident.number").getAttribute("value");
		System.out.println("Verfy the Incident Number as:"+inN);
		// Update impact as high
		WebElement dropdown6 = driver.findElementById("incident.impact");
		Select dd6 = new Select(dropdown6);
		dd6.selectByValue("1");
		// update Description
		driver.findElementById("incident.description").sendKeys("Successfully Created an incident");
		// Enter Work Notes
		driver.findElementById("activity-stream-work_notes-textarea").sendKeys("Done Right");
		// Click Update button
		driver.findElementByXPath("//button[@id='sysverb_update']").click();
		// Come out of frame
		driver.switchTo().defaultContent();
		// Click User Menu
		driver.findElementByXPath("//span[text()='System Administrator']").click();
		// Click logout
		driver.findElementByLinkText("Logout").click();
		// Switch to Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		// Close the browser
		driver.close();

	}

}
