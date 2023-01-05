package utils;

public enum ContentBodyAuth {

    JSON_BODY("{\n" +
            "    \"username\": \"admin\",\n" +
            "    \"password\": \"password123\"\n" +
            "}");




    private final String value;

    ContentBodyAuth(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
