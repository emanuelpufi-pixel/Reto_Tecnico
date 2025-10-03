package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SwitchToWebFrame;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import ui.DatepickerPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarFecha implements Task {

    private final String dia;

    // Constructor
    public SeleccionarFecha(String dia) {
        this.dia = dia;
    }

    // Método estático para usar en el Step Definition
    public static SeleccionarFecha paraElDia(String dia) {
        return instrumented(SeleccionarFecha.class, dia);
    }

    @Override
    @Step("{0} selecciona el día #dia del calendario")
    public <T extends Actor> void performAs(T actor) {
        // Pasos según el requisito[cite: 14, 15, 16]:
        actor.attemptsTo(
            // 2. Cambiar al iframe [cite: 14]
            SwitchToWebFrame.fromPage(DatepickerPage.IFRAME),
            
            // 3. Hacer clic en el campo de selección de fecha [cite: 15]
            Click.on(DatepickerPage.INPUT_FECHA),
            
            // 4. Seleccionar el día 15 del mes actual [cite: 16]
            Click.on(Target.the("Dia " + dia)
                           .located(By.xpath("//td/a[text()='" + dia + "']")))
        );
    }
}