package questions;

import models.Book;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetAllBooksResponse implements Question<Book> {

    public static GetAllBooksResponse getAllBooksResponse(){
        return new GetAllBooksResponse();
    }

    @Override
    public Book answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Book.class);
    }
}
