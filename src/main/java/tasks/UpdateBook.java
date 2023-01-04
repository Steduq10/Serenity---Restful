package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.Map;

public class UpdateBook implements Task {
    private String resource;

    private Map<String, Object> headers;

    private String bodyRequest;

    public UpdateBook usingTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    public UpdateBook withHeaders(Map<String, Object> headers) {
        this.headers = headers;
        return this;
    }

    public UpdateBook andBodyRequest(String bodyRequest) {
        this.bodyRequest = bodyRequest;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(resource)
                        .with(
                                requestSpecification -> requestSpecification.relaxedHTTPSValidation()
                                        .headers(headers)
                                        .log().body()
                                        .body(bodyRequest)

                        )
        );
    }

    public static UpdateBook updateBook(){
        return new UpdateBook();
    }
}
