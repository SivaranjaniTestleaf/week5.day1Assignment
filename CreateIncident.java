package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CreateIncident extends LoginPage
{
	@Test
	public void createIncident() throws InterruptedException
	{
		driver.findElement(By.xpath("(//div[contains(text(),'Create New')])[1]")).click();
		Thread.sleep(4000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@name='sys_display.incident.caller_id']")).sendKeys("Sab",Keys.DOWN,Keys.ENTER);
		Thread.sleep(3000);
		String attribute = driver.findElement(By.id("incident.number")).getAttribute("Value");
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Incident by admin");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys(attribute,Keys.ENTER);
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//tbody[@class='list2_body']//td[3]//a")).getText();
		if(attribute.equals(text))
		{
			System.out.println("The Incident ID is created");
		}
		else 
		{
			System.out.println("The Incident ID is not created");
		}
		
		driver.findElement(By.xpath("//tbody[@class='list2_body']//td[3]")).click();
		
		}

	}
	


