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

public class PutAPIStepDefinitions {
	public static RequestSpecification requestspecification;
	public static Response response;
	public static String respbody;
	String job;
	@Given("Launch the base URL for PUT")
	public void Launch_the_baseURL_for_PUT()
	{
		baseURI="https://reqres.in/api";
		requestspecification= RestAssured.given();
	}
   	@When("Add the headers for Put method")
   	public void Add_the_headers_for_Put_method()
   	{
   		requestspecification.header("Content-Type","application/json");
   	}
    @And("Update the body")
    public void Update_the_body()
    {
    	JSONObject inputbody=new JSONObject();
		inputbody.put("name", "Sathi");
		inputbody.put("job","BackendDeveloper");
		requestspecification.body(inputbody.toJSONString());
    }
    @And("Add PUT method and the end point")
    public void Add_POST_method_and_the_end_point()
    {
		response=requestspecification.request(Method.PUT,"/user/2");
		System.out.println("This is PUT method");

		System.out.println("postReqres1");
		System.out.println("postReqres2");
		System.out.println("postReqres");

		System.out.println("putReqres1");
		System.out.println("putReqres2");
		System.out.println("putReqres3");



    }
 
    @And("generate the response body for put")
    public void generate_the_response_body_for_put()
    {
    	respbody=response.getBody().asPrettyString();
		System.out.println(respbody);
		
    }
    @Then("Validate the PUT response")
    public void Validate_the_PUT_response()
    {
    	int statuscode=response.getStatusCode();
    	try {
    	Assert.assertEquals(statuscode,200,"The Status code for PUT API is 200");
    	System.out.println("The Assertion for StatusCode is Passed.");
    	JsonPath js= response.jsonPath();
    	job=js.get("job");
    	
    	try {
    	Assert.assertEquals(job,"BackendDeveloper","The correct job should be received in the response ");
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
