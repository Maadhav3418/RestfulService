package getRequest;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.hamcrest.Matcher;
public class GetCallDBB {
	
	@Test
	 public void number()
	 {
		//given()
		//when()
		//then()
		//assert()
		given().
		when().
		
		get("http://ergast.com/api/f1/2017/circuit.json").
		then().
		    assertThat().
		    statusCode(200).
		    and().
		    body("MRData.CircuitTable.Circuits.circuitID",hasSize(20)).
		    and().
		    header("content-length",equalsTo("4551"));
		    
		  
		
	 }

	private Matcher<?> equalsTo(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private ResponseAwareMatcher<Response> hasSize(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
