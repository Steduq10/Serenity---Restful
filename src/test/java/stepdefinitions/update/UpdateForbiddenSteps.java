package stepdefinitions.update;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import stepdefinitions.SetUp;
import stepdefinitions.getall.GetAllSteps;
import tasks.UpdateBook;
import utils.ContentBody;

public class UpdateForbiddenSteps extends SetUp {

    public static final Logger LOGGER = Logger.getLogger(UpdateForbiddenSteps.class);
    @Dado("a que el usuario no se encuentra registrado")
    public void aQueElUsuarioNoSeEncuentraRegistrado() {
        try {
            setUpLog4j2();
            actor = Actor.named("Steven");
            actor.can(CallAnApi.at(BASE_URL));
            headers.put("Content-Type", "application/json");
            bodyRequest = ContentBody.JSON_BODY.getValue();

            LOGGER.info("El usuario no se encuentra registrado");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }

    @Cuando("el usuario hace una peticion de actualizacion de un registro")
    public void elUsuarioHaceUnaPeticionDeActualizacionDeUnRegistro() {
        try {
            actor.attemptsTo(
                    UpdateBook.updateBook().usingTheResource(UPDATE)
                            .withHeaders(headers)
                            .andBodyRequest(bodyRequest)
            );

            LOGGER.info("El usuario hace la petición de actualizacion de un registro");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Entonces("el usuario debera ver un codigo de respuesta {int}")
    public void elUsuarioDeberaVerUnCodigoDeRespuesta(int statusCode) {
        try {
            statusCode = HttpStatus.SC_FORBIDDEN;
            LastResponse.received().answeredBy(actor).prettyPrint();
            actor.should(
                    ResponseConsequence.seeThatResponse("El código de respuesta debe ser: " + statusCode,
                            validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_FORBIDDEN))
            );

            LOGGER.info("El código de respuesta es FORBIDDEN(403)");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
