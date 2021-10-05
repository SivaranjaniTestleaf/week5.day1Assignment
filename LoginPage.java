package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	public ChromeDriver driver;
	@BeforeMethod
	public void loginScreen() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev84668.service-now.com/");
		Thread.sleep(4000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Siva@12345");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		Thread.sleep(3000);
	}
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}

}
