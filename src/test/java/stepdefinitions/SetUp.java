package stepdefinitions;

import net.serenitybdd.screenplay.Actor;

import java.util.HashMap;
import java.util.Map;

public class SetUp {
    protected static final String BASE_URL = "https://restful-booker.herokuapp.com";
    protected static final String BASE_PATH = "/booking";

    protected static final String AUTH= "/auth";


    protected static final String UPDATE = "/booking/927";

    protected Actor actor;
    protected Map<String, Object> headers = new HashMap<>();

}
