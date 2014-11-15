package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author sowbaranip
 * 
 * Defines the PageObjects of Update Issue Page
 *
 */

public class UpdateIssue {
	
private final WebDriver driver;
	
	public UpdateIssue(WebDriver driver)
	{
		this.driver= driver;			
				
	}
		
	By attachFileBtnLocator = By.xpath("//*[@id=\"drag-and-drop-attachment-panel\"]/div[2]/div/label");
	By attachFileInptLocator = By.xpath("//*[@id=\"drag-and-drop-attachment-panel\"]/div[2]/div/label/input");
	By commentBtnLocator = By.id("footer-comment-button");
	By commentTxtLocator = By.id("comment");
	By commentSubmitLocator = By.id("issue-comment-add-submit");

	
	public void updateComment(String comment)
	{
		driver.findElement(commentBtnLocator).click();
		driver.findElement(commentTxtLocator).sendKeys(comment);
		driver.findElement(commentSubmitLocator).click();
	}

}
