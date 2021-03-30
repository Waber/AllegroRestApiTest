package apiService;

import apiData.categories;
import io.restassured.RestAssured;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiConnection {
    private String allegroOAUTH = "https://allegro.pl/auth/oauth/device?response_type=code&client_id=d693faf0a35045b8b2535a295a4307fa";
    private String testUrl = "https://demoqa.com/utilities/weather/city";
    private String url = "https://allegro.pl";
    private String apiUrl = "https://api.allegro.pl";

    public  String getAccessToken(String clientId, String clientSecretId) {
        RestAssured.baseURI = url;
        return given().auth().preemptive().basic(clientId,clientSecretId)
                .formParam("grant_type", "client_credentials")
                .post("/auth/oauth/token")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("access_token");
    }

    public String getSomeData(String token){
        RestAssured.baseURI = apiUrl;
        return  given().header("Authorization","Bearer " + token)
                .header("accept","application/vnd.allegro.public.v1+json")
                .when()
                .get("/sale/categories")
                .then()
                .statusCode(200)
                .extract()
                .response().getBody().asString();
    }

    public List<categories> dataToList(String token) {
        RestAssured.baseURI = apiUrl;
        List<categories> lista =  given().header("Authorization","Bearer " + token)
                .header("accept","application/vnd.allegro.public.v1+json")
                .when()
                .get("/sale/categories")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList("categories",categories.class);//magia! :)
        return lista;
    }
}
