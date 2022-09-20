package com.actime.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class BasePage implements AutoConstants
{
	
	public void clickUsingActions(WebDriver driver, WebElement e)
	{
		Actions ac = new Actions(driver);
		ac.click(e).perform();
	}
	
	public void mouseHoverUsingActions(WebDriver driver, WebElement e)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(e).perform();
	}
	
	public void doubleClickUsingActions(WebDriver driver, WebElement e)
	{
		Actions ac = new Actions(driver);
		ac.doubleClick(e).perform();
	}
	
	public void clickUsingJavascriptExecutor(WebDriver driver, WebElement e)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguements[0].click()", e);
	}
	
	public void performScroll(WebDriver driver, int x, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+""+y+")");
	}
	
	public void switchToNewWindow(WebDriver driver)
	{
		driver.switchTo().newWindow(WindowType.WINDOW);
	}
	
	public void switchToNewTab(WebDriver driver)
	{
		driver.switchTo().newWindow(WindowType.TAB);
	}
	
	public void selectByVisibleText(WebElement e, String text)
	{
		Select sel = new Select(e);
		sel.selectByVisibleText(text);
	}
	
	public void selectByIndex(WebElement e, int index)
	{
		Select sel = new Select(e);
		sel.selectByIndex(index);
	}
	
	public void selectByValue(WebElement e, String val)
	{
		Select sel = new Select(e);
		sel.selectByValue(val);
	}
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public String excelLibrary(String sheet, int row, int cell) throws IOException
	{
		FileInputStream file = new FileInputStream(excel_path);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		String cellVal = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return cellVal;
	}
	
	public void waitUntilVisibilityOfElement(WebDriver driver, WebElement e)
	{
		Duration d = Duration.ofSeconds(30);
		WebDriverWait wait = new WebDriverWait(driver, d);
		wait.until(ExpectedConditions.visibilityOf(e));
		
	}
	
	public void waitUntilVisibilityOfElements(WebDriver driver, java.util.List<WebElement> li)
	{
		Duration d = Duration.ofSeconds(30);
		WebDriverWait wait = new WebDriverWait(driver, d);
		wait.until(ExpectedConditions.visibilityOfAllElements(li));
		
	}
}
