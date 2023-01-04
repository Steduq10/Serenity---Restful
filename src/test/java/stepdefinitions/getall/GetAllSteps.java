package stepdefinitions.getall;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.apache.http.HttpStatus;
import questions.PrettierResponse;
import stepdefinitions.SetUp;
import tasks.GetAllBooks;

import static org.hamcrest.CoreMatchers.containsString;

public class GetAllSteps extends SetUp {
    @Dado("el usuario quiere consultar el listado de libros")
    public void elUsuarioQuiereConsultarElListadoDeLibros() {
        actor = Actor.named("Steven");
        actor.can(CallAnApi.at(BASE_URL));
    }

    @Cuando("el usuario hace la peticion de obtener el listado de libros completo")
    public void elUsuarioHaceLaPeticionDeObtenerElListadoDeLibrosCompleto() {
        actor.attemptsTo(
                GetAllBooks.getAllBooks().usingTheResource(BASE_PATH)
        );
    }

    @Entonces("el usuario deberia obtener el listado de libros completo")
    public void elUsuarioDeberiaObtenerElListadoDeLibrosCompleto() {
        LastResponse.received().answeredBy(actor).prettyPrint();

        actor.should(
               GivenWhenThen.seeThat("La respuesta debe contener: bookingid ",
                        PrettierResponse.prettierResponse(), containsString("bookingid")
                )
        );
    }

    @Y("un codigo de respuesta {int}")
    public void unCodigoDeRespuesta(int statusCode) {
        statusCode= HttpStatus.SC_OK;
        LastResponse.received().answeredBy(actor).prettyPrint();

        actor.should(
                ResponseConsequence.seeThatResponse("El código de respuesta debe ser: " + statusCode,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK))

        );
    }
}
