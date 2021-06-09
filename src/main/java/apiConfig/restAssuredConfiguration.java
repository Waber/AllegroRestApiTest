package apiConfig;

import apiConfig.Endpoints;
import apiService.ApiConnection;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public abstract class restAssuredConfiguration {

    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;
    private static ApiConnection apiConnection = new ApiConnection();
    private static String clientId = "da4451538e2e4501bf5dbd3225ca303f";
    private static String clientSecretId = "q89rtCYj7RPSEhOWswagnrU0QojX2tA0jGhiUNdrnRxk09fNouXBDnP8dG1DSsxq";
    private static final String token = apiConnection.getAccessToken(clientId, clientSecretId);

    public static void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(Endpoints.APIURL)
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Accept", "application/vnd.allegro.public.v1+json")
                .addHeader("Content-Type", "application/vnd.allegro.public.v1+json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();


        RestAssured.requestSpecification = requestSpecification;
    }
}
