package tests;

import apiConfig.Endpoints;
import apiService.ApiConfig;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testBase.TestBase;

import static io.restassured.RestAssured.given;

public class PostTests {

    @BeforeClass
    public void setup(){
        ApiConfig.setUp();
    }

    @Test
    public void createNewContact(){
        String createContactJson = "{\n" +
                "  \"name\": \"xyz\",\n" +
                "  \"emails\": [\n" +
                "    {\n" +
                "      \"address\": \"strikosng@pp.pl\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"phones\": [\n" +
                "    {\n" +
                "      \"number\": \"456789123\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        given().log().all()
                .body(createContactJson)
                .when()
                .post(Endpoints.CONTACTS)
                .then().log().all()
                .statusCode(201);
    }

    @Test
    public void getTest(){
        given().log().all()
                .when()
                .get(Endpoints.TAG)
                .then().log().all()
                .statusCode(200);
    }
}
