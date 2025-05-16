package org.alturas;

import java.util.Objects;

public class Pais implements Comparable<Pais> {
    private String nombre;
    private String continente;
    private double alturaMedia;

    public Pais(String nombre, String continente, double alturaMedia){
        this.nombre = nombre;
        this.continente = continente;
        this.alturaMedia = alturaMedia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContinente() {
        return continente;
    }

    public double getAltura() {
        return alturaMedia;
    }

    @Override
    public boolean equals (Object o){
        if(this == o)
            return true;
        return (o instanceof Pais nuevoPais) && this.nombre.equals(nuevoPais.nombre);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.nombre);
    }

    @Override
    public int compareTo(Pais pais){
        return this.nombre.compareTo(pais.nombre);
    }

    @Override
    public String toString(){
        return "Pais(" + this.nombre +", " + this.continente + ", " + this.alturaMedia + ")";
    }
}
