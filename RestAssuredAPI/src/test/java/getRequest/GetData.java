package getRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.mapper.resolver.*;
import io.restassured.response.Response;




public class GetData {

@Test
	public void testResponseCode ()
	{
		Response res = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	
		int code = res.getStatusCode();
		System.out.println("Staus Code :" + code);
		Assert.assertEquals(code, 200);
	}
@Test

public void testBody()
{
	Response res = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	
	String  data = res.asString();
			
			
	System.out.println("Data is  :" + data);
	System.out.println("Responsetime :" + res.getTime());
}

}
