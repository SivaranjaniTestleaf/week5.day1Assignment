package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class UpdateService extends  LoginPage
{

	@Test
	public void updateIncident() throws InterruptedException
	{
		driver.findElement(By.xpath("(//div[contains(text(),'Open')])[1]")).click();
		Thread.sleep(4000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys("INC0010020",Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//tbody[@class='list2_body']//td[3]")).click();
		
		WebElement findElement = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Select urgenEle = new Select(findElement);
		urgenEle.selectByValue("1");
		
		WebElement stateEle = driver.findElement(By.xpath("//select[@id='incident.state']"));
		Select stateSel = new Select(stateEle);
		stateSel.selectByValue("2");
		
		driver.findElement(By.id("sysverb_update_bottom")).click();

		driver.findElement(By.xpath("//tbody[@class='list2_body']//td[3]")).click();
		
		String text = driver.findElement(By.xpath("//select[@id='incident.urgency']//option[@selected='SELECTED']")).getText();
		System.out.println(text);
		if(text.contains("High"))
		{
			System.out.println("The Urgency selected as: "+ text);
		}
		else
	    System.out.println("The Urgence is not selected as High");
		
		String text1 = driver.findElement(By.xpath("//select[@id='incident.state']//option[@selected='SELECTED']")).getText();
		System.out.println(text1);
		if(text1.contains("Progress"))
		{
			System.out.println("The Urgency selected as: "+ text1);
		}
		else
			System.out.println("The Urgence is not selected as High");
		
		
		
	}

}
