package Kranti;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


public class Rest_Get_Reference {

	public static void main(String[] args) {
    // declare base URI
		RestAssured.baseURI="https://reqres.in/";
		
   // declare requestbody
   //Declare given, when then method 
		String ResponseBody= given().header("Content-type","application/json").body("requestBody").
				when().get("api/users?page=2").then().extract().response().asString();
System.out.println(ResponseBody);

	}

}
