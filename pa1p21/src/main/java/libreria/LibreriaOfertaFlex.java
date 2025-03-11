package libreria;

public class LibreriaOfertaFlex extends Libreria{
    private OfertaFlex oferta; // referencia al objeto para calcular descuentos (tiene multiplicicdad 0..1 por lo que puede tenerla pero no esta obligada a ello)

    public LibreriaOfertaFlex(OfertaFlex ofertaFlex){
        super();
        this.oferta = ofertaFlex;
    }

    public void setOferta (OfertaFlex oferta){
        this.oferta = oferta;
    }

    public OfertaFlex getOferta(){
        return this.oferta;
    }

    @Override
    public void addLibro (String autor, String titulo, double precioBase){
        Libro libro = new Libro (autor, titulo, precioBase);
        double descuento = oferta.getDescuento(libro);
        if (descuento != 0){
            LibroOferta libroOferta = new LibroOferta(autor, titulo, precioBase, descuento);
            anyadirLibro(libroOferta);
        }else{
            anyadirLibro(libro);
        }
    }

    @Override
    public String toString(){
        String mensaje = this.getOferta() + "[";
        int tamanyo = this.libs.size();
        for (int i = 0; i < tamanyo; i++){
            mensaje += this.libs.get(i);
            if (i != tamanyo-1)
                mensaje += ", ";
        }
        mensaje += "]\n";
        return mensaje;
    }
}
