package questions;

import models.Book;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetBooksResponse implements Question<Book> {

    public static GetBooksResponse getAllBooksResponse(){
        return new GetBooksResponse();
    }

    @Override
    public Book answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Book.class);
    }
}
