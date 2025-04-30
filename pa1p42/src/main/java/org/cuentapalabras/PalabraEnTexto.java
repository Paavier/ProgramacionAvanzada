package org.cuentapalabras;

import java.util.Objects;

public class PalabraEnTexto {

     private String palabra;
     private int veces;

     public PalabraEnTexto (String palabra){
          this.palabra = palabra.toUpperCase();
          this.veces = 1;
     }

     public void incrementa (){
          this.veces ++;
     }

     @Override
     public boolean equals (Object o){
          if (this == o)
               return true;
          return (o instanceof PalabraEnTexto nuevaPalabra) && this.palabra.equals(nuevaPalabra.palabra.toUpperCase());
     }

     @Override
     public int hashCode(){
          return Objects.hash(palabra);
     }

     @Override
     public String toString(){
          return this.palabra + ": " + this.veces;
     }
}
