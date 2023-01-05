package stepdefinitions.get;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import questions.StringResponse;
import stepdefinitions.SetUp;
import tasks.GetBooks;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.containsString;

public class GetByIDSteps extends SetUp {

    public static final Logger LOGGER = Logger.getLogger(GetAllSteps.class);
    @Dado("el usuario quiere consultar la informacion de un libro por su id")
    public void elUsuarioQuiereConsultarLaInformacionDeUnLibroPorSuId() {
        try {
            setUpLog4j2();
            actor = Actor.named("Steven");
            actor.can(CallAnApi.at(BASE_URL));

            LOGGER.info("El usuario quiere consultar la informacion de un libro por su id");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }

    @Cuando("el usuario hace la peticion de obtener la informacion del libro por su id")
    public void elUsuarioHaceLaPeticionDeObtenerLaInformacionDelLibroPorSuId() {

        try {
            actor.attemptsTo(
                   GetBooks.getAllBooks().usingTheResource(ID)
            );

            LOGGER.info("El usuario hace la peticion de obtener el libro con id: " + ID);
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Entonces("el usuario deberia obtener la informacion correspondiente al id del libro buscado y un codigo de respuesta {int}")
    public void elUsuarioDeberiaObtenerLaInformacionCorrespondienteAlIdDelLibroBuscadoYUnCodigoDeRespuesta(int arg0) {

        try {
            LastResponse.received().answeredBy(actor).prettyPrint();
            String response = StringResponse.stringResponse().answeredBy(actor);

            actor.should(
                    GivenWhenThen.seeThat("La respuesta incluye firstname",
                            responseRequest -> response, containsString("firstname")
                    ),
                    GivenWhenThen.seeThat("La respuesta incluye lastname",
                            responseRequest -> response, containsString("lastname")
                    ),
                    GivenWhenThen.seeThat("La respuesta incluye totalprice",
                            responseRequest -> response, containsString("totalprice")
                    ),
                    GivenWhenThen.seeThat("La respuesta incluye depositpaid",
                            responseRequest -> response, containsString("depositpaid")
                    ),
                    GivenWhenThen.seeThat("La respuesta incluye bookingdates",
                            responseRequest -> response, containsString("bookingdates")
                    ),
                    GivenWhenThen.seeThat("La respuesta incluye additionalneeds",
                            responseRequest -> response, containsString("additionalneeds")
                    ),
                    seeThatResponse("El código de respuesta debe ser" + HttpStatus.SC_OK,
                            validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK)
                    )

            );
            LOGGER.info("El usuario obtiene la informacion requerida y el codigo de respuesta esperado");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
