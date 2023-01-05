package utils;

public enum ContentBody {

    JSON_BODY("{\n" +
            "    \"firstname\": \"" + "Yuval" + "\",\n" +
            "    \"lastname\": \"" + "Harari" + "\",\n" +
            "    \"totalprice\": " + 6000 + ",\n" +
            "    \"depositpaid\": " + true + ",\n" +
            "    \"bookingdates\": " + "{\n"+
            "                   \"checkin\": \"" + "2018-01-01" + "\",\n" +
            "                   \"checkout\": \"" + "2021-01-01" + "\"\n" +
            "},\n" +
            "    \"additionalneeds\": \"" + "Novel" + "\"\n" +
            "}");




    private final String value;

    ContentBody(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
