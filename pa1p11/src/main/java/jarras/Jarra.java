package jarras;

public class Jarra {
    final private int capacidad;
    private int contenido;

    public Jarra(int capacidad){
        if(capacidad <= 0)
            throw new RuntimeException();
        this.capacidad = capacidad;
        this.contenido = 0;
    }

    public int capacidad(){
        return this.capacidad;
    }

    public int contenido(){
        return this.contenido;
    }

    public void llena(){
        this.contenido = capacidad;
    }

    public void vacia(){
        this.contenido = 0;
    }

    public void llenaDesde(Jarra jarra){
        if(this == jarra)
            throw new RuntimeException();
        while (this.contenido() < this.capacidad() && jarra.contenido() > 0){
            this.contenido++;
            jarra.contenido--;
        }
    }

    @Override
    public String toString (){
        return ("J(" + this.capacidad() + ", " + this.contenido() + ")");
    }

}
