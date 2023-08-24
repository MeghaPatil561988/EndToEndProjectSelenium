package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	WebDriver driver;

	By email = By.cssSelector("input[id='user_email']");
	By password = By.cssSelector("input[id='user_password']");
	By login = By.cssSelector("input[type='submit']");
	By forgotPassword = By.cssSelector("[href*='password/new']");
	By alertNoThanks = By.xpath("//button[contains(text(),'NO THANKS')]");

	public loginPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebElement getemail()
	{
		
		return driver.findElement(email);
	}
	public WebElement getalertNoThanks()
	{
		
		return driver.findElement(alertNoThanks);
	}
	public WebElement getpassword() 
	{
		return driver.findElement(password);
	}
	
	public WebElement getlogin() 
	{
		return driver.findElement(login);
	}
	
	public ForgotPassword getforgotpassword()
	{
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	}
}
