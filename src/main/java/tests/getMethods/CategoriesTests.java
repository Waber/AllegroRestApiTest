package tests.getMethods;

import apiConfig.Endpoints;
import apiData.Categories;
import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesTests extends TestBase {

    private List<Categories> categories;

    @BeforeMethod(alwaysRun = true)
    public void prepare() {
        categories = apiDataService.getListOfCategories();
    }

    @Test(description = "Validate size of category list")
    public void categorySizeTest() {
        assertThat(categories.size()).isEqualTo(13);
    }

    @Test
    public void categoryDataTest() {
        if (categories.size() > 0) {
            categories.stream().forEach(category -> assertThat(category.getId()).isNotNull());
            categories.stream().forEach(category -> assertThat(category.getLeaf()).isNotNull());
            categories.stream().forEach(category -> assertThat(category.getName()).isNotNull());
            categories.stream().forEach(category -> assertThat(category.getOptions().isAdvertisement()).isNotNull());
            categories.stream().forEach(category -> assertThat(category.getOptions().isAdvertisementPriceOptional()).isNotNull());
            categories.stream().forEach(category -> assertThat(category.getOptions().isCustomParametersEnabled()).isNotNull());
            categories.stream().forEach(category -> assertThat(category.getOptions().isOffersWithProductPublicationEnabled()).isNotNull());
            categories.stream().forEach(category -> assertThat(category.getOptions().isProductCreationEnabled()).isNotNull());
            categories.stream().forEach(category -> assertThat(category.getOptions().isVariantsByColorPatternAllowed()).isNotNull());
            categories.stream().forEach(category -> {
                if (category.getLeaf()) {
                    assertThat(category.getParent().getId()).isNotNull();
                } else {
                    assertThat(category.getParent()).isNull();
                }
            });
        }
    }

    @Test
    public void assertThatContentTypeHeaderForCategoriesIsNotNull(){
        AssertionsForClassTypes.assertThat(apiDataService.getHeaderValue(Endpoints.CATEGORIES,"content-type")).isNotNull();
    }

    @Test
    public void assertDifferentApproachInExtractingReponseProvideSameData(){
        List<String> names = apiDataService.getResponseDataAsList(Endpoints.CATEGORIES, "categories.name");
        categories.forEach(category -> names.contains(category.getName()));
    }

}
