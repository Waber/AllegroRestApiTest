package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testBase.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class ParametersSupportedByCategory extends TestBase {
    private String categoryID = "42540aec-367a-4e5e-b411-17c09b08e41f";
    private String parameters;

    @BeforeMethod(alwaysRun = true)
    public void prepare() {
        parameters = apiDataService.getParametersById(categoryID);
    }

    @Test
    public void getParametersById() {
        assertThat(parameters).isNotNull();
    }

    @Test
    public void checkCategoryParameters() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(parameters);
        JsonNode firstParametersNode = node.get("parameters").get(0);
        assertThat(firstParametersNode.get("id")).isNotNull();
        assertThat(firstParametersNode.get("name")).isNotNull();
        assertThat(firstParametersNode.get("type")).isNotNull();
        assertThat(firstParametersNode.get("required")).isNotNull();
        assertThat(firstParametersNode.get("unit")).isNotNull();
        assertThat(firstParametersNode.get("options")).isNotNull();
        assertThat(firstParametersNode.get("dictionary")).isNotNull();
        assertThat(firstParametersNode.get("restrictions")).isNotNull();
    }

    @Test
    public void checkNoParamatersForWrongCategoryId(){
        assertThat(apiDataService.getParametersById("123456")).isNull();
    }
}
