package com.TestLinkDemo;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;


public class TestClass implements IConstants {

public static void reportTestCaseResult(String projectName,String testplanName,

String testcaseName, String buildName,String msg,String result) 

throws TestLinkAPIException {

     TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEVKEY,URL);

     testlinkAPIClient.reportTestCaseResult(projectName, testplanName,

         testcaseName, buildName, msg, result);
    

      }

}