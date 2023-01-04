package stepdefinitions.getall;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import stepdefinitions.SetUp;

public class GetAllSteps extends SetUp {
    @Dado("el usuario quiere consultar el listado de libros")
    public void elUsuarioQuiereConsultarElListadoDeLibros() {
        actor = Actor.named("Steven");
        actor.can(CallAnApi.at(BASE_URL));
    }

    @Cuando("el usuario hace la peticion de obtener el listado de libros completo")
    public void elUsuarioHaceLaPeticionDeObtenerElListadoDeLibrosCompleto() {
        actor.attemptsTo(
        );
    }

    @Entonces("el usuario deberia obtener el listado de libros completo")
    public void elUsuarioDeberiaObtenerElListadoDeLibrosCompleto() {
    }

    @Y("un codigo de respuesta {int}")
    public void unCodigoDeRespuesta(int arg0) {
    }
}
