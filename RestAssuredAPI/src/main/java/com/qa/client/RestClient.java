package com.qa.client;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
@Test
public class RestClient {

	public void HelloWorldTest() {
	      
	      System.out.println("Helloworld");
	      assertEquals("Hello", "Hello");
	  }
	
	@BeforeClass
	  public void beforeClass() {
	      System.out.println("Before Class method - setup stuff here");
	  }


	public static void main(String[] args) 
			{
		RestClient rc = new RestClient ();
		rc.HelloWorldTest();
		rc.beforeClass();
			}
}

