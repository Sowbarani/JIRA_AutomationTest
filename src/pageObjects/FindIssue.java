package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


/**
 * @author sowbaranip
 * 
 * Defines the PageObjects of search issue page
 *
 */

public class FindIssue {
	
private final WebDriver driver;
	
	public FindIssue(WebDriver driver)
	{
		this.driver= driver;			
				
	}
	
	By newFilterBtnLocator = By.xpath("//*[@id=\"navigator-sidebar\"]/div[1]/div/ul/li[1]/a");
	
	By projectFilterBtnLocator = By.xpath("//*[@id=\"fieldpid\"]");
	By projectFilterTxtLocator = By.id("searcher-pid-input");
	
	By bugFilterBtnLocator = By.xpath("//*[@id=\"content\"]/div[1]/div[4]/div/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/ul/li[2]/button");
	By bugFilterTxtLocator = By.id("searcher-type-input");
	
	By statusFilterBtnLocator = By.xpath("//*[@id=\"content\"]/div[1]/div[4]/div/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/ul/li[3]/button");
	By statusFilterTxtLocator = By.id("searcher-status-input");
	
	By assigneFilterBtnLocator = By.xpath("//*[@id=\"content\"]/div[1]/div[4]/div/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/ul/li[4]/button");
	By assigneFilterTxtLocator = By.id("assignee-input");
	
	By textFilterLocator = By.id("searcher-query");
	By filterBtnLocator = By.xpath("//*[@id=\"content\"]/div[1]/div[4]/div/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/ul/li[7]/button");
	
	
	public void clickNewFilter()
	{
		driver.findElement(newFilterBtnLocator).click();
	}
	
	public void filterProject(String project)
	{
		driver.findElement(projectFilterBtnLocator).click();
		driver.findElement(projectFilterTxtLocator).sendKeys(project);
		driver.findElement(projectFilterTxtLocator).sendKeys(Keys.RETURN);	
	}
	
	public void filterBug(String bug)
	{
		driver.findElement(bugFilterBtnLocator).click();
		driver.findElement(bugFilterTxtLocator).sendKeys(bug);
		driver.findElement(bugFilterTxtLocator).sendKeys(Keys.RETURN);	
	}
		
	public void filterStatus(String status)
	{
		driver.findElement(statusFilterBtnLocator).click();
		driver.findElement(statusFilterTxtLocator).sendKeys(status);
		driver.findElement(statusFilterTxtLocator).sendKeys(Keys.RETURN);	
	}
	
	public void filterAssignee(String assignee)
	{
		driver.findElement(assigneFilterBtnLocator).click();
		driver.findElement(assigneFilterTxtLocator).sendKeys(assignee);
		driver.findElement(assigneFilterTxtLocator).sendKeys(Keys.RETURN);	
	}
	
	public void filterText(String text)
	{
		
		driver.findElement(textFilterLocator).sendKeys(text);
			
	}
	
	public UpdateIssue clickFilter()
	{
		driver.findElement(filterBtnLocator).click();
		
		return new UpdateIssue(driver); // Return to Update issue page once the search is completed
	}

}
