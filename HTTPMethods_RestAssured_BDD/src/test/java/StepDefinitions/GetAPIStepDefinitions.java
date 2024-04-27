package StepDefinitions;

import static io.restassured.RestAssured.baseURI;

import java.io.File;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAPIStepDefinitions {

	
	public static RequestSpecification requestspecification;
	public static Response response;
	public static String respbody;
    @Given("Launch the base url for Get")
    public void Launch_the_baseurl_for_Get()
    {
    	baseURI="https://reqres.in/api";
		requestspecification= RestAssured.given();
    }
 
    @And("Add GET method and the end point")
    public void Add_GET_method_and_the_end_point()
    {
		response=requestspecification.request(Method.GET,"/users?page=2");

    }
    @And("generate the response body for Get")
    public void generate_the_response_body_for_Get()
    {
    	respbody=response.getBody().asPrettyString();
		System.out.println(respbody);

    }
    @Then("Validate the GET response")
    public void Validate_the_GET_response()
    {
    	int statuscode=response.getStatusCode();
    	try {
    	Assert.assertEquals(statuscode,200,"The Status code for GET API is 200");
    	System.out.println("The Assertion for StatusCode is Passed.");
    	JsonPath js= response.jsonPath();
    	String firstname=js.get("data[2].first_name");
    	try {
    	Assert.assertEquals(firstname, "Tobias","The correct first_name should be received in the response ");
    	System.out.println("The firstname validation is passed");
    	}
    	catch(AssertionError e)
    	{
        	System.out.println("The Assertion for firstname is Failed."+e.getMessage());

    	}
    	}
    	catch(AssertionError e)
    	{
        	System.out.println("The Assertion for StatusCode is Failed."+e.getMessage());

    	}
    	
    	
    }
}
