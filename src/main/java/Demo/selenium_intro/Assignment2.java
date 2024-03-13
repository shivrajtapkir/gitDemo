package Demo.selenium_intro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.xpath("//label[contains(text(),'Name')]/following-sibling::input[@name='name']")).sendKeys("Rahul");
		driver.findElement(By.xpath("//label[contains(text(),'Email')]/following-sibling::input[@name='email']")).sendKeys("rahul143@gmail.com");
		driver.findElement(By.xpath("//label[contains(text(),'Password')]/following-sibling::input[@placeholder='Password']")).sendKeys("Rahul143");
		
		Select gender = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		gender.selectByVisibleText("Male");
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.xpath("//*[@type='date']")).sendKeys("13-05-1991");
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
		System.out.println("Hello git");
		System.out.println("Hello again");
		driver.quit();
	}

}
