package notas;

import java.util.List;

public class MediaSinExtremos implements CalculoMedia{
    private double min;
    private double max;

    public MediaSinExtremos(double min, double max){
        this.min = min;
        this.max = max;
    }

    public double getMin(){
        return this.min;
    }

    public void setMin(double min){
        this.min = min;
    }

    public double getMax(){
        return this.max;
    }

    public void setMax(double max){
        this.max = max;
    }

    @Override
    public double calcular(List<Estudiante> estudiantes) throws EstudianteException {
        long numEstudiantesIntervalo = estudiantes.stream()
                .filter(estudiante -> estudiante.getCalificacion() <= this.max && estudiante.getCalificacion() >= this.min)
                .count();
        if (numEstudiantesIntervalo == 0)
            throw new EstudianteException("No hay estudiantes");

        double sumaTotal = estudiantes.stream()
                .filter(estudiante -> estudiante.getCalificacion() <= this.max && estudiante.getCalificacion() >= this.min)
                .mapToDouble(estudiante -> estudiante.getCalificacion())
                .sum();

        return sumaTotal/numEstudiantesIntervalo;
    }
}
