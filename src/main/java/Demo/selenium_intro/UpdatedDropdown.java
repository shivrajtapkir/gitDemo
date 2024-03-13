package Demo.selenium_intro;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdatedDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("divpaxinfo")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefIncAdt")));
		
		try {
		int i=1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
			
		}}
		catch(Exception e){
			System.out.println(e.getMessage());
			/*
			 * System.out.println(driver.switchTo().alert().getText());
			 * driver.switchTo().alert().accept(); driver.switchTo().defaultContent();
			 */
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		driver.close();
	}

}
