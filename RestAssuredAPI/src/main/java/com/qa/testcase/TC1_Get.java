package com.qa.testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import junit.framework.Assert;
public class TC1_Get extends Base {


@BeforeClass
void getAllEmployees()
{
logger.info("-------Execution TC001_GET------");
RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
httpreq=RestAssured.given();
response=httpreq.request(Method.GET,"/employees");
logger.info("All Employee Details :" + response);
}

@Test

void checkResponseBody()
{
	logger.info("&&&&& Verifying Response Body &&&& ");
	String responseBody = response.getBody().asString();
	logger.info("ResponseBody is :" +responseBody);
	Assert.assertTrue(responseBody!=null);
}

@Test
void checkStatusCode()
{
	logger.info("&&&&& Verifying Status Code *****");
	int statuscode=response.getStatusCode();
	logger.info(""+statuscode);
	Assert.assertEquals(statuscode, 200);
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
	logger.info("-----  : TESTCASE 01 Execution Completed: ----------");	
}

}
