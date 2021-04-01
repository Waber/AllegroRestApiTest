package testBase;

import apiService.ApiConnection;
import apiService.ApiDataService;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {
    private String clientId = "Insert your clientId";
    private String clientSecretId = "Insert your client secret Id";
    public ApiConnection apiConnection;
    public ApiDataService apiDataService;
    private String token;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method){
        apiConnection = new ApiConnection();
        apiDataService = new ApiDataService();
        token = apiConnection.getAccessToken(clientId, clientSecretId);
    }

    public String getToken() {
        return token;
    }
}
