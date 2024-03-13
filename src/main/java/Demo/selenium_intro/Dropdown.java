package Demo.selenium_intro;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Automation\\Selenium\\workspace\\Driver\\chrome.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				
		Select Curr_dropdown= new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		
		List<WebElement> list= Curr_dropdown.getOptions();
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
		}
		
		Curr_dropdown.selectByVisibleText("AED");
		System.out.println(Curr_dropdown.getFirstSelectedOption().getText());
		
		
		driver.close();
		
	}

}
