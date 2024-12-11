package set;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

public static String getFechaActual() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Formatear la fecha (por ejemplo, "29/07/2024")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaActual.format(formatter);
    }


public static LocalDate getFechaActualLocalDate() {
        // Obtener la fecha actual
        LocalDate fechaActualLocalDate = LocalDate.now();

        return fechaActualLocalDate;
    }

}