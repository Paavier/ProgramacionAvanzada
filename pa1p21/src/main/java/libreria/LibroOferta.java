package libreria;

public class LibroOferta extends Libro{
    private double porcDescuento;

    public LibroOferta (String autor, String titulo, double precioBase, double porcDescuento){
        super (autor, titulo, precioBase);
        this.porcDescuento = porcDescuento;
    }

    public double getDescuento(){
        return this.porcDescuento;
    }

    @Override
    protected double getBaseImponible() {
        double baseImponibleSinDescuento = super.getBaseImponible();
        return baseImponibleSinDescuento - (baseImponibleSinDescuento * porcDescuento / 100);
    }

    @Override
    public String toString() {
        return "(" + this.getAutor() + "; " + this.getTitulo() + "; " +this. getPrecioBase() +
                "; " + this.getDescuento() + "%; " + this.getBaseImponible() + "; " + getIVA() + "%; " +
                this.getPrecioFinal() + ")";
    }
}
