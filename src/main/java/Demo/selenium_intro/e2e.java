package Demo.selenium_intro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Return date')]/following-sibling::span[@class='date-close']")).isEnabled());
		
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_0")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Return date')]/following-sibling::span[@class='date-close-disabled']")).isEnabled());
		
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.cssSelector("a[value='BLR']")).click();
		
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value='MAA']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		driver.quit();
	}

}
