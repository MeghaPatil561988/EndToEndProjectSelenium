package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.landingPage;
//adding logs
//generating html report
//screenshots on failure
//jenkins integration

public class ValidateNavigation extends base
{
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(ValidateNavigation.class.getName());
	@BeforeTest
	public void initialize() throws IOException 
	{
		 driver=initializedriver();
		 driver.get(prop.getProperty("url"));
	}
	
	 @Test
		public void baseTestNavigation() throws IOException
	    {
			 landingPage l = new landingPage(driver);
			 Assert.assertTrue(l.getNavigationBar().isDisplayed());
			 //Assert.assertFalse(false);
			 log.info("");
	    }
	 @AfterTest
	 public void teardown()
	 {
		 driver.close();
	 }

}
