package com.qa.testcase;

import org.testng.annotations.Test;

import com.qa.base.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Authentication {
	
	public class premitive
	{
		@Test
		public void preauth()
		{
			RestAssured.baseURI="http://restapi.demoqa.com";
			RequestSpecification httprequest = RestAssured.given();
			httprequest.auth().preemptive().basic("ToolsQA","TestPassword");
			Response resp=httprequest.request(Method.GET,"/authentication/CheckForAuthentication");
			int status_code =resp.getStatusCode();
			System.out.println("The satus code is : "+status_code);
			Assert.assertEquals(status_code, 200);
			
		}
	}

}
