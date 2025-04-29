package notas;

public class AsignaturaMedias extends Asignatura{
    public AsignaturaMedias(String n, String[] ests){
        super(n, ests);
    }

    public double getMedia() throws EstudianteException{
        return super.getMedia();
    }
    public double getMedia(CalculoMedia calc) throws EstudianteException{
        return calc.calcular(this.getEstudiantes());
    }
}
