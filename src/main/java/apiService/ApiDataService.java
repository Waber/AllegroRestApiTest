package apiService;

import apiConfig.Endpoints;
import apiData.Categories;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;


public class ApiDataService {


    public List<Categories> getListOfCategories() {
        List<Categories> lista =  given()
                .when()
                .get(Endpoints.CATEGORIES)
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList("categories", Categories.class);
        return lista;
    }

    public Categories getCategoryById(String categoryId){
        Response op = given()
                .when()
                .get(Endpoints.CATEGORIES+"/"+ categoryId);
        if (op.getStatusCode() == 200){
            return op.body().as(Categories.class);
        }
        else {
            return null;
        }
    }

    public String getParametersById(String id){
        Response op = given()
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
