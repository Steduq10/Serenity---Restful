package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

public class Auth implements Task {
    private String resource;
    private Map<String, Object> headers;
    private String bodyRequest;

    public Auth usingTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    public Auth withHeaders(Map<String, Object> headers) {
        this.headers = headers;
        return this;
    }

    public Auth andBodyRequest(String bodyRequest) {
        this.bodyRequest = bodyRequest;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(resource)
                        .with(
                                requestSpecification -> requestSpecification.relaxedHTTPSValidation()
                                        .headers(headers)
                                        .log().body()
                                        .body(bodyRequest)
                        )
        );
    }

    public static Auth auth(){
        return new Auth();
    }
}
