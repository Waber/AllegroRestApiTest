package apiService;

import apiConfig.Endpoints;
import apiData.Categories;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
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

    public Categories  getCategoryById(String categoryId){
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
                .get(Endpoints.CATEGORIES+"/"+ id + Endpoints.PARAMETERS);
        if (op.getStatusCode() == 200){
            return op.getBody().asString();
        }
        else {
            return null;
        }
    }


    public String getHeaderValue(String endpoint, String headerName){
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response()
                .getHeader(headerName);
    }

    /**
     * Method for extracting data from response if you are too lazy to create new data Class or if it is really huge ;)
     * @param endpoint
     * @param path starting from root, enter child node with .
     */
    public List<String> getResponseDataAsList(String endpoint, String path){
        return  given()
                .when()
                .get(endpoint)
                .then()
                .extract().response()
                .path(path);

    }
}
