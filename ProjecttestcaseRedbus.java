package week1.day5;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProjecttestcaseRedbus {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get URL
		driver.get("https://www.redbus.in/");
		// enter from place as chennai
		driver.findElementById("src").sendKeys("Chennai");
		Thread.sleep(5000);
		driver.findElementById("src").sendKeys(Keys.TAB);
		// enter to place as Bang
		driver.findElementById("dest").sendKeys("Bangalore");
		Thread.sleep(5000);
		driver.findElementById("dest").sendKeys(Keys.TAB);
		//pick onward date as 30th April
		driver.findElementByXPath("(//span[contains(@class,'fl icon-calendar_icon-new')])[1]").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//td[text()='30'])[2]").click();
		// click search Bus	
		driver.findElementById("search_btn").click();
		// clicking after 6pm Departure
		driver.findElementByXPath("(//label[@class='cbox-label'])[4]").click();
		Thread.sleep(5000);
		// click sleeper under Bus types
		driver.findElementByXPath("(//label[@for='bt_SLEEPER'])[2]").click();
		Thread.sleep(5000);
		// click on Seats Available to sort
		driver.findElementByLinkText("Seats Available").click();
			
	}

}
