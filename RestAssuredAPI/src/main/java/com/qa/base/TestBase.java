package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public Properties prop;
	
	public TestBase() throws Exception
	{
		try
		{
			prop = new Properties();
			
					FileInputStream fip= new FileInputStream(System.getProperties()+ "C:\\Users\\madhavaraon\\APITest\\apiTest\\src\\main\\java\\com\\qa\\configuration\\config.properties");
					prop.load(fip);
					
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	
	}
	
}
