package apiService;

import apiConfig.Endpoints;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public abstract class ApiConfig {

    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;
    private static ApiConnection apiConnection = new ApiConnection();
    private static String clientId = "d693faf0a35045b8b2535a295a4307fa";
    private static String clientSecretId = "82YM1jaNebM6K4vX2kaYTxjlpw5Q2xaI7mD8px1zH75X7RpdOqDmWgm6CPOAxUbE";

    public static void setUp(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(Endpoints.APIURL)
                .addHeader("Authorization","Bearer " +apiConnection.getAccessToken(clientId, clientSecretId))
                .addHeader("accept","application/vnd.allegro.public.v1+json")
                .addHeader("Content-Type","application/vnd.allegro.public.v1+json")
                .build();


        RestAssured.requestSpecification = requestSpecification;
    }
}