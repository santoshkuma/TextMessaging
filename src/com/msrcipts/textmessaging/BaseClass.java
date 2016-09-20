/**
 * 
 */
/**
 * @author skumar
 *
 */
package com.msrcipts.textmessaging;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

@Test
public class BaseClass {

static AndroidDriver<AndroidElement> driver;
Logger log = Logger.getLogger("devpinoyLogger");
	

//AppiumDriver driver;
	@BeforeMethod
	@BeforeClass
	public void setUp() throws MalformedURLException{
		
			
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.1.1");
		capabilities.setCapability("platformName", "Android");
	    capabilities.setCapability("deviceName", "TA64301YD");
	    capabilities.setCapability("appPackage", "com.truecaller.messenger");
	   		  
		  /*
		   * This package name of your app (you can get it from apk info app)
		   */
		  capabilities.setCapability("appActivity","com.truecaller.messenger.MainActivity");
		  
		  
		  /*
		   * This is Launcher activity of your app (you can get it from apk info
		   * app) Create RemoteWebDriver instance and connect to the Appium server
		   */

		  driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}


@AfterClass
public void teardown()
{
   
    //close the app
  driver.closeApp();
}
}

