package apiData;

public class Categories {
    private String id;
    private String name;
    private Parent parent;
    private Options options;
    private boolean leaf;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Parent getParent() {
        return parent;
    }

    public Options getOptions() {
        return options;
    }

    public boolean getLeaf() {
        return leaf;
    }
}
