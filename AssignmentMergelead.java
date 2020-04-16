package week3.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentMergelead {

	public static void main(String[] args) throws InterruptedException {
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		// Open the Chrome driver
		ChromeDriver driver = new ChromeDriver();
		// Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		// implicitly wait 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Max the browser
		driver.manage().window().maximize();
		// Enter User Name
		driver.findElementById("username").sendKeys("demosalesmanager");
		// Enter the password
		driver.findElementById("password").sendKeys("crmsfa");
		// Click Login button
		driver.findElementByClassName("decorativeSubmit").click();
		// Click CRM/SFA link
		driver.findElementByLinkText("CRM/SFA").click();
		// Click on leads
		driver.findElementByLinkText("Leads").click();
		// Click on Merge Leads
		driver.findElementByLinkText("Merge Leads").click();
		// Click on From lead image
		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[1]").click();
		// Switch to 2nd Window
		Set<String> allWindow = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(allWindow);
		driver.switchTo().window(lst.get(1));
		// Max the Window
		driver.manage().window().maximize();   
		// Enter first Name
		driver.findElementByName("firstName").sendKeys("frd");
		// Click find leads
		driver.findElementById("ext-gen114").click();
		Thread.sleep(5000);
		// click 1st result Lead ID
		driver.findElementByLinkText("10051").click();
		// Switch to parent window
		driver.switchTo().window(lst.get(0));
		// Click To lead image
		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();
		// Switch to 2nd window
		Set<String> allWindow1 = driver.getWindowHandles();
		List<String> lst1 = new ArrayList<String>(allWindow1);
		driver.switchTo().window(lst1.get(1));
		driver.manage().window().maximize();
		// Enter first Name
		driver.findElementByName("firstName").sendKeys("Dk");
		// Click find leads
		driver.findElementById("ext-gen114").click();
		Thread.sleep(5000);
		// click 1st result Lead ID
		driver.findElementByLinkText("10060").click();
		// switch to 1st window
		driver.switchTo().window(lst1.get(0));
		// Click Merge
		driver.findElementByLinkText("Merge").click();
		// switch to alert
		Alert alert = driver.switchTo().alert();
		// Accept the alert
		alert.accept();
		// Click find leads
		driver.findElementByLinkText("Find Leads").click();
		// Enter Lead ID
		driver.findElementByName("id").sendKeys("10051");
		// Click Find leads
		driver.findElementById("ext-gen334").click();
		Thread.sleep(5000);
		// Confirm Merged ID got deleted
		String text = driver.findElementById("ext-gen437").getText();
		if(text.contains("No records to display")) {
			System.out.println("lead ID successfuly merged and the ID get deleted");
		}     		
		// Close the browser
		driver.close();
	}

}
