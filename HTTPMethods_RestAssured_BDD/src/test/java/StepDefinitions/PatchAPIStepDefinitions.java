package StepDefinitions;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
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

public class PatchAPIStepDefinitions {
	public static RequestSpecification requestspecification;
	public static Response response;
	public static String respbody;
	String job;
	@Given("Launch the base URL for PATCH")
	public void launch_the_base_url_for_patch() {
		baseURI="https://reqres.in/api";
		requestspecification= RestAssured.given();
	}
	@When("Add the headers and body for PATCH method")
	public void add_the_headers_and_body_for_for_patch_method() {
   		requestspecification.header("Content-Type","application/json");
   		JSONObject inputbody=new JSONObject();
		inputbody.put("name", "Sathi");
		inputbody.put("job","QA");
		requestspecification.body(inputbody.toJSONString());

	}
	@And("Add PATCH method and the end point")
	public void add_patch_method_and_the_end_point() {
		response=requestspecification.request(Method.PATCH,"/user/2");
		System.out.println("PatchReqres1");
		System.out.println("This is patch metod");



	}
	@And("generate the response body for PATCH")
	public void generate_the_response_body_for_patch() {
		respbody=response.getBody().asPrettyString();
		System.out.println(respbody);
	}
	@Then("Validate the PATCH response")
	public void validate_the_patch_response() {
		int statuscode=response.getStatusCode();
    	try {
    	Assert.assertEquals(statuscode,200,"The Status code for PUT API is 200");
    	System.out.println("The Assertion for StatusCode is Passed.");
    	JsonPath js= response.jsonPath();
    	job=js.get("job");
    	
    	try {
    	Assert.assertEquals(job,"QA","The correct job should be received in the response ");
    	System.out.println("The job validation is passed");
    	}
    	catch(AssertionError e)
    	{
        	System.out.println("The Assertion for job is Failed."+e.getMessage());

    	}
    	}
    	catch(AssertionError e)
    	{
        	System.out.println("The Assertion for StatusCode is Failed."+e.getMessage());

    	}
    
	}


}
