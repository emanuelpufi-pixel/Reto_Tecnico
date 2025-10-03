package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatepickerPage {

    // Selector del Iframe (el calendario está dentro de este)
    public static final Target IFRAME = Target.the("iFrame del Datepicker")
            .located(By.className("demo-frame"));

    // Selector del campo de texto donde aparece la fecha
    public static final Target INPUT_FECHA = Target.the("Campo de selección de fecha")
            .located(By.id("datepicker"));
}