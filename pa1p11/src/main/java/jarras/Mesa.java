package jarras;

public class Mesa {

    private Jarra jarraIzquierda;
    private Jarra jarraDerecha;

    public enum Posicion {
        Izquierda, Derecha;
    };

    public Mesa (int capacidadIzquierda, int capacidadDerecha){
        this.jarraIzquierda= new Jarra(capacidadIzquierda);
        this.jarraDerecha = new Jarra(capacidadDerecha);
    }

    public Mesa (Jarra jarraA, Jarra jarraB){
        if(jarraA == jarraB)
            throw new RuntimeException();
        this.jarraIzquierda = jarraA;
        this.jarraDerecha = jarraB;
    }

    public int capacidad (Posicion posicion){
        return posicion == Posicion.Izquierda ? jarraIzquierda.capacidad() : jarraDerecha.capacidad();
    }

    public int contenido(Posicion posicion){
        return posicion == Posicion.Izquierda ? jarraIzquierda.contenido() : jarraDerecha.contenido();
    }

    public void llena(Posicion posicion){
        if(posicion == Posicion.Izquierda){
            jarraIzquierda.llena();
        }
        else {
            jarraDerecha.llena();
        }
    }

    public void vacia (Posicion posicion){
        if (posicion == Posicion.Izquierda){
            jarraIzquierda.vacia();
        }
        else{
            jarraDerecha.vacia();
        }
    }

    public void llenaDesde(Posicion posicion){
        if (posicion == Posicion.Izquierda){
            jarraDerecha.llenaDesde(jarraIzquierda);
        }else{
            jarraIzquierda.llenaDesde(jarraDerecha);
        }
    }

    @Override
    public String toString(){
        return "M(" + jarraIzquierda + "," + jarraDerecha + ")";
    }
}
