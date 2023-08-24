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

public class ValidateTitle extends base{
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void initialize() throws IOException {

		 driver=initializedriver();
		 log.info("driver is initialized");
		 driver.get(prop.getProperty("url"));
		 log.info("navigated to home page");
	}
    @Test
	public void baseTestNavigation() throws IOException
    {
		 
		 landingPage l = new landingPage(driver);
		 //compare the text from the browser with actual text : Error
		 Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
		 //l.getTitle().getText();
		 log.info("successfullu validated text message");
    }
    @AfterTest
    public void teardown() {
    	driver.close();
    }
}