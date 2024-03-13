package Demo.selenium_intro;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class WindowTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions options= new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> windowhandles =driver.getWindowHandles();
		Iterator<String> it =windowhandles.iterator();
		String parentWindow =it.next();
		String childWindow =it.next();
		
			
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		String name= driver.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]")).get(1).getText();
		System.out.println(name);
		driver.close();
		
		driver.switchTo().window(parentWindow);
		WebElement nameEditBox = driver.findElement(By.xpath("//label/following-sibling::input[@name='name']"));
		nameEditBox.sendKeys(name);
		
		File file = nameEditBox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("C:\\Users\\HP\\Downloads\\scrnshot.png"));
		
		driver.close();
		

	}

}
