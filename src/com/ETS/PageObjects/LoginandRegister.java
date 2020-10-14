package com.ETS.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ETS.Utilities.BaseTest;

public class LoginandRegister {
	
	public static WebElement LoginandRegisterObjects(WebDriver driver,String objectName)
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
		case "Registertab":
			return driver.findElement(By.xpath("//*[@href='#register']"));
		case "Firstname":
			return driver.findElement(By.xpath("//*[@name='firstName']"));
		case "Lastname":
			return driver.findElement(By.xpath("//*[@name='lastName']"));
		case "Email":
			return driver.findElement(By.xpath("//*[@name='emailId']"));
		case "Mobilenumber":
			return driver.findElement(By.xpath("//input[@type='password']/following::input[@name='mobileNumber']"));
		case "Password":
			return driver.findElement(By.xpath("//*[@name='emailId']/following::input[@type='password']"));
		case "College":
			return driver.findElement(By.xpath("//*[@name='collegeName']"));
		case "Terms":
			return driver.findElement(By.xpath("//*[@name='exampleRadios']"));
		case "Register":
			return driver.findElement(By.xpath("//button[contains(text(),'Register')]"));
		default:
			System.out.println("Entered Objectname is not valid.Please check and enter again");
			return null;
		}
		
	}
	public static String getTextfromelement(WebDriver driver,String Control) 
	{
		
		return driver.findElement(By.xpath(Control)).getText();
	}

}
