package com.qa.testcase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.util.RestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC4_Delete extends Base {
	String empname=RestUtil.empname();
	String empsal=RestUtil.empsal();
	String empage=RestUtil.empage();
int employeeId=10665;

@BeforeClass

void Delete() throws InterruptedException
{
	logger.info("&&&&&-------:  TC 003-Execution : &&&&------");
	String employeeId=TC2_Post.getId();
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/";
	httpreq=RestAssured.given();
	response=httpreq.request(Method.DELETE,"/employees");
	JsonPath jsonPathEvaluator =response.jsonPath();
	String empId= jsonPathEvaluator.get("id");
	response = httpreq.request(Method.DELETE,"/update/"+ employeeId);
	Thread.sleep(3000);
	
}
@Test(priority = 1)

public void checkResponseBody()
{
	logger.info("-- Verify Response Body -----------");
	String ResponseBody=response.getBody().asString();
	logger.info("POST Message:" + ResponseBody);
	Assert.assertEquals(ResponseBody.contains(empname), true);
	Assert.assertEquals(ResponseBody.contains(empsal), true);
	Assert.assertEquals(ResponseBody.contains(empage), true);
}
@Test
public static void getId() throws InterruptedException
{
	logger.info("----- Get Employee ID ----------");
	JsonPath jsonPathEvaluator = response.jsonPath();
	String employeeID=jsonPathEvaluator.get("id");
	String employeename=jsonPathEvaluator.get("empname");
	System.out.println("Employee ID Received from Response"+ employeeID);
	//String Employeename=jsonPathEvaluator.get("empname");
	//System.out.println("Employee Name Received from Response"+ Employeename);
	Thread.sleep(3000);
	//return(employeeID);
}
@Test(priority = 2)

void checkStatusCode()
{
	int statusCode=response.getStatusCode();
	logger.info("Status Code is :"+statusCode);
	Assert.assertEquals(statusCode, 200);
}
@Test
void checkResponseTime()
{
	logger.info("&&&&& Verifying ResponseTime &&&&");
long responseTime= response.getTime();
logger.info("Response Time is :" + responseTime);

if(responseTime>200)
	logger.warn("Response Time is Greater Then 2000");
    Assert.assertTrue(responseTime<10000);
}

@Test
void checkstatusLine()
{
	logger.info("------Verifying Status Line----------");
	String statusLine =response.getStatusLine();
	logger.info("Status Line is:" +statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
}

@Test()
void checkContentType()
{
	logger.info("&&&&& :Verifying Content Type :&&&&&");
	String contentType=response.header("Content-Type");
	logger.info("Content type is :"+ contentType);
	Assert.assertEquals(contentType, "text/html; charset=UTF-8");
}

@Test
void checkserverType()
{
	logger.info("&&&&& :Verifying Server: :&&&&&");
	String serverType=response.header("Server");
	logger.info("Server Type is:" + serverType);
	Assert.assertEquals(serverType, "nginx/1.14.1");
}

@Test
void checkcontentEncoding()
{
	logger.info("&&&&& :Verifying Content-Encoding: :&&&&&");
	String contentEncoding = response.header("Content-Encoding");
	logger.info("ContentEncoding is :" +contentEncoding);
	Assert.assertEquals(contentEncoding,"gzip");
}

@Test(priority = 9)
void tearDown()
{
	logger.info("-----  : TESTCASE 02 Execution Completed: ----------");	
}
}
