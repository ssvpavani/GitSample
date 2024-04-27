package StepDefinitions;

import static io.restassured.RestAssured.baseURI;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteAPIStepDefinitions {
	public static RequestSpecification requestspecification;
	public static Response response;
	public static String respbody;
	@Given("Launch the base URL for Delete")
	public void launch_the_base_url_for_delete() {
		baseURI="https://reqres.in/api";
		requestspecification= RestAssured.given();
	}
	@When("Add the headers for Delete method")
	public void add_the_headers_for_delete_method() {
   		requestspecification.header("Content-Type","application/json");

	}
	@When("Add Delete method and the end point")
	public void add_delete_method_and_the_end_point() {
		response=requestspecification.request(Method.DELETE,"/user/2");

	}
	@When("generate the response body for Delete")
	public void generate_the_response_body_for_delete() {
		respbody=response.getBody().asPrettyString();
		System.out.println(respbody);
	}
	@Then("Validate the Delete response")
	public void validate_the_delete_response() {
		int statuscode=response.getStatusCode();
    	try {
    	Assert.assertEquals(statuscode,204,"The Status code for PUT API is 204");
    	System.out.println("The Assertion for StatusCode is Passed.");
    	try {
    		String statusline=response.getStatusLine();
    		Assert.assertEquals(statusline, "HTTP/1.1 204 No Content","The Status code for Delete API is 204");
        	System.out.println("The Assertion for Statuline is Passed.");
        	}
        	catch(AssertionError e)
        	{
            	System.out.println("The Assertion for StatusCode is Failed."+e.getMessage());

        	}
    	}
    	
    	catch(AssertionError e)
    	{
        	System.out.println("The Assertion for StatusCode is Failed."+e.getMessage());

    	}
    
	}


}
