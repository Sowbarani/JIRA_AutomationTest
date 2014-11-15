package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author sowbaranip
 * 
 * Defines the PageObjects of Login Page
 *
 */

public class Login {
	
WebDriver _driver;
	
	public Login(WebDriver driver)
	{
		this._driver = driver;	
	}
	
	By loginLocator = By.xpath("//*[@id=\"user-options\"]/a");
	By signInGoogleLocator = By.id("google-signin-button");
	By usernameLocator = By.id("Email");
	By passwordLocator = By.id("Passwd");
	By signInBtnLocator = By.id("signIn");
	String parentHandle;
	
	public void clickLogin()
	{
		_driver.findElement(loginLocator).click();		
		
	}
	
	public void typeUser(String user)
	{		
		WebDriverWait WaitForElement = new WebDriverWait(_driver, 1000);
		WaitForElement.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
		_driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		_driver.findElement(usernameLocator).sendKeys(user);
	}
	
	public void typePasswd(String password)
	{
		
		_driver.findElement(passwordLocator).sendKeys(password);		
	}	
	
	public void clickGoogleSignIn() throws InterruptedException
	{
		_driver.findElement(signInGoogleLocator).click();
		_driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		parentHandle = _driver.getWindowHandle();
		for(String winHandle : _driver.getWindowHandles())
		{
			_driver.switchTo().window(winHandle);			
		}	
	}
	
	public MainPage clickSignIn()
	{	
		_driver.findElement(signInBtnLocator).click();		
		_driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		_driver.switchTo().window(parentHandle);
		return new MainPage(_driver);  // Returns to MainPage after login
	}

}
