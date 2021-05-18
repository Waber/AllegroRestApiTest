package tests.putMethods;

import apiConfig.Endpoints;
import org.testng.annotations.Test;
import testBase.TestBase;

import static io.restassured.RestAssured.given;

public class putContactTests extends TestBase {
    private String contactId = "b93c2bed-e8a2-495c-b263-917b72f99524";

    @Test
    public void updateContactTest(){
        given().body(String.format(jsons.getCreateContactJson(),"Mecenas","parowa@xyz.pl","501051501"))
                .when()
                .put(Endpoints.CONTACTS+"/"+contactId)
                .then()
                .statusCode(200);
    }
}
