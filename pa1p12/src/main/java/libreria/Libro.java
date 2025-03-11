package libreria;

public class Libro
{
    private static double porcIVA = 10;
    private String autor;
    private String titulo;
    private double precioBase;

    public Libro(String autor, String titulo, double precioBase){
        this.autor = autor;
        this.titulo = titulo;
        this.precioBase = precioBase;
    }

    public String getAutor(){
        return this.autor;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public double getPrecioBase(){
        return this.precioBase;
    }

    protected double getBaseImponible(){
        return this.precioBase;
    }

    public double getPrecioFinal(){
        return this.getBaseImponible() + (this.getBaseImponible() * porcIVA/100);
    }

    @Override
    public String toString(){
        return "(" + this.getAutor() + "; " + this.getTitulo() + "; " +this. getPrecioBase() + "; " + getIVA() + "%; " + this.getPrecioFinal() + ")";
    }

    public static double getIVA() {
        return porcIVA;
    }

    public static void setIVA(double IVA){
        porcIVA = IVA;
    }
}
