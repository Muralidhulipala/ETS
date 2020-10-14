package com.ETS.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waitforcontrol {
	
	public static boolean waitforcontrol(WebDriver driver,String xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		if(element.isDisplayed())
		{
			System.out.println("Element found");
			return true;
		}
		else
		{
			System.out.println("Element not found");
			return false;
		}
	
	
	}
	public static boolean isElementdisplayed(WebDriver driver,String xpath)
	{
		int count=driver.findElements(By.xpath(xpath)).size();
		if(count>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	
	
	}

}
