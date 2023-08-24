package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
WebDriver driver;

By signin = By.cssSelector("a[href*='sign_in']");
//By signin = By.xpath("span[contains(text(),'Login')]");
//By title = By.cssSelector(".text-centre>h2");
By title = By.xpath("//h2[text()='Featured Courses']");
By navbar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");

public landingPage(WebDriver driver) 
{
	this.driver=driver;
}



public loginPage getLoginLink() {
	
	 driver.findElement(signin).click();
	 loginPage lp = new loginPage(driver);
	 return lp;
}

public WebElement getTitle() {
	return driver.findElement(title);
	
}
public WebElement getNavigationBar() {
	return driver.findElement(navbar);
}


}
