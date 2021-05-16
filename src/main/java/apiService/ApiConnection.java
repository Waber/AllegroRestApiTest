package apiService;

import apiConfig.Endpoints;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class ApiConnection {


    public  String getAccessToken(String clientId, String clientSecretId) {
        RestAssured.baseURI = Endpoints.ALLEGRO_BASE;
        return given().auth().preemptive().basic(clientId,clientSecretId).log().all()
                .formParam("grant_type", "client_credentials")
                .post("/auth/oauth/token")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("access_token");
    }


}
