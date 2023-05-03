package webstraunt;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;

public class searchTableTest {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://www.webstaurantstore.com/");
		driver.manage().window().maximize();
		
		WebElement searchbox = driver.findElement(By.name("searchval"));
		searchbox.sendKeys("stainless work table");
		searchbox.submit();
		
		List<WebElement> Table = driver.findElements(By.xpath("//div[starts-with(@class,'ag-item')]"));
		
		System.out.println(Table.size());
		
		for(WebElement webelement:Table) {
			String name = webelement.getText();
			System.out.println(name);
			Assert.assertTrue(name.contains("Table"));
			
		}
		
		driver.findElement(By.xpath("//input[@class='btn btn-cart btn-small']")).submit();
		
		driver.findElement(By.id("cartItemCountSpan")).click();
		
		try{
			Thread.sleep(2000);
			}
			catch(InterruptedException ie){
			}
		
		driver.findElement(By.xpath("//button[@class='emptyCartButton btn btn-mini btn-ui pull-right']")).click();
		
		try{
			Thread.sleep(2000);
			}
			catch(InterruptedException ie){
			}
		
		driver.findElement(By.xpath("//button[@class='bg-origin-box-border bg-repeat-x border-solid border box-border cursor-pointer inline-block text-center no-underline hover:no-underline antialiased hover:bg-position-y-15 mr-2 rounded-normal text-base leading-normal px-7 py-2-1/2 hover:bg-green-600 text-white text-shadow-black-60 bg-green-primary bg-linear-gradient-180-green border-black-25 shadow-inset-black-17 align-middle font-semibold']")).click();
		
		try{
			Thread.sleep(2000);
			}
			catch(InterruptedException ie){
			}
		driver.close();

	}

}
