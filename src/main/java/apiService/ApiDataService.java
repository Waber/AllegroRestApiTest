package apiService;

import apiConfig.Endpoints;
import apiData.Categories;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;


public class ApiDataService {


    public List<Categories> getListOfCategories(String token) {
        RestAssured.baseURI = Endpoints.APIURL;
        List<Categories> lista =  given()
                .header("Authorization","Bearer " + token)
                .header("accept","application/vnd.allegro.public.v1+json")
                .when()
                .get(Endpoints.CATEGORIES)
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList("categories", Categories.class);
        return lista;
    }

    public Categories getCategoryById(String token, String categoryId){
        RestAssured.baseURI = Endpoints.APIURL;
        Response op = given().header("Authorization","Bearer " + token)
                .header("accept","application/vnd.allegro.public.v1+json")
                .when()
                .get(Endpoints.CATEGORIES+"/"+ categoryId);
        if (op.getStatusCode() == 200){
            return op.body().as(Categories.class);
        }
        else {
            return null;
        }
    }

    public String getParametersById(String token, String id){
        RestAssured.baseURI = Endpoints.APIURL;
        Response op = given().header("Authorization","Bearer " + token)
                .header("accept","application/vnd.allegro.public.v1+json")
                .when()
                .get(Endpoints.CATEGORIES+"/"+ id + "/parameters");
        if (op.getStatusCode() == 200){
            return op.getBody().asString();
        }
        else {
            return null;
        }
    }
}
