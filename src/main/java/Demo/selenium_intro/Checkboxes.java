package Demo.selenium_intro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Checkboxes {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected(), false);
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected(), true);
		
		driver.close();
		
		//Assignment
		
		WebDriver driver2= new ChromeDriver();
		driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver2.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver2.findElement(By.cssSelector("input#checkBoxOption1")).click();
		Assert.assertTrue(driver2.findElement(By.cssSelector("input#checkBoxOption1")).isSelected());
		
		driver2.findElement(By.cssSelector("input#checkBoxOption1")).click();
		Assert.assertFalse(driver2.findElement(By.cssSelector("input#checkBoxOption1")).isSelected());
		
		System.out.println("Total Checkboxes : "+driver2.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		driver2.close();
		
	}

}
