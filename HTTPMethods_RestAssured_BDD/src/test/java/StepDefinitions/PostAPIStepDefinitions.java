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

public class PostAPIStepDefinitions {
	public static RequestSpecification requestspecification;
	public static Response response;
	public static String respbody;
	String name;
	@Given("Launch the base URL for POST")
	public void Launch_the_baseURL_for_POST()
	{
		baseURI="https://reqres.in/api";
		requestspecification= RestAssured.given();
	}
   	@When("Add the headers for Post method")
   	public void Add_the_headers_for_Post_method()
   	{
   		requestspecification.header("Content-Type","application/json");
   	}
    @And("create the body")
    public void create_the_body()
    {
    	JSONObject inputbody=new JSONObject();
		inputbody.put("name", "Sasi");
		inputbody.put("job","QAEngineer");
		requestspecification.body(inputbody.toJSONString());
    }
    @And("Add POST method and the end point")
    public void Add_POST_method_and_the_end_point()
    {
		response=requestspecification.request(Method.POST,"/users");
		System.out.println("This is POST method");
		System.out.println("postReqres1");
		System.out.println("postReqres2");
		System.out.println("postReqres3");

    }
 
    @And("generate the response body for post")
    public void generate_the_response_body_for_post()
    {
    	respbody=response.getBody().asPrettyString();
		System.out.println(respbody);
		
    }
    @Then("Validate the POST response")
    public void Validate_the_POST_response()
    {
    	int statuscode=response.getStatusCode();
    	try {
    	Assert.assertEquals(statuscode,201,"The Status code for POST API is 201");
    	System.out.println("The Assertion for StatusCode is Passed.");
    	JsonPath js= response.jsonPath();
    	name=js.get("name");
    	
    	try {
    	Assert.assertEquals(name,"Sasi","The correct name should be received in the response ");
    	System.out.println("The name validation is passed");
    	}
    	catch(AssertionError e)
    	{
        	System.out.println("The Assertion for name is Failed."+e.getMessage());

    	}
    	}
    	catch(AssertionError e)
    	{
        	System.out.println("The Assertion for StatusCode is Failed."+e.getMessage());

    	}
    }

}
