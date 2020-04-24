package week4.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test1Createnewchange {

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
		// Enter change in the filder
		driver.findElementById("filter").sendKeys("change");
		// Click Enter
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		// Click Create New
		driver.findElementByXPath("(//div[text()='Create New'])[3]").click();
		Thread.sleep(3000);
		// Switch to new frame
		driver.switchTo().frame("gsft_main");
		// Click Normal change
		driver.findElementByLinkText("Normal: Changes without predefined plans that require approval and CAB authorization.").click();
		// Get the change number
		String incNumn = driver.findElementById("change_request.number").getAttribute("value");
		System.out.println("Change Request Number:"+incNumn);
		// Enter the text in mandatory field short description
		driver.findElementById("change_request.short_description").sendKeys("new change ticket");
		// Click Submit button
		driver.findElementById("sysverb_insert_bottom").click();
		// Click on newly created Change number Displayed
		driver.findElementByXPath("(//input[@placeholder='Search'])[1]").sendKeys(incNumn,Keys.ENTER);
		Thread.sleep(3000);
		// Click on newly created change request
		driver.findElementByXPath("//a[@class='linked formlink']").click();
		Thread.sleep(3000);
		// Verify the change Number
		String inN = driver.findElementById("change_request.number").getAttribute("value");
		System.out.println("change Number:"+inN);
		if (inN.contains(incNumn)) {
			System.out.println("Change Number displayed correctly and created successfully ");
		}
		else {
			System.out.println("Incident Number Not Matches");
		}

	}

}
