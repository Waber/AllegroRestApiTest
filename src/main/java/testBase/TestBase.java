package testBase;

import apiService.ApiConnection;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {
    public ApiConnection apiConnection;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method){
        apiConnection = new ApiConnection();
    }
}
