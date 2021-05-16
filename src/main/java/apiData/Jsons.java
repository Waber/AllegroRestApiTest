package apiData;

import lombok.Getter;

@Getter
public class Jsons {
    String createContactJson = "{\n" +
            "  \"name\": \"%s\",\n" +
            "  \"emails\": [\n" +
            "    {\n" +
            "      \"address\": \"%s\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"phones\": [\n" +
            "    {\n" +
            "      \"number\": \"%s\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
}
