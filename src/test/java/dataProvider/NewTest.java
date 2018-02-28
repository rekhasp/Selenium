package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Testutil;

public class NewTest 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver_win32/chromedriver.exe");
		 
		 driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		  
		 driver.manage().deleteAllCookies();
		  
		 driver.get("http://www.facebook.com");
	}
	
	@DataProvider
	public Object[][] getlogindata()
	{
		Object data[][] = Testutil.getTestData(0);
		return data;

		
		//Object[][] data = new Object[3][2];
		//data[0][0] ="admin";
		//data[0][1] = "admin1";
	}
	
	
  @Test(dataProvider= "getlogindata")
  public void test(String username,String password)
  {
	  
	  driver.findElement(By.id("email")).sendKeys(username);
	  driver.findElement(By.id("pass")).sendKeys(password);
	  driver.findElement(By.id("loginbutton")).click();
	  	  
  }
  
  @AfterMethod
  public void closeout()
  {
	  driver.close();

  }
}
