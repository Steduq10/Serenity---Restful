package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class StringResponse implements Question<String> {

   public static StringResponse stringResponse(){
       return new StringResponse();
   }

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().asString().replaceFirst("\\{\n\\s{4}\n}","");
    }
}
