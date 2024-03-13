package Demo.selenium_intro;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String optionSelected = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		System.out.println(optionSelected);
		driver.findElement(By.cssSelector("#checkBoxOption2")).click();
		Select drop = new Select(driver.findElement(By.id(("dropdown-class-example"))));
		drop.selectByVisibleText(optionSelected);
		Thread.sleep(3);
		driver.findElement(By.id("name")).sendKeys(optionSelected);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		assertTrue(driver.switchTo().alert().getText().contains(optionSelected));
		driver.switchTo().alert().accept();		

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,600)");
		Thread.sleep(5);
		int rowCount=driver.findElements(By.xpath("//table[@id='product'][@name='courses']/tbody/tr")).size();
		int colCount=driver.findElements(By.xpath("//table[@id='product'][@name='courses']/tbody/tr/th")).size();
		System.out.println("Rows: "+rowCount +" & Columns: "+colCount );	
		
		for(int i=1;i<=rowCount;i++) {
			if(i==3) {
				for(int j=1;j<=colCount;j++) {
					System.out.println(driver.findElement(By.xpath("//table[@id='product'][@name='courses']/tbody/tr["+i+"]/td["+j+"]")).getText());
					//System.out.println("Course: "+driver.findElement(By.xpath("//table[@id='product'][@name='courses']/tbody/tr["+i+"]/th["+j+"]")));
					//System.out.println("Price: "+driver.findElement(By.xpath("//table[@id='product'][@name='courses']/tbody/tr["+i+"]/th["+j+"]")));
				}
				break;
			}
			
			
		}
		
		js.executeScript("window.scrollTo(0,50)");
		
		
		driver.quit();

	}

}
