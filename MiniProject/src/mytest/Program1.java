package mytest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Program1 {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() 
	
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\athee\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://amazon.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void verifyTitle() 
	{
	String actualTitle=driver.getTitle();
	String expectedTitle="Amazon.com";
	
	Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void verifyLogo()
	{
	boolean flag=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();	
	
	Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
