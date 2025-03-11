package notas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.StringBuilder;

public class Asignatura {

    private String nombre;
    private List<Estudiante> estudiantes = new ArrayList<>();
    private List<String> errores = new ArrayList<>();

    public Asignatura (String n, String[] ests){
        this.nombre = n;
        procesarEstudiantes(ests);
    }

    public double getCalificacion (Estudiante est) throws EstudianteException {
        int indice = buscarEstudiante(est);
        if (indice == -1){
            throw new EstudianteException("Estudiante " + est.getNombre() + " (" + est.getDni() + ") no se encuentra");
        }
        return estudiantes.get(indice).getCalificacion();
    }

    public List<Estudiante> getEstudiantes(){
        return this.estudiantes;
    }

    public List<String> getErrores(){
        return this.errores;
    }

    @Override
    public String toString(){
        StringBuilder mensaje = new StringBuilder();
        int tamanyoEstudiantes = this.estudiantes.size();
        int tamanyoErrores = this.errores.size();
        mensaje.append(this.nombre);
        mensaje.append(": { [");

        for (int i = 0; i < tamanyoEstudiantes; i++){
            mensaje.append(this.estudiantes.get(i));
            if (i != tamanyoEstudiantes - 1){
                mensaje.append(", ");
            }
        }
        mensaje.append("], [");
        for (int i = 0; i < tamanyoErrores; i++){
            mensaje.append(this.errores.get(i));
            if (i != tamanyoErrores - 1){
                mensaje.append(", ");
            }
        }
        mensaje.append("] }");

        return mensaje.toString();
    }

    public double getMedia() throws EstudianteException{
        double sumaTotal = 0;
        if (this.getEstudiantes().size() == 0){
            throw new EstudianteException("No hay estudiantes");
        }

        for(Estudiante estudiante : this.getEstudiantes()){
            sumaTotal += estudiante.getCalificacion();
        }

        return sumaTotal / this.getEstudiantes().size();
    }

    private void procesarEstudiantes(String[] ests){
        String[] datosEstudiante;
        Estudiante estudiante;
        for (String datos : ests){
            try{
                datosEstudiante = datos.split(";");

                if(datosEstudiante.length < 3)
                    throw new EstudianteException("Faltan datos");

                estudiante = new Estudiante(datosEstudiante[0], datosEstudiante[1], Double.parseDouble(datosEstudiante[2]));
                estudiantes.add(estudiante);
            } catch (EstudianteException e) {
                errores.add("ERROR. " + e.getMessage() + ": " + datos);
            } catch (NumberFormatException e) {
                errores.add("ERROR. Calificacion no numerica: " + datos);
            }
        }
    }

    private void procesarEstudiantes_AlternativoConScanner(String[] ests){
        String[] datosEstudiante = new String[3];
        Estudiante estudiante;
        for (String datos : ests){
            try{
                Scanner sc = new Scanner(datos);
                sc.useDelimiter(";");
                int indice = 0;
                while (sc.hasNext() && indice < 3){
                    datosEstudiante[indice] = sc.next();
                    indice++;
                }
                sc.close();

                if(indice < 3)
                    throw new EstudianteException("Faltan datos");

                estudiante = new Estudiante(datosEstudiante[0], datosEstudiante[1], Double.parseDouble(datosEstudiante[2]));
                estudiantes.add(estudiante);
            } catch (EstudianteException e) {
                errores.add("ERROR. " + e.getMessage() + ": " + datos);
            } catch (NumberFormatException e) {
                errores.add("ERROR. Nota no numerica: " + datos);
            }
        }
    }

    private int buscarEstudiante(Estudiante ests){
        for (int i = 0; i < this.estudiantes.size(); i++){
            if (this.estudiantes.get(i).equals(ests)){
                return i;
            }
        }
        return -1;
    }
}
