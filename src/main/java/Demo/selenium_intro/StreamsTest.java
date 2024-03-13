package Demo.selenium_intro;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,600)");
		
		//driver.findElement(By.xpath("table#product.table-display"));
		
		List<WebElement> Instructor = driver.findElements(By.xpath("//*[@class='tableFixHead']/table/tbody/tr/td[1]"));
		
		List<String> InstructorList = Instructor.stream().map(s-> s.getText()).collect(Collectors.toList());
		
		List<String> SortedInstructorList = InstructorList.stream().sorted().collect(Collectors.toList());
		
		SortedInstructorList.forEach(a->System.out.println(a));
		
		Assert.assertTrue(InstructorList.equals(SortedInstructorList));
		
		driver.quit();


	}

}
