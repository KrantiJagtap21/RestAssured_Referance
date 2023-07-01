package Kranti;

import io.restassured.RestAssured;
import io.restassured.path.xml.*;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
public class Soap_Api_Reference {

	public static void main(String[] args) {
		//declare the base URL
		RestAssured.baseURI="https://www.dataaccess.com/";
		//Declare Request Body
		String RequestBody="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ "      <ubiNum>8</ubiNum>\r\n"
				+ "    </NumberToWords>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
		//Extract Response Body
		String ResponseBody=given().header("Content-Type","text/xml; charset=utf-8").body(RequestBody).
				when().post("webservicesserver/NumberConversion.wso").then().extract().asString();
		System.out.println(ResponseBody);
		// Parse the responseBody
		XmlPath XmlResponse=new XmlPath(ResponseBody);
		String ResponseParameter = XmlResponse.getString("NumberToWordsResult");
		System.out.println(ResponseParameter);
		//Validate responseBody
		Assert.assertEquals(ResponseParameter, "eight ");
		
	}

}
