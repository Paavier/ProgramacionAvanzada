package libreria;

public class OfertaPrecio implements OfertaFlex{
    private double porcDescuento;
    private double umbralPrecio;

    public OfertaPrecio(double porcDescuento, double umbralPrecio){
        this.porcDescuento = porcDescuento;
        this.umbralPrecio = umbralPrecio;
    }

    @Override
    public double getDescuento(Libro libro) {
        if (libro.getPrecioBase() < this.umbralPrecio){
            return 0;
        }
        return this.porcDescuento;
    }

    @Override
    public String toString() {
        return this.porcDescuento + "%(" + this.umbralPrecio + ")";
    }
}
