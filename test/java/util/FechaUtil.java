package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FechaUtil {
    
    // Formato que usa el JQuery Datepicker (MM/DD/YYYY)
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /**
     * Calcula la fecha esperada.
     * @param dia El día a seleccionar (ej: "15").
     * @param mesesASumar El número de meses a sumar (0 para mes actual, 1 para próximo, etc.).
     * @return La fecha formateada como MM/dd/yyyy.
     */
    public static String getFechaEsperada(String dia, int mesesASumar) {
        LocalDate fecha = LocalDate.now().plusMonths(mesesASumar);
        // Cambia el día de la fecha calculada
        fecha = fecha.withDayOfMonth(Integer.parseInt(dia));
        return fecha.format(FORMATO);
    }
}