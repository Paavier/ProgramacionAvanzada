package libreria;
import java.util.ArrayList;

public class Libreria {
    ArrayList<Libro> libs;

    public Libreria(){
        this.libs = new ArrayList<>();
    }

    public void addLibro(String autor, String titulo, double precioBase){
        Libro libro = new Libro(autor, titulo, precioBase);
        anyadirLibro(libro);
    }

    public void remLibro(String autor, String titulo){
        int posicion = buscarLibro(autor, titulo);
        if (posicion == -1)
            throw new RuntimeException ("Libro no encontrado (" + autor + ", " + titulo + ")");
        libs.remove(posicion);
    }

    public double getPrecioFinal (String autor, String titulo){
        int posicion = buscarLibro(autor, titulo);
        if (posicion == -1)
            throw new RuntimeException ("Libro no encontrado (" + autor + ", " + titulo + ")");
        return libs.get(posicion).getPrecioFinal();
    }

    @Override
    public String toString(){
        String libreria = "[";
        int tamanyo = libs.size();

        for (int i = 0; i < tamanyo; i++){
            libreria += libs.get(i);

            if (i != tamanyo - 1)
                libreria += ", ";
        }

        libreria += "]";
        return libreria;
    }

    protected void anyadirLibro(Libro libro){
        int indice = buscarLibro(libro.getAutor(), libro.getTitulo());
        if (indice == -1)
            libs.add(libro);
        else{
            libs.remove(indice);
            libs.add(indice, libro);
        }
    }

    private int buscarLibro(String autor, String titulo){
        boolean encontrado = false;
        Libro libroActual;
        int indice = -1;

        for (int i = 0; i < libs.size() && !encontrado; i++){
            libroActual = libs.get(i);
            if (libroActual.getAutor().equalsIgnoreCase(autor) && libroActual.getTitulo().equalsIgnoreCase(titulo)){
                encontrado = true;
                indice = i;
            }
        }
        return indice;
    }
}
