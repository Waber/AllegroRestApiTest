package tests;

import apiData.Categories;
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
            categories.stream().forEach(category -> assertThat(category.getOptions().getAdvertisement()).isNotNull());
            categories.stream().forEach(category -> assertThat(category.getOptions().getAdvertisementPriceOptional()).isNotNull());
            categories.stream().forEach(category -> assertThat(category.getOptions().getCustomParametersEnabled()).isNotNull());
            categories.stream().forEach(category -> assertThat(category.getOptions().getOffersWithProductPublicationEnabled()).isNotNull());
            categories.stream().forEach(category -> assertThat(category.getOptions().getProductCreationEnabled()).isNotNull());
            categories.stream().forEach(category -> assertThat(category.getOptions().getVariantsByColorPatternAllowed()).isNotNull());
            categories.stream().forEach(category -> {
                if (category.getLeaf()) {
                    assertThat(category.getParent().getId()).isNotNull();
                } else {
                    assertThat(category.getParent()).isNull();
                }
            });
        }
    }
}
