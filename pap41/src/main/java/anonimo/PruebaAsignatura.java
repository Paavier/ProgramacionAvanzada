package anonimo;

import notas.Asignatura;
import notas.Estudiante;
import notas.EstudianteException;
public class PruebaAsignatura {
    static final String[] ests = {"12455666F;Lopez Perez, Pedro;6.7",
            "33678999D;Merlo Gomez, Isabel;5.8",
            "23555875G;Martinez Herrera, Lucia;9.1"};

    public static void main (String[] args){
        Asignatura PA1 = new Asignatura("PA1", ests);
        try{
            System.out.println("Media de calificaciones: " + PA1.getMedia());

            for (Estudiante estudiante : PA1.getEstudiantes()){
                System.out.println(estudiante.getDni());
            }

            //System.out.println("La calificacion del estudiante Lopez Perez, Pedro es: " + PA1.getCalificacion(new Estudiante("12455666F", "Lopez Perez, Pedro")));
            System.out.println("La calificacion del estudiante Lopez Lopez, Pedro es: " + PA1.getCalificacion(new Estudiante("12455666F", "Lopez Lopez, Pedro")));


        }catch (EstudianteException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
