package libreria;

public class LibreriaOferta extends Libreria{
    private double porcDescuento;
    String[] autoresOferta;

    public LibreriaOferta (double porcDescuento, String[] autoresOferta){
        super();
        this.porcDescuento = porcDescuento;
        this.autoresOferta = autoresOferta;
    }

    public void setOferta(double porcDescuento, String[] autoresOferta){
        this.porcDescuento = porcDescuento;
        this.autoresOferta = autoresOferta;
    }

    public String[] getOferta(){
        return this.autoresOferta;
    }

    public double getDescuento(){
        return this.porcDescuento;
    }

    @Override
    public void addLibro(String autor, String titulo, double precioBase) {
        Libro libro;
        if (buscarAutorOferta(autor) != -1) {
            // como LibroOferta hereda de libro puede ser tratado como un libro (Polimorfismo)
            libro = new LibroOferta(autor, titulo, precioBase, this.getDescuento());
        } else{
            libro = new Libro(autor, titulo, precioBase);
        }
        // Aunque reciba como parametro un LibroOferta no hay problema porque es un subtipo de libro
        super.anyadirLibro(libro);
    }

    @Override
    public String toString() {
        //lo malo de esto es que cada += genera un nuevo objeto pero no hemos dado el StringBuilder...
        String mensaje = this.porcDescuento + "%[";
        int tamanyo = this.autoresOferta.length;
        for (int i = 0; i < tamanyo; i++){
            mensaje += this.autoresOferta[i];
            if (i != tamanyo-1)
                mensaje += ", ";
        }
        mensaje += "]\n";
        return mensaje + super.toString();
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
