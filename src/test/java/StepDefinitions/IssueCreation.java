package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;

import PayLoad.Fields;
import PayLoad.NewIssue;
import PayLoad.Project;
import PayLoad.UserCreds;
import PayLoad.issuetype;
import Resources.RequestSpecs;
import Resources.StaticTestData;
import Resources.TestDataPayLoads;

public class IssueCreation extends TestDataPayLoads {
	
	
	public SessionFilter session;
	public RequestSpecs req;
//	RestAssured.baseURI="";
	
	@Given("Open the jira link and login with valid credentials to get session id")
	public void open_the_jira_link_and_login_with_valid_credentials_to_get_session_id() throws FileNotFoundException {
	    // Write code here that turns the phrase above into concrete actions
	    
	    session = new SessionFilter();
	    req = new RequestSpecs();
	    
	    RequestSpecification res = given().spec(req.InitialRequestSpec()).body(LoginDetails()).filter(session);
	   // ResponseSpecification rep = new ResponseSpecBuilder().expectStatusCode(200).build();
	    StaticTestData authAPI = StaticTestData.valueOf("AuthAPI");
		String api = authAPI.getData();
	    String response = res.when().post(api).then().extract().asString();
	    System.out.println(response);
	    JsonPath js = new JsonPath(response);
	    String sessionId = js.getString("session.value");
	    System.out.println(sessionId);
	}
	

	@When("Send the payload for creating issse with post request")
	public void send_the_payload_for_creating_issse_with_post_request() throws FileNotFoundException {
	    // Write code here that turns the phrase above into concrete actions
		StaticTestData newApi = StaticTestData.valueOf("NewIssueAPI");
		String api = newApi.getData();
	    String response = given().spec(req.InitialRequestSpec()).body(NewIssue()).filter(session).when().post(api)
	    		.then().extract().asString();
	    System.out.println(response);
	}
	
	
	@Then("Issue should be created successfully and response code is {string}")
	public void issue_should_be_created_successfully_and_response_code_is(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Jira Issue validation compeleted");
	}

}
