package week5.day1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AssignIncident extends LoginPage{

	@Test
	public void assignIncident() throws InterruptedException
	{
		driver.findElement(By.xpath("(//div[contains(text(),'Open')])[1]")).click();
		Thread.sleep(4000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys("INC0000003",Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//tbody[@class='list2_body']//td[3]")).click();
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[5]")).click();
		List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys("Software",Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//tbody[@class='list2_body']//td[3]/a)[1]")).click();
		driver.switchTo().window(windowHandles.get(0));
		Thread.sleep(4000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//div[@class='sn-stream-textarea-container']//textarea)[1]")).sendKeys("Assign the incident");
		driver.findElement(By.xpath("(//button[@value='sysverb_update'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys("INC0000003",Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//tbody[@class='list2_body']//td[3]")).click();
		
		String attribute = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']")).getAttribute("value");
		if(attribute.equals("Software"))
		{
			System.out.println("The Group assigned to Software");
		}
		else
			System.out.println("The Group is not assigned to Software");
		
		
	}

}
