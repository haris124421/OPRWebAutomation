package SiteAdministration;

import java.text.ParseException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TeamsManagement {
	public String siteurl = "http://172.20.22.81/omnipcxrecord/TenantAdmin.aspx";
	public String driverPath = "C:\\Selenium\\chromedriver.exe";
	public String downloadFilepath ="C:\\Temp";
	public WebDriver driver;
	
	@BeforeTest
	public void beforeTest(){
		
		  System.setProperty("webdriver.chrome.driver", driverPath);
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--download.default_directory", downloadFilepath);
		  driver = new ChromeDriver(options);
			  }
	
	
	@Test (priority = 0)
	public void verifyfieldSearchIncidents() throws InterruptedException, ParseException {
		driver.get(siteurl);


	// Signing in OmniPCX
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();

	// Click on Server Incidents
	Thread.sleep(3000);
	driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();

	// Enter from date
	driver.findElement(By.id("txtFromDate")).clear();
	driver.findElement(By.id("txtFromDate")).sendKeys("01/08/2021");

	// Click on find
	driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();

	if (driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr/td[1]/img")).isDisplayed() == true) {
	String expecteddate = driver.findElement(By.id("txtFromDate")).getAttribute("value");
	System.out.println(expecteddate);
    driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/thead/tr/th[2]/span")).click();

	String actualdate = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table[2]/tbody/tr[4]/td/div[2]/table/tbody/tr/td[2]/span")).getText();
	System.out.println(expecteddate);
	System.out.println(actualdate);
	Assert.assertTrue(actualdate.contains(expecteddate));
	}

	else if (driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr/td")).isDisplayed() == true) {
	System.out.println("Try another date");
	Assert.assertFalse(true);
	}

	driver.close();

	}



	
	 @AfterTest 
	 public void afterTest() {
		 
		 try {
			 System.out.println("Closing the Browser");
		
			 driver.quit();
			 }
		 
		 catch(Throwable e) {
			 System.out.println("Error :" +e);
			 }
	 
	 }
 
}
