package tests;

import apiConfig.Endpoints;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.util.Map;

import static io.restassured.RestAssured.get;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class GPathJsonTests extends TestBase {

    private Response response;

    @Test
    public void extractMapOfElementsWithFind(){
        response = get(Endpoints.CATEGORIES);

        Map<String,?> allSingleCategoryData = response.path("categories.find {it.name == 'Moda'}");
        System.out.println("Data of fashion category: " + allSingleCategoryData);
    }

    @Test
    public void extractSingleValue(){
        response = get(Endpoints.CATEGORIES);
        String categoryId = response.path("categories.find {it.name == 'Kultura i rozrywka'}.id");
        assertThat(categoryId.equals("38d588fd-7e9c-4c42-a4ae-6831775eca45"));
    }

    @Test
    public void extractSingleValueFromSubNode(){
        response = get(Endpoints.CATEGORIES);
        boolean categoryId = response.path("categories.find {it.name == 'Kultura i rozrywka'}.options.advertisement");
        assertThat(categoryId).isFalse();
    }
}
