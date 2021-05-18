package tests.postMethods;

import apiConfig.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.TestBase;

import static io.restassured.RestAssured.given;

public class PostContactTests extends TestBase {

    @BeforeClass
    public void setup(){

    }

    @Test
    public void createNewContact(){

        given()
                .body(String.format(jsons.getCreateContactJson(),"Ziom","palib@pp.pl","456789123"))
                .when()
                .post(Endpoints.CONTACTS)
                .then()
                .statusCode(201);
    }


    @Test(description = "Formally it's not a test, just to check if contact is added if you need to")
    public void getTest(){
        given()
                .when()
                .get(Endpoints.CONTACTS)
                .then()
                .statusCode(200);
    }
}
