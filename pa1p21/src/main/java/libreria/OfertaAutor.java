package libreria;

public class OfertaAutor implements OfertaFlex{
    private double porcDescuento;
    private String[] autoresOferta;

    public OfertaAutor (double porcDescuento, String[] autoresOferta){
        this.porcDescuento = porcDescuento;
        this.autoresOferta = autoresOferta;
    }

    @Override
    public double getDescuento(Libro libro) {
        if (buscarAutorOferta(libro.getAutor()) == - 1)
            return 0;
        return this.porcDescuento;
    }

    @Override
    public String toString() {
        String mensaje = this.porcDescuento + "%[";
        int tamanyo = this.autoresOferta.length;
        for (int i = 0; i < tamanyo; i++){
            mensaje += this.autoresOferta[i];
            if (i != tamanyo-1)
                mensaje += ", ";
        }
        mensaje += "]\n";
        return mensaje;
    }

    private int buscarAutorOferta(String autor){
        boolean encontrado = false;
        int indice = -1;

        for (int i = 0; i < this.autoresOferta.length && !encontrado; i++){
            if (autor.equalsIgnoreCase(this.autoresOferta[i])){
                encontrado = true;
                indice = i;
            }
        }

        return indice;
    }
}
