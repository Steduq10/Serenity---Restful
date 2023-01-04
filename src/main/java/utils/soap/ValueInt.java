package utils.soap;

public enum ValueInt {
    INTA("[intA]"),
    INTB("[intB]");

    private final String value;

    ValueInt(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
