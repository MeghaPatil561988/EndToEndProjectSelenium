package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.ForgotPassword;
import pageObjects.landingPage;
import pageObjects.loginPage;

public class HomePage extends base {
	public WebDriver driver;
	base b=new base();
	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	@BeforeTest
	public void initialize() throws IOException {

		 driver=initializedriver();
		 //driver.get(prop.getProperty("url")); // it takes only one set of data
	}
	@Test(dataProvider="getdata")
	public void baseTestNavigation(String Username,String Password,String text) throws IOException, InterruptedException {
		 
		 driver.get(prop.getProperty("url")); //so better we have to write here
		 landingPage l = new landingPage(driver);
		 loginPage lp=l.getLoginLink();
		 //b.waitforAlret();
		 //loginPage lp = new loginPage(driver);
		 lp.getemail().sendKeys(Username);
		 lp.getpassword().sendKeys(Password);
		 //System.out.println(text);
		 log.info(text);
		 lp.getlogin().click();
		 
		 ForgotPassword fp= lp. getforgotpassword();
			fp.getEmail().sendKeys("xxx");
			fp.sendMeInstructions().click();
		 
	}
	
	@DataProvider
	public Object[][] getdata() 
	{
	   //row stands for how many different data types test should run
		//column stands for how many values for each test
       Object[][] data = new  Object[2][3];
       //0th row
       data[0][0] = "nonrestricteduser@qw.com";
       data[0][1] = "12345";
       data[0][2] = "Restricted User";
       
       data[1][0] = "restricteduser@qw.com";
       data[1][1] ="67899";
       data[1][2] = "Non Resricted User";
      
       return data;
    }
	
	 @AfterTest
	    public void teardown() {
	    	driver.close();
	    }
}
