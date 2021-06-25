package tests;

import apiConfig.Endpoints;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.InputStream;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class schemaValidation extends TestBase {

    @Test
    public void testCategorysSchema(){
        given()
                .when()
                .get(Endpoints.CATEGORIES+"/"+ "42540aec-367a-4e5e-b411-17c09b08e41f")
                .then()
                .body(matchesJsonSchemaInClasspath("categoriesSchema.json"));
        //Test will not pass because parent field returns null value
    }
}
