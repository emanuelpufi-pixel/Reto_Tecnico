package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import questions.ElCampoFechaTieneElValor;
import tasks.SeleccionarFecha;
import util.FechaUtil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static util.FechaUtil.formatearDiaMesAnio;

public class CitaStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver browser;
    private final String URL = "https://jqueryui.com/datepicker/";

    @Before
    public void setup() {
        // Prepara el Actor 'Laura' y le da la habilidad de navegar
        theActorCalled("Laura").can(BrowseTheWeb.with(browser));
    }

    @Given("^que Laura quiere reservar una cita$")
    public void queLauraQuiereReservarUnaCita() {
        // Abre la página principal [cite: 13]
        theActorInTheSpotlight().attemptsTo(
            Open.url(URL)
        );
    }

    @When("^ella selecciona el dia \"([^\"]*)\" del mes actual$")
    public void ellaSeleccionaElDiaDelMesActual(String dia) {
        theActorInTheSpotlight().attemptsTo(
            SeleccionarFecha.paraElDia(dia)
        );
    }

    @Then("^el campo de fecha debe mostrar el dia \"([^\"]*)\" de este mes$")
    public void elCampoDeFechaDebeMostrarElDiaDeEsteMes(String dia) {
        String fechaEsperada = FechaUtil.getFechaEsperada(dia, 0); // 0 = mes actual

        theActorInTheSpotlight().should(
            // Valida el resultado con la Pregunta [cite: 17]
            seeThat(ElCampoFechaTieneElValor.actualmente(), containsString(fechaEsperada))
        );
        // NOTA: Recuerda que después de la validación, es buena práctica volver al contexto principal
        // si se va a interactuar con elementos fuera del iframe, usando:
        // theActorInTheSpotlight().attemptsTo(SwitchToWebFrame.defaultContext());
    }
}