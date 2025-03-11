package anonimo;

import notas.Estudiante;
import notas.EstudianteException;

public class PruebaEstudiante {

    public static void main (String[] args){
        try {

            Estudiante estudiante1 = new Estudiante("22456784F","Gonzalez Perez, Juan", 5.5);
            Estudiante estudiante2 = new Estudiante("33456777S", "Gonzalez Perez, Juan", -3.4);

            System.out.println(estudiante1);
            System.out.println(estudiante2);

            if(estudiante1.equals(estudiante2)){
                System.out.println("Los estudiantes son iguales");
            }else {
                System.out.println("Los estudiantes son diferentes");
            }

        } catch (EstudianteException e) {
            System.err.println(e.getMessage());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

}
