package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetBooks implements Task {

    private String resource;

    public GetBooks usingTheResource(String resource){
        this.resource = resource;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(resource)
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
        );
    }

    public static GetBooks getAllBooks() {
        return new GetBooks();
    }
}
