package org.daedusp.tests;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ApiExampleTest {

    @Test
    public void createAndRetrievePost() {
        // Base URL for the JSONPlaceholder API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Create a new post
        Response postResponse = given()
                .contentType(ContentType.JSON)
                .body("{\"title\":\"Java Test Post\",\"body\":\"This is a test post created by Java\",\"userId\":1}")
                .when()
                .post("/posts");

        // Assertion for the status code of the POST request
        assertEquals(postResponse.getStatusCode(), 201);

        // Retrieve the post using the response from the created post
        int postId = postResponse.then().extract().path("id");
        Response getResponse = given()
                .when()
                .get("/posts/" + "1");

        // Assertions for the status code and content of the GET request
        assertEquals(getResponse.getStatusCode(), 200);
        assertEquals(getResponse.then().extract().path("title"), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        assertEquals(getResponse.then().extract().path("body"), "quia et suscipit\n" +
                "suscipit recusandae consequuntur expedita et cum\n" +
                "reprehenderit molestiae ut ut quas totam\n" +
                "nostrum rerum est autem sunt rem eveniet architecto");
        // Add more assertions based on the structure of the GET response
    }
}
