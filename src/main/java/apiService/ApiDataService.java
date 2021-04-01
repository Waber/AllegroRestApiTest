package apiService;

import apiData.Categories;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiDataService {
    private static String apiUrl = "https://api.allegro.pl";

    public List<Categories> getListOfCategories(String token) {
        RestAssured.baseURI = apiUrl;
        List<Categories> lista =  given().header("Authorization","Bearer " + token)
                .header("accept","application/vnd.allegro.public.v1+json")
                .when()
                .get("/sale/categories")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList("categories", Categories.class);
        return lista;
    }

    public Categories getCategoryById(String token, String categoryId){
        RestAssured.baseURI = apiUrl;
        Response op = given().header("Authorization","Bearer " + token)
                .header("accept","application/vnd.allegro.public.v1+json")
                .when()
                .get("/sale/categories/"+ categoryId);
        if (op.getStatusCode() == 200){
            return op.body().as(Categories.class);
        }
        else {
            return null;
        }
    }

    public String getParametersById(String token, String id){
        RestAssured.baseURI = apiUrl;
        Response op = given().header("Authorization","Bearer " + token)
                .header("accept","application/vnd.allegro.public.v1+json")
                .when()
                .get("/sale/categories/"+ id + "/parameters");
        if (op.getStatusCode() == 200){
            return op.getBody().asString();
        }
        else {
            return null;
        }
    }
}
