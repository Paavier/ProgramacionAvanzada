package notas;

import java.util.List;

public interface CalculoMedia {
    double calcular(List<Estudiante> estudiantes) throws EstudianteException;
}
