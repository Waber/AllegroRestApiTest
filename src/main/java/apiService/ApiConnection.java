package apiService;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class ApiConnection {
    private static String url = "https://allegro.pl";


    public  String getAccessToken(String clientId, String clientSecretId) {
        RestAssured.baseURI = url;
        return given().auth().preemptive().basic(clientId,clientSecretId).log().all()
                .formParam("grant_type", "client_credentials")
                //.header("scope","allegro:api:profile:write","%20allegro:api:profile:read")
                .post("/auth/oauth/token")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("access_token");
    }


}
