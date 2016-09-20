package com.msrcipts.textmessaging;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidElement;

public class TestCaseMessaging extends BaseClass {

	TextmessagingHelperClass helper =new TextmessagingHelperClass();
	
	@Test(priority=1)
public void VerifyHelpCode() throws InterruptedException, IOException

	{   
		PropertyConfigurator.configure("Log4j.properties");
		log.info("=====================================================Info==============================================");
		log.info("Verifying HelpCode");
		String CodeSent = "Help";
        String ExpectedResponse = "Manage your account by sending the following keywords to 121 - \n"
+ " 1 OT: Due Amount \n"
+ " 2 UNB: Current Usage \n"
+ " 3 PAY: Payments \n"
+ " 4 BILL: Bill Summary \n"
+ " 5 BP: Current Bill Plan \n"
+ " 6 DATA USE: Data Usage \n"
+ " 7 CHECK 4G: Check 4G Compatibility \n"
+ " 8 GREENBILL <email id>: Start Ebill Facility \n"
+ " 9 EBILL <email id> <month>: One Time Ebill \n"
+ " 10 STOP EBILL: Stop Ebill Facility \n"
+ " 11 SR <SR no.>: Reference No. Status \n";
		        
        log.info("Expected Response has been captured for Verifying help code \n");
        helper.OpenNewMessageWindow();
        helper.EnterShortCode();
        helper.EnterCode(CodeSent);
        helper.ClickSendButton();
        helper.ReadMessage( CodeSent ,ExpectedResponse);
}
	@Test(priority=2)
public void VerifyPayments() throws IOException, InterruptedException
	{
		PropertyConfigurator.configure("Log4j.properties");
		log.info("=====================================================Info==============================================");
		log.info("Verifying Due Amount");
		String CodeSent = "PAY";
		
		
		String ExpectedResponse = "Last three payments for your airtel mobile:  \n"
+"1) 10-Jun-16, Rs. 1962.07\n" 
+"2) 30-Apr-16, Rs. 1717.21\n"
+"3) 09-Apr-16, Rs. 1255.54\n";
		
		log.info("Expected Response has been captured for Verifying Due Amount \n");
		
		//helper.OpenNewMessageWindow();
		helper.EnterCode(CodeSent);
		helper.ClickSendButton();
		helper.ReadMessage(CodeSent, ExpectedResponse);
	
 	}
	@Test(priority=3)
public void VerifyCurrentDatausage() throws IOException, InterruptedException
{
		PropertyConfigurator.configure("Log4j.properties");
		log.info("=====================================================Info============================================== \n");
		log.info("Verifying Data Usage \n");
		
		
	String CodeSent = "UNB";
	String ExpectedResponse = "current usage amount on your airtel mobile  till 06-Aug-16 is Rs.159.00 (excludes monthly rentals).";
	
	
	//helper.OpenNewMessageWindow();
	log.info("Expected Response has been captured for Verifying Current Data Usage \n");
	helper.EnterCode(CodeSent);
	helper.ClickSendButton();
	helper.ReadMessage(CodeSent, ExpectedResponse);
}
}