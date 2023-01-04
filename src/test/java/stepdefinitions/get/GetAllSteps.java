package stepdefinitions.get;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import questions.PrettierResponse;
import stepdefinitions.SetUp;
import tasks.GetBooks;

import static org.hamcrest.CoreMatchers.containsString;

public class GetAllSteps extends SetUp {

    public static final Logger LOGGER = Logger.getLogger(GetAllSteps.class);
    @Dado("el usuario quiere consultar el listado de libros")
    public void elUsuarioQuiereConsultarElListadoDeLibros() {
        try{
            setUpLog4j2();
            actor = Actor.named("Steven");
            actor.can(CallAnApi.at(BASE_URL));
            LOGGER.info("El usuario quiere consultar el listado de libros");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }

    @Cuando("el usuario hace la peticion de obtener el listado de libros completo")
    public void elUsuarioHaceLaPeticionDeObtenerElListadoDeLibrosCompleto() {
        try{
            actor.attemptsTo(
                    GetBooks.getAllBooks().usingTheResource(BASE_PATH)
            );
            LOGGER.info("El usuario hace la petición de obtener el listado de libros completo");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }

    @Entonces("el usuario deberia obtener el listado de libros completo")
    public void elUsuarioDeberiaObtenerElListadoDeLibrosCompleto() {
        try{
          //  LastResponse.received().answeredBy(actor).prettyPrint();
            actor.should(
                    GivenWhenThen.seeThat("La respuesta debe contener: bookingid ",
                            PrettierResponse.prettierResponse(), containsString("bookingid")
                    )
            );
            LOGGER.info("el usuario obtiene el listado de libros completo");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Y("un codigo de respuesta {int}")
    public void unCodigoDeRespuesta(int statusCode) {
        try{
            statusCode= HttpStatus.SC_OK;
           // LastResponse.received().answeredBy(actor).prettyPrint();

            actor.should(
                    ResponseConsequence.seeThatResponse("El código de respuesta debe ser: " + statusCode,
                            validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK))
            );
            LOGGER.info("El codigo de respuesta es OK(200)");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
