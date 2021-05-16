package apiData;

import lombok.Getter;

@Getter
public class Categories {
    private String id;
    private String name;
    private Parent parent;
    private Options options;
    private Boolean leaf;

}
