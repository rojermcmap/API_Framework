package step_definitions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;


public class StepDefinition extends Utils {

	Response response;
	RequestSpecification res;
	ResponseSpecification resspec;
	static String DynPlaceID;

	TestDataBuild Build = new TestDataBuild();

	
	@Given("^Add Plcae Payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void add_plcae_payload_with_something_something_something(String address, String language, String phone) throws Throwable {


		res= given().spec(RequestBuilder())
				.body(Build.AddPlacePayload(address,language,phone));

	}

	@When("^user calls \"([^\"]*)\" with \"([^\"]*)\" HTTP request$")
	public void user_calls_something_with_something_http_request(String strArg1, String strArg2) throws Throwable {

		APIResources ResoucesAPI = APIResources.valueOf(strArg1);
		ResoucesAPI.Resources();
		System.out.println("Picked ResoucesAPI:"+ResoucesAPI.Resources());

		ResponseSpecification resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if (strArg2.equalsIgnoreCase("post")){
			response =res.when().post(ResoucesAPI.Resources());
		}
		else if (strArg2.equalsIgnoreCase("get")){
			response =res.when().get(ResoucesAPI.Resources());
		}
		
		response.then().spec(resspec).extract().response();

	}

	@Then("^the API call got success with status code 200$")
	public void the_api_call_got_success_with_status_code_200() throws Throwable {
		assertEquals(response.getStatusCode(),200);
		System.out.println(response.getStatusCode());


	}

	@And("^\"([^\"]*)\" in response is \"([^\"]*)\"$")
	public void something_in_response_is_something(String strArg1, String strArg2) throws Throwable {
		String FinalResponse = response.asString();


		JsonPath JString  = new JsonPath(FinalResponse);


		assertEquals(JString.get(strArg1).toString(),strArg2); 
		assertEquals(getjsonvalue(response,strArg1),strArg2); 

	}
    @And("^veriy whether the place \"([^\"]*)\" is created using \"([^\"]*)\"$")
    public void veriy_whether_the_place_something_is_created_using_something(String address, String strArg1) throws Throwable {
    	
    	DynPlaceID = getjsonvalue(response,"place_id");
    	res= given().spec(RequestBuilder()).queryParam("place_id", DynPlaceID);
    	
    	user_calls_something_with_something_http_request(strArg1, "GET");
    	
    	String addressval = getjsonvalue(response,"address");
    	System.out.println("Value:"+ addressval+";"+address);
    	assertEquals(addressval,address); 
    	
    }

    @Given("^Delete place payload$")
    public void delete_place_payload() throws Throwable {
    	res= given().spec(RequestBuilder())
				.body(Build.DeletePlacePayload(DynPlaceID));
    	
    }

}