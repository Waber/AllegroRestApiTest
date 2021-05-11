package testBase;

import apiService.ApiConfig;
import apiService.ApiConnection;
import apiService.ApiDataService;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {
    private String clientId = "d693faf0a35045b8b2535a295a4307fa";
    private String clientSecretId = "82YM1jaNebM6K4vX2kaYTxjlpw5Q2xaI7mD8px1zH75X7RpdOqDmWgm6CPOAxUbE";
    public ApiConnection apiConnection;
    public ApiDataService apiDataService;
    private String token;

    public TestBase(){
        apiConnection = new ApiConnection();
        apiDataService = new ApiDataService();
        //token = apiConnection.getAccessToken(clientId, clientSecretId);
        ApiConfig.setUp();
    }

    public String getToken() {
        return token;
    }
}
