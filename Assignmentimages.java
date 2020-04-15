package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignmentimages {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get URL
		driver.get("http://www.leafground.com/home.html");
		// Click image
		driver.findElementByXPath("//img[@alt='Images']").click();
		// find how many image available
		List<WebElement> listofImage = driver.findElementsByTagName("img");
		int size = listofImage.size();
		System.out.println(size);
		// find last images using key board buttons
		WebElement keyimage = driver.findElementByXPath("//img[@src='../images/keyboard.png'][last()]/preceding-sibling::label");
		System.out.println(keyimage.getText());
		
		// navigate to home page
		driver.navigate().to("http://www.leafground.com/home.html");
		// navigate to home page
		driver.navigate().to("http://www.leafground.com/home.html");
		// Click Check box
		driver.findElementByXPath("//img[@alt='Checkbox']").click();
		// check all the checkbox 
		List<WebElement> checkBoxs = driver.findElementsByXPath("//input[@type='checkbox']");
		for(WebElement select:checkBoxs) {
			if(!select.isSelected()) 
				select.click();

		}


	}


}
