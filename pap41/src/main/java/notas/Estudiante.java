package notas;

import java.util.Objects;

public class Estudiante {

    private String dni;
    private String nombre;
    private double nota;

    public Estudiante(String dni, String nombre, double nota) throws EstudianteException{
        if(nota < 0)
            throw new EstudianteException("Calificacion negativa");
        this.dni = dni;
        this.nombre = nombre;
        this.nota = nota;
    }

    public Estudiante(String dni, String nombre){
        this.dni = dni;
        this.nombre = nombre;
        this.nota = 0;
    }

    public String getDni(){
        return this.dni;
    }

    public String getNombre(){
        return this.nombre;
    }

    public double getCalificacion(){
        return this.nota;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        //¿Puedo asumir que o es siempre un Estudiante? si no lo es lanzará una excepcion al hacer el cast
        //¿Puedo tambien asumir que no es nulo? si lo es lanzará otra excepcion
        if (o == null || o.getClass() != this.getClass()) return false;

        Estudiante estudiante = (Estudiante) o;
        return this.getNombre().equals(estudiante.getNombre()) &&
                this.getDni().equalsIgnoreCase(estudiante.getDni());
    }

    //Siempre que se sobreescribe el metodo equals hay que sobreescribir el metodo hashCode
    @Override
    public int hashCode(){
        return Objects.hash(this.getNombre(), this.getDni().toLowerCase());
    }

    @Override
    public String toString(){
        return this.getNombre() + " (" + this.getDni() + ")";
    }
}
