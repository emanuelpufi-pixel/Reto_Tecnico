package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Value;
import ui.DatepickerPage;

import static util.FechaUtil.getFechaEsperada;

public class ElCampoFechaTieneElValor implements Question<String> {

    // 1. Método estático para usar la Pregunta de forma legible
    public static ElCampoFechaTieneElValor actualmente() {
        return new ElCampoFechaTieneElValor();
    }

    @Override
    public String answeredBy(Actor actor) {
        // 2. Obtiene el valor del campo de texto INPUT_FECHA [cite: 17]
        return Value.of(DatepickerPage.INPUT_FECHA).answeredBy(actor);
    }
}