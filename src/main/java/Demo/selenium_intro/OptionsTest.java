package Demo.selenium_intro;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;


public class OptionsTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setCapability("proxy", proxy);
		
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.getTitle());
		
		
		SoftAssert sa = new SoftAssert();
		
		List<WebElement> links =driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		for(WebElement link :links) {
			
			String url= link.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			
			/*
			 * System.out.println(driver.getPageSource());
			 * System.out.println(driver.getWindowHandle());
			 * System.out.println(driver.getCurrentUrl());
			 */
			
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode= conn.getResponseCode();
			System.out.println(link.getText()+" -> "+respCode);
			sa.assertTrue(respCode<400, "The link "+link.getText()+" is broken with code "+respCode);

			
		}
		
		sa.assertAll();
				
		driver.quit();

	}

}
