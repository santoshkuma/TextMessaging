package com.msrcipts.textmessaging;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TextmessagingHelperClass extends BaseClass {
//	static AndroidDriver<AndroidElement> driver;
	
	Boolean Result;
		
	public void ReadMessage(String CodeSent, String ExpectedResponse) throws IOException, InterruptedException

	{  
		Thread.sleep(50000);
		List<AndroidElement> Listoftext = BaseClass.driver.findElements(By.id("com.truecaller.messenger:id/text_view_big"));
	    int messagecount = Listoftext.size();
		System.out.println("Total number of messages found " +messagecount);
		String ActualResposne = Listoftext.get(Listoftext.size()-1).getText();
		
		
		
		System.out.println("Actual Response for the code sent "+ '"' + CodeSent + '"' + " is \n\n"  +  ActualResposne + "\n\n");
		log.info("=====================================================Info==============================================");
		System.out.println("Expected response for the code sent "+ '"' + CodeSent + '"' + " is \n\n"  +  ExpectedResponse + "\n\n");
		log.info("=====================================================Info==============================================");
		
		Assert.assertEquals(ActualResposne, ExpectedResponse,"Response message to code " + '"'+ CodeSent + '"' +  "did not match \n\n");
		log.info("=====================================================Info==============================================");
		
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected
		String methodName = e.getMethodName();
//		if(ExpectedResponse==ActualResposne)
//		{
//			Result  = true;
//			log.info("*************************************TEST SUCCESS**********************************************");
//			System.out.println("User has received the expected response !! \n Hence Test" + methodName + "is PASSED");
//			log.info("*************************************TEST SUCCESS**********************************************");
//		}
//		else
//		{
//			Result = false;
//			log.info("*************************************TEST FAILED**********************************************");
//			System.out.println("The test has failed to validate the response received  !! \n Hence Test" + methodName + "is Failed");
//			log.info("*************************************TEST FAILED**********************************************");
//		}
//		Assert.assertTrue(Result);
	}

	public void OpenNewMessageWindow()throws IOException
	{
		BaseClass.driver.findElement(By.id("com.truecaller.messenger:id/fab_inbox")).click();
		BaseClass.driver.findElement(By.id("com.truecaller.messenger:id/fab_inbox")).click();
	}
	public void EnterCode(String CodeSent) throws IOException
	{
		BaseClass.driver.findElement(By.name("Type message")).sendKeys(CodeSent);
		
	}
	public void EnterShortCode()
	{
		BaseClass.driver.findElementByName("To").sendKeys("121");
	}
	
	public void ClickSendButton()throws IOException
	{
		BaseClass.driver.findElement(By.id("com.truecaller.messenger:id/send_button_sms")).click();

	}


}
