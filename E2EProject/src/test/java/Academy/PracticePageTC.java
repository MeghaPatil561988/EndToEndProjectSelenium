package Academy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Resources.Utility;
import Resources.base;
import pageObjects.PracticePage;

public class PracticePageTC extends base
{
	 public WebDriver driver;
	 private static Logger log = LogManager.getLogger( PracticePageTC.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException 
	{
		 driver=initializedriver();
		 log.info("driver is initialized");
		 driver.get(prop.getProperty("url"));
		 log.info("navigated to home page");
	}

	@Test(enabled=false)
	public void clickonPracticelink() throws IOException, InterruptedException
    {
		PracticePage practicepage = new PracticePage(driver);
		Utility utility = new Utility(driver);
		
		//click on practice page link
		practicepage.clickpracticepagelink();
		utility.wait(3);
		System.out.println("navigated to practice page");
		
		//click on checkbox option 2
		practicepage.clickcheckboxopt2("value");
		utility.wait(3);
		System.out.println("checkbox selected");
		
		//select dropdown category
		WebElement dropdownelement= practicepage.selectdropdowncategory();
		String var=utility.dropdownValue(dropdownelement, "Option2");
		utility.wait(3);
		//selected drpdown option send to textbox
		practicepage.selectdropdownption(var);
		System.out.println(var);
		 
		utility.wait(3);
		practicepage.clickalertbutton();
		utility.wait(3);
		System.out.println("alert button clicked");
		
		//handle alert and handle assertion
	      String ExpTitle="Hello Option2, share this practice page and share your knowledge";
		  utility.verifyactualandexpected(ExpTitle);
		  System.out.println(ExpTitle);  
		
		}
	@Test(enabled=false)
	public void numberofcheckboxes() 
	{
		PracticePage practicepage = new PracticePage(driver);
		Utility utility = new Utility(driver);
		//click on practice page link
				practicepage.clickpracticepagelink();
				utility.wait(3);
				System.out.println("navigated to practice page");
        
		/*utility.assertFalse(practicepage.verifyselectedcheckbox());
		utility.wait(3);*/
		
		utility.assertTrue(practicepage.verifyselectedcheckbox());
		utility.wait(3);
		
		utility.assertFalse(practicepage.verifyselectedcheckbox());
		utility.wait(3);
		
		//count the number of checkboxes
		System.out.println(practicepage.totalcheckboxes().getSize());
	}

	@Test(enabled=false)
	public void AutoSugestiveDropDown()
	{
		        PracticePage practicepage = new PracticePage(driver);
		        Utility utility = new Utility(driver);
		        //click on practice page link
				practicepage.clickpracticepagelink();
				utility.wait(3);
				System.out.println("navigated to practice page");
				
				//Autosujestive dropdown
				/*practicepage.autosearchdropdown("united");
				utility.wait(3);
				System.out.println(practicepage.autosearchdropdown("value"));*/
				
				WebElement element = practicepage.autosearchdropdown();
				 System.out.println(utility.keyDown(element, "united"));
	}
	
	
	@Test
	public void BrokenLinks() throws MalformedURLException, IOException
	{
		
		PracticePage practicepage = new PracticePage(driver);
        Utility utility = new Utility(driver);
        //click on practice page link
		practicepage.clickpracticepagelink();
		utility.wait(3);
		System.out.println("navigated to practice page");
		
		 SoftAssert a =new SoftAssert();
		 List<WebElement> links = practicepage.allbrokenLinks();
         for(WebElement link : links)

         {

          String url= link.getAttribute("href");

          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

          conn.setRequestMethod("HEAD");

          conn.connect();

          int respCode = conn.getResponseCode();

          System.out.println(respCode);

          a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);

          }
          a.assertAll();
          
			
	}
	
	@AfterTest
	 public void teardown()
	 {
		 driver.close();
	 }
}
