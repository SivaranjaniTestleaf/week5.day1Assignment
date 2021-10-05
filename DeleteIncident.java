package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public class DeleteIncident extends LoginPage{

	@Test
	public void deleteIncident() throws InterruptedException 
	{
		driver.findElement(By.xpath("(//div[contains(text(),'Open')])[1]")).click();
		Thread.sleep(4000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys("INC0000018",Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//tbody[@class='list2_body']//td[3]")).click();
		driver.findElement(By.xpath("(//button[@id='sysverb_delete_bottom'])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys("INC0000018",Keys.ENTER);
		String text2 = driver.findElement(By.xpath("(//tbody[@class='list2_body']//td)")).getText();
		System.out.println(text2);
		
		
	}

}
