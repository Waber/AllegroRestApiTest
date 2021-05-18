package testBase;

import apiData.Jsons;
import apiConfig.restAssuredConfiguration;
import apiService.ApiConnection;
import apiService.ApiDataService;

public class TestBase {
    public ApiConnection apiConnection;
    public ApiDataService apiDataService;
    public Jsons jsons;

    public TestBase() {
        apiConnection = new ApiConnection();
        apiDataService = new ApiDataService();
        jsons = new Jsons();
        restAssuredConfiguration.setUp();

    }
}
