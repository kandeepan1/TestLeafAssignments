package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnList2 {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		// Load the URL
		driver.get("https://erail.in/trains-between-stations/ksr-bengaluru-SBC/mgr-chennai-ctr-MAS");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Max the browser
		driver.manage().window().maximize();
		// Click on sort on date
		driver.findElementByXPath("(//input[@type='checkbox'])[3]").click();
		// Get count of train
		List<WebElement> trainList = driver.findElementsByXPath("//div[@id='divTrainsList']//td[@class=''][2]");
		int size = trainList.size();
		System.out.println(size);
		// Get all the Train Names -> Created Another List using ArrayList(TrainNames)
		List<String> trainNames = new ArrayList<String>();
		// for each loop:List<WebElement>
		for(WebElement Names : trainList ) {
			String text = Names.getText();
			trainNames.add(text);
		}
		Collections.sort(trainNames);
		for(int i =0; i< trainNames.size(); i++) {
			System.out.println(trainNames.get(i));
		}

	}

}
