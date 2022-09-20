package com.actime.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.thoughtworks.qdox.tools.QDoxTester.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements AutoConstants
{
	public WebDriver driver;
	
	@BeforeSuite
	public void beforeSuiteMethod()
	{
		org.testng.Reporter.log("Execution begins", true);
		
	}
	
	@BeforeClass
	public void beforeClass()
	{
		org.testng.Reporter.log("Enter before class method", true);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(page_url);
	}
	
	@AfterClass
	public void afterClassMethod()
	{
		org.testng.Reporter.log("exiting afterclass method", true);
		driver.quit();
	}
	
	@AfterSuite
	public void afterSuiteMethod()
	{
		org.testng.Reporter.log("execution ends", true);
	}
}
