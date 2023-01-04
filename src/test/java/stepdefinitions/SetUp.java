package stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import org.apache.log4j.PropertyConfigurator;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static utils.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;

public class SetUp {
    protected static final String BASE_URL = "https://restful-booker.herokuapp.com";
    protected static final String BASE_PATH = "/booking";

    protected static final String AUTH= "/auth";


    protected static final String UPDATE = "/booking/927";

    protected Actor actor;
    protected Map<String, Object> headers = new HashMap<>();

    protected void setUpLog4j2(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
