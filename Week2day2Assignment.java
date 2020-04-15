package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Week2day2Assignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get URL
		driver.get("http://www.leafground.com/pages/table.html");
		// get the table and store in Webelement
		WebElement tableName = driver.findElementByXPath("//div[@class=' container table']");
		// Find the number of Rows
		List<WebElement> allRows = tableName.findElements(By.tagName("tr"));
		// get the counts of Row
		int rows_count = allRows.size();
		System.out.println(rows_count);		
		// Find the number of Columns
		List<WebElement> allClums = tableName.findElements(By.tagName("td"));
		// get the counts of Column
		int colum_count = allClums.size();
		System.out.println(colum_count);
		// Get the progress value and store in variable
		WebElement value = allClums.get(7);
		String progress = value.getText();
		System.out.println("Progress Value of Learn to Intract:"+progress);
		// find the vital task for the least completed progress - Click the box
		WebElement leastprov = driver.findElementByXPath("//td[text()='30%']");
		System.out.println("Least Progress Value:"+leastprov.getText());
		// click the box
		driver.findElementByXPath("(//input[@name='vital'])[3]").click();	

		}
	
	}

