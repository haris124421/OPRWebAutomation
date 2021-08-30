package SiteAdministration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AgentManagement {
	
	public String siteurl = "http://172.20.11.238/QuickSuite/Login.aspx";
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
 
	  @Test(priority=14)
	  public void DeleteAgent1017() throws InterruptedException {
	  System.out.println("DeleteAgent1017");
	  driver.get(siteurl);
	  //Enter Username
	  driver.findElement(By.id("txtUsername")).sendKeys("admin");
	  //Enter Password
	  driver.findElement(By.id("txtPassword")).sendKeys("admin");
	  //Click on Login button
	  driver.findElement(By.id("login_button")).click();
	  //Wait for the browser to respond
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//*[@id=\"productLogo\"]/div[1]/img")).click();
	  Thread.sleep(2000);
	  //Click on Agents tab from left menu
	  
	  driver.switchTo().frame("productiframe");
	  driver.findElement(By.id("ctl00_ctrlTopMenuSuperAdmin1_lblAgents")).click();
	  Thread.sleep(2000);
	  //Click on Field Name dropdown
	  Select dropdown1 = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_UsersSearch1_cboFieldName")));
	  //Select Username from dropdown
	  dropdown1.selectByVisibleText("Username");
	  //Search the added agent
	  driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_UsersSearch1_txtSearchField")).sendKeys("ehunt");
	  //Click on Find button
	  driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_UsersSearch1_btnFind")).click();
	  Thread.sleep(2000);
	  //Delete the agent ehunt
	  driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_UsersSearch1_GridView1_ctl02_imgbtnDelete")).click();
	  //Wait for the browser to respond
	  Thread.sleep(2000);;
	  //Verify the message
	  String expectedmsg="It will remove all teams and extensions association! Are you sure you want to remove association for the user: \"ehunt\"?";
	  //Wait for the browser to respond
	  Thread.sleep(2000);
	  String actualmsg = driver.findElement(By.id("dialog-message")).getText();
	  Assert.assertEquals(actualmsg, expectedmsg);
	  System.out.println("Expected Result : "+expectedmsg);
	  System.out.println("Actual Result : " +actualmsg);
	  //Click on Remove button displayed in popup window
	  driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/button[1]/span")).click();
	  //Wait for the browser to respond
	  Thread.sleep(2000);

	  //Verify the message
	  String expectedmsg1="Association has been removed successfully.";
	  //Wait for the browser to respond
	  Thread.sleep(2000);
	  String actualmsg1 = driver.findElement(By.id("dialog-alertMessage")).getText();
	  Assert.assertEquals(actualmsg1, expectedmsg1);
	  System.out.println("Expected Result : "+expectedmsg1);
	  System.out.println("Actual Result : " +actualmsg1);
	  //Click on OK button
	  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
	  Thread.sleep(2000);



	  //Delete the User ehunt
	  //Hover the mouse on settings icon which is available on top right and select Users
	  driver.switchTo().parentFrame();
	  Actions action1 = new Actions(driver);
	  WebElement menu1 = driver.findElement(By.xpath("//img[@src='images/NewMockup/settings_s.png']"));
	  Thread.sleep(2000);
	  action1.moveToElement(menu1).moveToElement(driver.findElement(By.xpath("//a[contains(.,'Users')]"))).click().build().perform();
	  //Wait for the browser to respond
	  Thread.sleep(2000);
	  //Click on Field Name dropdown
	  Select dropdown2 = new Select(driver.findElement(By.id("ContentPlaceHolder1_cboFieldName")));
	  //Select Username from dropdown
	  dropdown2.selectByVisibleText("Username");
	  //Search the added agent
	  driver.findElement(By.id("ContentPlaceHolder1_txtSearchField")).sendKeys("ehunt");
	  //Click on Find button
	  driver.findElement(By.id("ContentPlaceHolder1_btnUpdateLog")).click();
	  //Wait for the browser to respond

	  //Click on delete button to delete the user
	  driver.findElement(By.id("ContentPlaceHolder1_GVUsers_imgbtnDelete_0")).click();
	  Thread.sleep(2000);
	  //Verify the message
	  String expectedmsg2="Are you sure you want to delete user: \"ehunt\"?";
	  //Wait for the browser to respond
	  Thread.sleep(2000);
	  String actualmsg2 = driver.findElement(By.id("dialog-message")).getText();
	  Assert.assertEquals(actualmsg2, expectedmsg2);
	  System.out.println("Expected Result : "+expectedmsg2);
	  System.out.println("Actual Result : " +actualmsg2);
	  //Click on Delete button displayed on popup window
	  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button[1]/span")).click();
	  //Wait for the browser to respond
	  Thread.sleep(2000);
	  //Verify the message
	  String expectedmsg3="User has been deleted successfully.";
	  Thread.sleep(2000);
	  String actualmsg3 = driver.findElement(By.id("dialog-alertMessage")).getText();
	  Assert.assertEquals(actualmsg3, expectedmsg3);
	  System.out.println("Expected Result : "+expectedmsg3);
	  System.out.println("Actual Result : " +actualmsg3);


	  //Hover the mouse on settings icon which is available on top right and select Users
	  Actions action2 = new Actions(driver);
	  WebElement menu2 = driver.findElement(By.xpath("//img[@src='images/NewMockup/settings_s.png']"));
	  Thread.sleep(2000);
	  action2.moveToElement(menu2).moveToElement(driver.findElement(By.xpath("//a[contains(.,'Users')]"))).click().build().perform();
	  //Search the User e@hunt
	  driver.findElement(By.id("ContentPlaceHolder1_txtSearchField")).sendKeys("e@hunt");
	  //Click on Find button
	  driver.findElement(By.id("ContentPlaceHolder1_btnUpdateLog")).click();
	  Thread.sleep(3000);
	  //Click on delete button to delete the user
	  driver.findElement(By.id("ContentPlaceHolder1_GVUsers_imgbtnDelete_0")).click();
	  //Wait for the browser to respond
	  Thread.sleep(2000);
	  //Verify the message
	  String expectedmsg4="Are you sure you want to delete user: \"e@hunt\"?";;
	  //Wait for the browser to respond
	  Thread.sleep(2000);
	  String actualmsg4 = driver.findElement(By.id("dialog-message")).getText();
	  Assert.assertEquals(actualmsg4, expectedmsg4);

	  System.out.println("Expected Result : "+expectedmsg4);
	  System.out.println("Actual Result : " +actualmsg4);
	  //Click on Delete button
	  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button[1]/span")).click();
	  //Wait for the browser to respond
	  Thread.sleep(2000);
	  //Verify the message
	  String expectedmsg5="User has been deleted successfully.";
	  //Wait for the browser to respond
	  Thread.sleep(2000);
	  String actualmsg5 = driver.findElement(By.id("dialog-alertMessage")).getText();
	  Assert.assertEquals(actualmsg5, expectedmsg5);

	  System.out.println("Expected Result1 : "+expectedmsg5);
	  System.out.println("Actual Result1 : " +actualmsg5);

	  }




  }

