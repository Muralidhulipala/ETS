package com.ETS.Utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import com.ETS.PageObjects.LoginandRegister;
import com.ETS.Utilities.ReadPropKey;

public class BaseTest {

	ReadPropKey prop=new ReadPropKey();
	ExcelDataReader r=new ExcelDataReader();
	int temp=0;
	protected WebDriver driver=null;
	@BeforeTest
	public void launchBrowser(ITestContext context) throws IOException, Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(prop.readpropkey("MDS_URL"));
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();

		//.waitforcontrol(driver, "//*[@formcontrolname='email']");
		//.LoginandRegisterObjects(driver, "username").sendKeys("muralidhu@gmail.com");
		//LoginandRegister.LoginandRegisterObjects(driver, "password").sendKeys("change");
		//LoginandRegister.LoginandRegisterObjects(driver, "btn_login").click();
		//Thread.sleep(5000);
		//String curl=driver.getCurrentUrl();
		//String redirecturl=curl.substring(0, curl.length()-8);
		//driver.navigate().to(redirecturl+"/admin-register");
		
		
	}
}
