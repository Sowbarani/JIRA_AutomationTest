package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * @author sowbaranip
 * 
 * Defines the PageObjects of Create New Issue Page
 *
 */
public class CreateIssue  {
	private final WebDriver driver;
		
	public CreateIssue(WebDriver driver)
	{
		this.driver = driver;								
	}
	
	By projectLocator = By.id("project-field");
	By issueTypeLocator = By.id("issuetype-field");
	By summaryLocator = By.id("summary");
	By securityLocator = By.id("security");
	By PriorityLocator = By.id("priority-field");
	By dueDateLocator = By.id("duedate");
	By componenetLocator = By.id("components-textarea");
	By versionLocator = By.id("versions-textarea");
	By assigneeLocator = By.id("assignee-field");
	By environmentLocator = By.id("environment");
	By descriptionLocator = By.id("description");
	By randomTextLocator = By.id("customfield_10010");
	By deliveryDateLocator = By.id("customfield_10041");
	By vendorLocator = By.id("customfield_10040");
	By burgerOption1 = By.id("customfield_10064-1");
	By burgerOption2 = By.id("customfield_10064-2");
	By burgerOption3 = By.id("customfield_10064-3");
	By burgerOption4 = By.id("customfield_10064-4");
	By attachmentLocator = By.xpath("//*[@id=\"create-issue-dialog\"]/div[2]/div[1]/div/form/div[1]/div[2]/fieldset[2]/div/div/label/input");
	By estimateLocator = By.id("timetracking");
	By animalTypeLocator = By.id("customfield_10061");
	By animalLocator = By.id("customfield_10061:1");
	By testorLocator = By.id("customfield_10530");
	By versionPickLocator = By.id("customfield_10550");
	By labelLocator = By.id("labels-textarea");
	By storyPntLocator = By.id("customfield_10653");
	By sprintLocator = By.id("customfield_11930-field");
	By epicLinkLocator = By.id("customfield_12931-field");
	By regexLocator = By.id("customfield_14130");
	By createBtnLocator = By.id("create-issue-submit");
	By cancelBtnLocator = By.className("cancel");
	
	
	public void selectLabel(String label)
	{
		driver.findElement(labelLocator).click();
		driver.findElement(labelLocator).sendKeys(label);
		driver.findElement(labelLocator).sendKeys(Keys.RETURN);
	}
	
	public void typeStoryPt(String storyPt)
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);		
		wait.until(ExpectedConditions.elementToBeClickable(storyPntLocator));
		driver.findElement(storyPntLocator).sendKeys(storyPt);
	}
	
	public void typeEpic(String epicLnk)
	{
		driver.findElement(epicLinkLocator).click();
		driver.findElement(epicLinkLocator).sendKeys(epicLnk);
		driver.findElement(epicLinkLocator).sendKeys(Keys.RETURN);
	}
	
	public void selectProject(String project)
	{
		driver.findElement(projectLocator).click();
		driver.findElement(projectLocator).sendKeys(project);
		driver.findElement(projectLocator).sendKeys(Keys.RETURN);
		
	}
	
	public void selectIssue(String issueType)
	{

		WebDriverWait wait = new WebDriverWait(driver, 200);		
		wait.until(ExpectedConditions.elementToBeClickable(issueTypeLocator));
		driver.findElement(issueTypeLocator).click();
		driver.findElement(issueTypeLocator).sendKeys(issueType);
		driver.findElement(issueTypeLocator).sendKeys(Keys.RETURN);	
		
	}
	
	public void typeSummary(String summary)
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);		
		wait.until(ExpectedConditions.elementToBeClickable(summaryLocator));
		driver.findElement(summaryLocator).sendKeys(summary);
	}
	
	public void selectSecurity(String security)
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);		
		wait.until(ExpectedConditions.elementToBeClickable(summaryLocator));
		Select selection = new Select(driver.findElement(securityLocator));
		selection.selectByValue(security);
	}
	
	public void selectPriority(String priority)	
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);		
		wait.until(ExpectedConditions.elementToBeClickable(PriorityLocator));
		driver.findElement(PriorityLocator).click();
		driver.findElement(PriorityLocator).sendKeys(priority);
		driver.findElement(PriorityLocator).sendKeys(Keys.RETURN);		
	}
	
	public void typeDate(String date)
	{
		driver.findElement(dueDateLocator).sendKeys(date);
	}
	
	public void selectComponents(String component)
	{
		driver.findElement(componenetLocator).click();
		driver.findElement(componenetLocator).sendKeys(component);
		driver.findElement(componenetLocator).sendKeys(Keys.RETURN);			
	}
	
	public void selectAffectVer(String version)
	{
		driver.findElement(versionLocator).click();
		driver.findElement(versionLocator).sendKeys(version);
		driver.findElement(versionLocator).sendKeys(Keys.RETURN);
	}
	
	public void selectAssigne(String assignee)
	{
		driver.findElement(assigneeLocator).click();
		driver.findElement(assigneeLocator).sendKeys(assignee);
		driver.findElement(assigneeLocator).sendKeys(Keys.RETURN);
	}
	
	public void typeEnvironment(String env)
	{
		driver.findElement(environmentLocator).sendKeys(env);
	}
	
	public void typeDescription(String desc)
	{
		driver.findElement(descriptionLocator).sendKeys(desc);
	}
	
	public void typeRandomText(String text)
	{
		driver.findElement(randomTextLocator).sendKeys(text);
	}
	
	public void typeVendorDeliveryDte(String date)
	{
		driver.findElement(deliveryDateLocator).sendKeys(date);
	}
	
	public void selectVendor(String vendor)
	{
		driver.findElement(vendorLocator).sendKeys(vendor);
	}
	
	public void checkBurger(String burger)
	{
		driver.findElement(burgerOption1).click();
	}
	
	public void attachFile(String fileLoc) throws InterruptedException, AWTException
	{
		driver.findElement(attachmentLocator).click();
		Thread.sleep(5000);
		StringSelection ss = new StringSelection(fileLoc);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		
	}
	
	public MainPage clickCreate()
	{
		driver.findElement(createBtnLocator).click();	
		
		return new MainPage(driver);
	}
	
	public MainPage clickCancel()
	{
		driver.findElement(cancelBtnLocator).click();
		
		return new MainPage(driver);
	}
}
