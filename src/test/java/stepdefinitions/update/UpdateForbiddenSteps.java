package stepdefinitions.update;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class UpdateForbiddenSteps {
    @Dado("a que el usuario no se encuentra registrado")
    public void aQueElUsuarioNoSeEncuentraRegistrado() {
    }

    @Cuando("el usuario hace una peticion de actualizacion de un registro")
    public void elUsuarioHaceUnaPeticionDeActualizacionDeUnRegistro() {
    }

    @Entonces("el usuario debera ver un codigo de respuesta {int}")
    public void elUsuarioDeberaVerUnCodigoDeRespuesta(int arg0) {
    }
}
