package getRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.mapper.resolver.*;
import io.restassured.response.Response;


public class GetDataOne {

@Test
	public void testResponseCode ()
	{
		int code = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").getStatusCode();
		
		System.out.println("Staus Code :" + code);
		Assert.assertEquals(code, 200);
	}
@Test

public void testBody()
{
	String data = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").asString();
	long time = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").getTime();
	System.out.println("Data is  :" + data);
	System.out.println("Responsetime :" + time);
}

public static void main(String[] args) throws Exception
{
GetDataOne  lp =new GetDataOne();
lp.testResponseCode();
lp.testBody();
//lp.initialization();
//lp.loginToApplication();
//driver.quit();		
}
}
