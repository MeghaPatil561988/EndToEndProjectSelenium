package pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticePage 
{
     public WebDriver driver;
    
    By numoflinks = By.tagName("a");
    By footerallinks = By.id("gf-BIG");
    By columnwisefooterlinks = By.xpath("//table/tbody/tr/td/ul");
    
    @FindBy(xpath = "//a[contains(text(),'Practice')]")
    private WebElement practicepagelink;

    @FindBy(id = "checkBoxOption2")
    private WebElement checkboxopt2;
   
    @FindBy(id = "dropdown-class-example")
    private WebElement dropdownelement;
    
    @FindBy(id = "name")
    private WebElement selectdpoption;
    
    @FindBy(id = "alertbtn")
    private WebElement alertbtn;
    
    @FindBy(xpath = "//input[@id='checkBoxOption1']")
    private WebElement checkBoxOption1;
    
    @FindBy(css = "input[type*='checkbox']")
    private WebElement totalcheckboxes;
    
    @FindBy(id = "autocomplete")
    private WebElement autosearch;
    
    
    @FindBy(css="li[class='gf-li'] a")
    private  List<WebElement> brokenlinks;
    
   
    
    
    public PracticePage(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickpracticepagelink()
    {
      practicepagelink.click();
	}

    public void clickcheckboxopt2(String value)
    {
    	checkboxopt2.click();
    	checkboxopt2.getAttribute(value);
    	
    }
    
    public WebElement selectdropdowncategory()
    {
      return dropdownelement;
    }

    public void selectdropdownption(String var)
    {
       
       selectdpoption.sendKeys(var);
    }
    public void clickalertbutton()
    {
    	alertbtn.click();
	}
    
    public WebElement verifyselectedcheckbox()
    {
    	checkBoxOption1.click();
		return checkBoxOption1;
    	
    }
    
    public WebElement totalcheckboxes() 
    {
    	return totalcheckboxes;
    }
    
   
    public WebElement autosearchdropdown() 
    {
    	
    	return autosearch;
    	
    }
    public List<WebElement> allbrokenLinks()
    {
    	return brokenlinks;
    }
    
   
    
}
