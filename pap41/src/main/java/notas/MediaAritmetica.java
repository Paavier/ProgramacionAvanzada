package notas;

import java.util.List;

public class MediaAritmetica implements CalculoMedia{
    @Override
    public double calcular(List<Estudiante> estudiantes) throws EstudianteException {
        if(estudiantes.isEmpty())
            throw new EstudianteException("No hay estudiantes");

        double sumaTotal = estudiantes.stream().mapToDouble(estudiante -> estudiante.getCalificacion()).sum();

        return sumaTotal/estudiantes.size();
    }
}
