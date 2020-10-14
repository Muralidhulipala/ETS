package com.ETSProject.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ETS.Utilities.Waitforcontrol;
import com.ETS.PageObjects.ETSLogin;
import com.ETS.PageObjects.LoginandRegister;
import com.ETS.Utilities.BaseTest;
import com.ETS.Utilities.ExcelDataReader;
import com.ETS.Utilities.ReadPropKey;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class ETSUserRegistration extends BaseTest{
	ExcelDataReader er=new ExcelDataReader();
	 ReadPropKey prop=new ReadPropKey();
	 
	 int r=0;
	 
	@Test(dataProvider="TestdataSupply",priority=0)
	public  void User(String firstname,String lastname ,String email,String password,String mobile,String college) throws Exception
	{
		BaseTest b=new BaseTest();
		driver.navigate().to(prop.readpropkey("MDS_RegisterURL"));
		//b.launchBrowser();
		//Clicking on flash screen
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("el = document.elementFromPoint(676, 136); el.click();");

		//waiting for the home screen
		
		//Waitforcontrol.waitforcontrol(driver, "//*[contains(text(),'Login')]");
		//Clicking on Login screen
		
		//LoginandRegister.LoginandRegisterObjects(driver, "Login").click();
		
		//Waiting for the register link on login screen
		
		//Waitforcontrol.waitforcontrol(driver, "//*[@href='#register']");
		
		//Clicking on Register link
		//LoginandRegister.LoginandRegisterObjects(driver, "Registertab").click();
		//Waiting for the register screen
		
		
		
		
		//entering the first name
		Waitforcontrol.waitforcontrol(driver, "//*[@name='firstName']");
		LoginandRegister.LoginandRegisterObjects(driver, "Firstname").sendKeys(firstname);
		//entering the last name
		LoginandRegister.LoginandRegisterObjects(driver, "Lastname").sendKeys(lastname);
		//entering the email address
		LoginandRegister.LoginandRegisterObjects(driver, "Email").sendKeys(email);
		//entering password
		LoginandRegister.LoginandRegisterObjects(driver, "Password").sendKeys(password);
		//entering mobile number
		LoginandRegister.LoginandRegisterObjects(driver, "Mobilenumber").sendKeys(mobile);
		//entering college name
		LoginandRegister.LoginandRegisterObjects(driver, "College").sendKeys(college);
		//clicking on check box
		LoginandRegister.LoginandRegisterObjects(driver, "Terms").click();
		//clicking on register button
		LoginandRegister.LoginandRegisterObjects(driver, "Register").click();
		Waitforcontrol.waitforcontrol(driver, "//*[@class='ui-toast-message-content']");
		String text=LoginandRegister.getTextfromelement(driver, "//*[@class='ui-toast-message-content']");
	//String text=driver.findElement(By.xpath("//*[@class='ui-toast-message-content']")).getText();
		System.out.println(text);
		r=r+1;
		er.resultexport(r,text);
		
		//driver.quit();
		
		//driver.manage().window().maximize();
		//Thread.sleep(3000);
		//driver.close();
	}
	
	@Test(dataProvider="TestdataSupply",priority=1)
	public void LoginPagelevelvalidations(String username,String password,String ExpectedResult,String AR) throws Exception
	{
//System.out.println(ETSLogin.LoginandHomepage(driver, "UserProfile").isDisplayed());
				//waiting for the home screen
		if(r>0)
		{
			r=0;
		}
		if(Waitforcontrol.isElementdisplayed(driver, "//*[contains(text(),'Login')]")==true)
		{
			ETSLogin.LoginandHomepage(driver, "Login").click();
			Waitforcontrol.waitforcontrol(driver, "//*[@formcontrolname='email']");
		}
		//Clicking on Login screen
		
		if(username!=null)
		{
			ETSLogin.LoginandHomepage(driver, "username").sendKeys(username);
		}
		if(password!=null)
		{
			ETSLogin.LoginandHomepage(driver, "password").sendKeys(password);
			ETSLogin.LoginandHomepage(driver, "btn_login").click();
			Waitforcontrol.waitforcontrol(driver, "//*[contains(text(),'My Profile')]");
		}
						switch(ExpectedResult) 
						{
						case "User profile default validation":
							if(ETSLogin.LoginandHomepage(driver, "UserProfile").isDisplayed()==true)
							{
								r=r+1;
								er.resultexport(r, "User profile page is being displayed");
							}
							else
							{
								er.resultexport(r, "User profile page is not being displayed");
							}
						case "Right top logo validaion":
							if(ETSLogin.LoginandHomepage(driver, "UserLogo_Righttop").isDisplayed()==true)
							{
								r=r+1;
								er.resultexport(r, "User Logo on top right page is being displayed");
							}
							else
							{
								er.resultexport(r, "User Logo on top right page is not being displayed");
							}
						case "Left gutter logo validation":
		
							if(ETSLogin.LoginandHomepage(driver, "UserLogo_LeftGutter").isDisplayed()==true)
							{
								r=r+1;
								er.resultexport(r, "User Logo on left gutter is being displayed");
							}
							else
							{
								er.resultexport(r, "User Logo on left gutter is not being displayed");
							}
						case "Dashboard tab validation":
							if(ETSLogin.LoginandHomepage(driver, "DashBoard").isDisplayed()==true)
							{
								r=r+1;
								er.resultexport(r, "DashBoard is being displayed");
							}
							else
							{
								er.resultexport(r, "DashBoard is not being displayed");
							}
						case "Take Exam tab validation":
							if(ETSLogin.LoginandHomepage(driver, "Takeexam").isDisplayed()==true)
							{
								r=r+1;
								er.resultexport(r, "Take exam is being displayed");
							}
							else
							{
								er.resultexport(r, "Take exam is not being displayed");
							}
						case "Daily Practice tab validation":
							if(ETSLogin.LoginandHomepage(driver, "Dailypractice").isDisplayed()==true)
							{
								r=r+1;
								er.resultexport(r, "Daily practice is being displayed");
							}
							else
							{
								er.resultexport(r, "Daily practice is not being displayed");
							}
						case "Performance tab validation":
		
							if(ETSLogin.LoginandHomepage(driver, "Performance").isDisplayed()==true)
							{
								r=r+1;
								er.resultexport(r, "Performance is being displayed");
							}
							else
							{
								er.resultexport(r, "Performance is not being displayed");
							}
							default:
								er.resultexport(r, "Testcase not present in test data sheet");
								
								
						}
					
					
				}
				
	@DataProvider
	public Object[][] TestdataSupply() throws Exception {
		
		
		return er.getExceData();
	}
}
