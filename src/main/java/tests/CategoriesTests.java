package tests;

import apiData.categories;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesTests extends TestBase {
    private String token;
    private String clientId = "d693faf0a35045b8b2535a295a4307fa";
    private String clientSecretId = "82YM1jaNebM6K4vX2kaYTxjlpw5Q2xaI7mD8px1zH75X7RpdOqDmWgm6CPOAxUbE";
    List<categories> kategorie;

    @BeforeMethod(alwaysRun = true)
    public void prepare() {
        token = apiConnection.getAccessToken(clientId, clientSecretId);
        kategorie = apiConnection.dataToList(token);
    }

    @Test(testName = "Assert category size is equal to 13")
    public void categorySizeTest() {
        String wynik = apiConnection.getSomeData(token);

        assertThat(kategorie.size()).isEqualTo(13);
    }

    @Test
    public void categoryDataTest() {
        kategorie.stream().forEach(category -> assertThat(category.getId()).isNotNull());
        kategorie.stream().forEach(category -> assertThat(category.getLeaf()).isNotNull());
        kategorie.stream().forEach(category -> assertThat(category.getName()).isNotNull());
        kategorie.stream().forEach(category -> assertThat(category.getOptions().getAdvertisement()).isNotNull());
        kategorie.stream().forEach(category -> assertThat(category.getOptions().getAdvertisementPriceOptional()).isNotNull());
        kategorie.stream().forEach(category -> assertThat(category.getOptions().getCustomParametersEnabled()).isNotNull());
        kategorie.stream().forEach(category -> assertThat(category.getOptions().getOffersWithProductPublicationEnabled()).isNotNull());
        kategorie.stream().forEach(category -> assertThat(category.getOptions().getProductCreationEnabled()).isNotNull());
        kategorie.stream().forEach(category -> assertThat(category.getOptions().getVariantsByColorPatternAllowed()).isNotNull());
        kategorie.stream().forEach(category -> {
            if (category.getLeaf().equals(true)) {
                assertThat(category.getParent().getId()).isNotNull();
            } else {
                assertThat(category.getParent()).isNull();
            }
        });

    }
}
