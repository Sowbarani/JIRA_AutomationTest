

package JIRA_TestSuite;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.CreateIssue;
import pageObjects.FindIssue;
import pageObjects.Login;
import pageObjects.MainPage;
import pageObjects.UpdateIssue;

/**
 * @author sowbaranip
 * 
 * Description : TestSuite has test cases to "Create a New Issue", "Search for an Issue" and "Update an Existing Issue"
 * 
 * Gmail Username and Password should be given in Test1 before execution
 *
 */

public class TestSuite {
	
	private static WebDriver driver = null;
	FindIssue findObj = null;
	Login login = null;
	MainPage mainObj = null;
	UpdateIssue updateObj = null;
	
	// select the browser based on the parameter passed from testng.xml and initialize driver
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception
	{		
		if(browser.equalsIgnoreCase("FireFox"))
		{
			driver = new FirefoxDriver();			
		}
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		login = new Login(driver);
		findObj = new FindIssue(driver);
		mainObj = new MainPage(driver);
		updateObj = new UpdateIssue(driver);
		
		driver.get("https://jira.atlassian.com/browse/TST");	
				
	}
	
	// Test to create a new issue. It logins to JIRA using GMail account and navigate to the Create Page and create a new issue
		
	@Test
	void createNewIssue() throws InterruptedException, AWTException
	{				
		login.clickLogin();		
		login.clickGoogleSignIn();	
			
		login.typeUser(""); // Login with Gmail credentials
		login.typePasswd("");		
		mainObj = login.clickSignIn();
			
		CreateIssue bugObj = mainObj.clickCreate();
		bugObj.selectProject("atlassian-csv (CSV)");
		bugObj.selectIssue("Bug");
		bugObj.typeSummary("This is a test burt");
		bugObj.typeEnvironment("This is a test environment");
		bugObj.typeDescription("This is a test description");
		bugObj.selectLabel("blue");
		bugObj.typeStoryPt("3");		
		mainObj = bugObj.clickCreate();
		//mainObj = bugObj.clickCancel();		
	}
	
	//Test to search for an issue in JIRA. Filter's with the below given parameters and displays the result
	
	@Test(dependsOnMethods = { "createNewIssue" })
	void FindIssue()
	{
		mainObj.clickIssue();
		findObj = mainObj.findIssue();
		findObj.clickNewFilter();
		findObj.filterProject("atlassian-csv (CSV)");
		findObj.filterBug("Bug");
		findObj.filterStatus("OPEN");		
		findObj.filterText("This is a test burt");
		updateObj = findObj.clickFilter();		
	}
	
	// Test to update an issue. This test updates the comment section of the issue.
	
	@Test(dependsOnMethods = { "FindIssue" })
	void UpdateIssue() throws AWTException
	{
		updateObj.updateComment("Test Bug Updated");		
		
	}
}
