package com.ETS.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ETSLogin {
	
	public static WebElement LoginandHomepage(WebDriver driver,String objectName)
	{

		switch(objectName)
		{
		
		case "Login":
			return driver.findElement(By.xpath("//*[contains(text(),'Login')]"));
			
		case "username":
			return driver.findElement(By.xpath("//*[@formcontrolname='email']"));
		case "password":
			return driver.findElement(By.xpath("//input[@formcontrolname='password' and @placeholder='Password']"));
		case "btn_login":
				return driver.findElement(By.xpath("//*[contains(text(),'Sign In')]"));
		case "PersonLogo_Ontop":
			return driver.findElement(By.xpath("//*[@href='/user-profile']"));
		case "LogOut":
			return driver.findElement(By.xpath("//*[contains(text(),'Log Out')]"));
		case "UserProfile":
			return driver.findElement(By.xpath("//*[contains(text(),'My Profile')]"));
		case "UserLogo_Righttop":
			return driver.findElement(By.xpath("//*[contains(text(),'Hello')]//following-sibling::div"));
		case "UserLogo_LeftGutter":
			return driver.findElement(By.xpath("//*[contains(text(),'Hello')]//following-sibling::div"));
		case "DashBoard":
			return driver.findElement(By.xpath("//*[contains(text(),'DASHBOARD')]"));
		case "Takeexam":
			return driver.findElement(By.xpath("//*[contains(text(),'TAKE EXAM')]"));
		case "Dailypractice":
			return driver.findElement(By.xpath("//*[contains(text(),'DAILY PRACTICE')]"));
													
		case "Performance":
			return driver.findElement(By.xpath("//*[contains(text(),'PERFORMANCE')]"));	
		default:
			System.out.println("Entered Objectname is not valid.Please check and enter again");
			return null;
		}
		
	}

}
