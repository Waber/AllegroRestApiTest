package apiData;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
public class Options {
    private boolean advertisement;
    private boolean advertisementPriceOptional;
    private boolean variantsByColorPatternAllowed;
    private boolean offersWithProductPublicationEnabled;
    private boolean productCreationEnabled;
    private boolean customParametersEnabled;
    private boolean variantsAllowed;
    private boolean variantsEqual;
    private String ambiguousValueId;
    private String dependsOnParameterId;
    private String[] requiredDependsOnValueIds;
    private String[] displayDependsOnValueIds;
    private boolean describesProduct;
    private boolean customValuesEnabled;

}
