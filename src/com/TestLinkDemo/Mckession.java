package com.TestLinkDemo;

	import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebDriverBackedSelenium;
	import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.firefox.FirefoxDriver;
	import com.thoughtworks.selenium.SeleneseTestBase;
	import com.thoughtworks.selenium.Selenium;
	import testlink.api.java.client.TestLinkAPIResults;


	public class Mckession extends SeleneseTestBase implements IConstants {
	 
	 String validateText;
	 WebDriver driver;
	 Selenium selenium;
	 
	 @BeforeMethod
	public void antesde() throws Exception
	 {
		 
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\skumar\\Desktop\\Selenium Stuff\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		  
	  
	     String baseUrl ="http://jira.mscripts.com:8080//browse/PHA-2535";
	     
	     selenium = new WebDriverBackedSelenium(driver, baseUrl);
	     selenium.open(baseUrl);
	     
	 }
	 
	 @AfterMethod
	public void limpiar()
	 {
	  System.out.println("Check Results");
	  //driver.close();
	 }
	 
	 @Test
	 public void testLastName () throws Exception{
	  
	  String result=null;
	  String msg=null;
	  
	  try{
	  
	   WebElement firstname = driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstName"));
	   firstname.sendKeys("Walter");
	   
	   //WebElement lastname = driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastName"));
	   //lastname.sendKeys("Vargas");
	  
	   WebElement email = driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Email"));
	   email.sendKeys("walter.vargas@avantica.net");
	   
	   WebElement username = driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserName"));
	   username.sendKeys("wvargas");
	   
	   WebElement password = driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password"));
	   password.sendKeys("123456");
	   
	   WebElement confpass = driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPassword"));
	   confpass.sendKeys("123456");
	   
	   WebElement question = driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Question"));
	   question.sendKeys("Where do you work?");
	   
	   WebElement answer = driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Answer"));
	   answer.sendKeys("Avantica");
	   
	   
	   WebElement subButton = driver.findElement(By.id("ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton"));
	   subButton.click();
	  
	   WebElement message = driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastNameRequired"));
	  
	  
	   String validateText = "";
	  
	   if(message.isDisplayed()==true){
	   
	   
	    if(message.getText().compareTo(validateText) > 0){
	     System.out.println("Failed: Text do not match");
	     result = TestLinkAPIResults.TEST_FAILED;  
	    }
	    
	    else{
	     System.out.println("Passed");
	     result = TestLinkAPIResults.TEST_PASSED;
	    }
	   }
	  else
	   System.out.println("Failed: There is no a error message!");
	 }
	  catch(Exception e){
	   result = TestLinkAPIResults.TEST_FAILED;
	   msg = e.getMessage();
	   e.printStackTrace();
	  }
	  
	  finally{
	  TestClass.reportTestCaseResult(PROJECTNAME, TESTPLANNAME,TESTCASENAME, BUILDNAME, msg, result);
	  } 
	 } 
	}
