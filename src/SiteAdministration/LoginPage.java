package SiteAdministration;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;

import java.util.List;

import java.io.IOException;







@Test
public class LoginPage {
	
	public ArrayList<TestResult> testresultlist = new ArrayList<TestResult>();

	public String siteurl = "http://172.20.22.81/omnipcxrecord/TenantAdmin.aspx";
	public String driverPath = "C:\\Selenium\\chromedriver.exe";
	public String downloadFilepath ="C:\\Temp";
	public WebDriver driver; 
	UpdateTestResult obj = new UpdateTestResult();
	
@BeforeTest
public void beforeTest(){
	
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--download.default_directory", downloadFilepath);
	  driver = new ChromeDriver(options);
		  }

/*
public void verifyLoingwithValidCredentials() throws IOException {
	  
	  
	 String SheetName = "2- Login";
	 String TestCaseID = "02-01";
	 String Status = "";
	 
	 if(driver==null){
		 
		 System.out.println("WebDriver not initialized");
		 return;
	  }
	 
	 
	  try{
		  
	  driver.get(siteurl);
	  
	  driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
	  driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
	  driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	  
	  String expectedurl = "http://172.20.22.81/OmniPCXRECORD/Searches.aspx";
	  String actualurl = driver.getCurrentUrl();
	  
	  System.out.println("Actual Url : "+actualurl);
	  System.out.println("Expected Url : "+expectedurl);
	  

	  Assert.assertEquals(actualurl, expectedurl);
	  
	  Status = "Pass";
	  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	  testresultlist.add(objtestreult);
	  //obj.updateResult(TestCaseID, SheetName, Status);
	  
	 Thread.sleep(3000);
	  }
	  catch(Throwable e) {
		  System.out.println("Error : " +e);
		  Status = "Fail";
		  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		  testresultlist.add(objtestreult);
		 //obj.updateResult(TestCaseID,SheetName,Status);
		 
		
		 
	  }     
      	  
  }

public void verifyLoingwithInValidCredentials() throws IOException {
	  
	  
	 String SheetName = "2- Login";
	 String TestCaseID = "02-02";
	 String Status = "";
	 
	 if(driver==null){
		 
		 System.out.println("WebDriver not initialized");
		 return;
	  }
	 
	 
	  try{
		  
	  driver.get(siteurl);
	  
	  driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
	  driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
	  driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	  
	  String expectedurl = "http://172.20.22.81/OmniPCXRECORD/Searches.aspx";
	  String actualurl = driver.getCurrentUrl();
	  
	  System.out.println("Actual Url : "+actualurl);
	  System.out.println("Expected Url : "+expectedurl);
	  

	  Assert.assertEquals(actualurl, expectedurl);
	  
	  Status = "Pass";
	  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	  testresultlist.add(objtestreult);
	  //obj.updateResult(TestCaseID, SheetName, Status);
	  
	 Thread.sleep(3000);
	  }
	  catch(Throwable e) {
		  System.out.println("Error : " +e);
		  Status = "Fail";
		  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		  testresultlist.add(objtestreult);
		 //obj.updateResult(TestCaseID,SheetName,Status);
		 
		
		 
	  }     
     	  
 }
 */
@Test (priority = 14)
public void verifyDeletePermissionGroup() throws InterruptedException, IOException {
	

  driver.get(siteurl);

  String SheetName = "29- Permission's";
	  String TestCaseID = "29-07";
	  String Status = "";
	 
	  if(driver==null){
		 
		 System.out.println("WebDriver not initialized");
		 return;
	  }
	  
	  try{
  
  // Signing in OmniPCX 
  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  
  // Click On Permissions
  
  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPermissions")).click();

  //Get the table and row                                
  WebElement table =driver.findElement(By.id("gvGroups")); 
  WebElement tbody=table.findElement(By.tagName("tbody"));
  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
  String rowNo="";
  String Secgroup = "1.Login to server administration...";
 	for(int i=0;i<rows.size();i++)
 	{
 	WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr["+(i+1)+"]")); 
 	if(row.getText().trim().contains(Secgroup))
 	{
 	rowNo=Integer.toString(i+1);
 	break;
 	}
 	}
 	System.out.println(rowNo);
 		
 	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr["+rowNo+"]/td[3]/div/img[4]")).click();
  
//  // Click on delete
//  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[7]/td[3]/div/img[4]")).click();
  
  // Check alert message
  JavascriptExecutor jsy = (JavascriptExecutor)driver;
  jsy.executeScript("window.confirm('Are you sure you want to delete this group?')");
 
  /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
  Dismissed user prompt dialog: Settings have been updated successfully:*/
  driver.switchTo().alert().accept();
 
  // Click on delete button
  
  driver.findElement(By.id("btnDelete")).click(); 
  Thread.sleep(2000);
  
  String Expectedmsg = "Record has been deleted successfully";
  String Actualmsg = driver.findElement(By.id("lblGridMsg")).getText();
  
  Assert.assertEquals(Actualmsg, Expectedmsg);
  
  Status = "Pass";
  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
  testresultlist.add(objtestreult);
  //obj.updateResult(TestCaseID, SheetName, Status);
  
  
  }
  catch(Throwable e) {
	  System.out.println("Error : " +e);
	  Status = "Fail";
	  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	  testresultlist.add(objtestreult);		}
  
  driver.close();
}
  
 @AfterTest 
 public void afterTest() {
	 
	 try {
		 System.out.println("Closing the Browser");
		 obj.updateResult(testresultlist);
		 driver.quit();
		 }
	 
	 catch(Throwable e) {
		 System.out.println("Error :" +e);
		 }
 
 }
 
 


}



