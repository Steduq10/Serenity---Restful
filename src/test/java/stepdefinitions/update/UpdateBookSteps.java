package stepdefinitions.update;

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
import tasks.Auth;
import tasks.UpdateBook;
import utils.ContentBody;
import utils.ContentBodyAuth;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.containsString;

public class UpdateBookSteps extends SetUp {

    public static final Logger LOGGER = Logger.getLogger(UpdateBookSteps.class);
    @Dado("a que el usuario se encuentra registrado con un perfil con permisos de admin")
    public void aQueElUsuarioSeEncuentraRegistradoConUnPerfilConPermisosDeAdmin() {
        try {
            setUpLog4j2();

            actor = Actor.named("Steven");
            actor.can(CallAnApi.at(BASE_URL));

            headersAuth.put("Content-Type", "application/json");
            bodyRequestAuth = ContentBodyAuth.JSON_BODY.getValue();

            actor.attemptsTo(
                    Auth.auth().usingTheResource(AUTH)
                            .withHeaders(headersAuth)
                            .andBodyRequest(bodyRequestAuth)

            );
            String token = LastResponse.received().answeredBy(actor).prettyPrint()
                    .replace("\"", "").replace("{", "").replace("token: ", "")
                    .replace(" ", "").replace("\n", "").replace("}","");


            headers.put("Content-Type", "application/json");
            headers.put("Cookie", "token=" + token);
            bodyRequest = ContentBody.JSON_BODY.getValue();

            LOGGER.info("El usuario se encuentra registrado");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Cuando("el usuario hace una peticion de actualizacion de un registro de un libro")
    public void elUsuarioHaceUnaPeticionDeActualizacionDeUnRegistroDeUnLibro() {
        try {
            actor.attemptsTo(
                    UpdateBook.updateBook().usingTheResource(ID)
                            .withHeaders(headers)
                            .andBodyRequest(bodyRequest)
            );

            LOGGER.info("El usuario hace la petición de actualizacion de un registro");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Entonces("el usuario debera ver un codigo de respuesta {int} y la informacion del libro actualizado")
    public void elUsuarioDeberaVerUnCodigoDeRespuestaYLaInformacionDelLibroActualizado(int statusCode) {
        try {
            statusCode = HttpStatus.SC_OK;
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
                    seeThatResponse("El código de respuesta debe ser" + statusCode,
                            validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK)
                    )

            );
            LOGGER.info("El usuario obtiene la informacion actualizada y el codigo de respuesta esperado");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
