package notas;

import java.util.List;

public class MediaArmonica implements CalculoMedia{
    @Override
    public double calcular(List<Estudiante> estudiantes) throws EstudianteException {
        //.stream nos devuelve la lista como un flujo de datos (los recorre todos)
        //.filter filtra y se queda con los que cumplen x condicion
        long numeroEstudiantesNotaMayorCero = estudiantes.stream()
                .filter(estudiante -> estudiante.getCalificacion()>0)
                .count();

        if (numeroEstudiantesNotaMayorCero == 0)
            throw new EstudianteException("No hay estudiantes");

        //.mapToDouble devuelve un stream con los valores del resultado de aplicar esa operacion
        double sumaTotal = estudiantes.stream()
                .filter(estudiante -> estudiante.getCalificacion() > 0)
                .mapToDouble(estudiante -> 1.0/estudiante.getCalificacion())
                .sum();

        return numeroEstudiantesNotaMayorCero/sumaTotal;
    }
}
