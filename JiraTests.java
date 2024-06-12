package JIRA_API_Automation;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class JiraTests extends Token {
    String projectKey = "KAN";
    String issueKey = "";

    @BeforeClass
    public void setUp() {
        // Base URL of your Jira instance
        RestAssured.baseURI = Token.getDomainUrl() + "rest/api/3";

        // Set up authentication
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(Token.getUserName());
        authScheme.setPassword(Token.getToken());
        RestAssured.authentication = authScheme;
    }

    @Test
    public void getIssueDetails() {
        given()
                .when()
                .get("issue/KAN-12")
                .then()
                .statusCode(200).log().all();
    }

    @Test
    public void createIssueTest() {
        Response response = given()
                .header("Content-Type", "application/json")
                .body(JsonBody.requestBody)
                .when()
                .post("issue")
                .then()
                .statusCode(201).extract().response();

        String responseBody = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        issueKey = jsonPath.get("key");

    }

    @Test(dependsOnMethods = {"createIssueTest"})
    public void updateIssueTest() {

        given()
                .header("Content-Type", "application/json")
                .body(JsonBody.updateRequestBody)
                .when()
                .put("issue/" + issueKey)
                .then()
                .statusCode(204).log().all();
    }


    @Test(dependsOnMethods = {"createIssueTest"})
    public void searchIssueTest() {

        given()
                .param("jql", "project = " + projectKey + " AND key =" + issueKey)
                .when()
                .get("search")
                .then()
                .statusCode(200).log().all();
    }

    @Test(dependsOnMethods = {"createIssueTest"})
    public void deleteIssueTest() {

        given()
                .when()
                .delete("issue/" + issueKey)
                .then()
                .statusCode(204).log().all();
    }

    @Test
    public void attachFileToIssue() {

        String issueKey = "KAN-12";

        File fileToAttach = new File(System.getProperty("user.dir") + "\\src\\main\\java\\JIRA_API_Automation\\test_image.png");

        given()
                .header("X-Atlassian-Token", "nocheck")
                .multiPart(fileToAttach)
                .when()
                .post("issue/" + issueKey + "/attachments")
                .then()
                .statusCode(200).log().all();
    }


}
