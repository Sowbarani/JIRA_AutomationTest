package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author sowbaranip
 * 
 * Defines the PageObjects of the JIRA home page
 *
 */

public class MainPage {
	
	private final WebDriver driver;
	
	public MainPage(WebDriver driver)
	{
		this.driver= driver;			
				
	}
		
	By createLinkLocator = By.id("create_link");
	By issueLnkLocator = By.id("com.atlassian.jira.jira-projects-plugin:issues-panel-panel");
	By searchallLnkLocator = By.id("filter_all");	
	
	public CreateIssue clickCreate()
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);		
		wait.until(ExpectedConditions.elementToBeClickable(createLinkLocator));
		driver.findElement(createLinkLocator).click();		
		return new CreateIssue(driver);
	}
	
	public void clickIssue()
	{
		driver.findElement(issueLnkLocator).click();
		
	}
	
	public FindIssue findIssue()
	{
		driver.findElement(searchallLnkLocator).click();	
		
		return new FindIssue(driver); // Returns to find issue page after creating new issue
		
	}
	
}
