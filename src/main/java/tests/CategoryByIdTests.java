package tests;

import apiData.Categories;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testBase.TestBase;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CategoryByIdTests extends TestBase {
    private String categoryID = "42540aec-367a-4e5e-b411-17c09b08e41f";
    private Categories category;

    @BeforeMethod(alwaysRun = true)
    public void prepare() {
         category = apiDataService.getCategoryById(categoryID);
    }

    @Test
    public void getCategoryById(){
        assertThat(category).isNotNull();
    }

    @Test
    public void checkCategoryName(){
        assertThat(category.getName()).isEqualTo("Elektronika");
    }

    @Test (description = "If category with provided Id does not exist, object should not be created")
    public void wrongCategoryIdCheck(){
        assertThat(apiDataService.getCategoryById("123456789")).isNull();
    }
}
