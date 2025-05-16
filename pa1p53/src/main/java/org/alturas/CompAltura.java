package org.alturas;

import java.util.Comparator;

public class CompAltura implements Comparator<Pais> {
     @Override
     public int compare(Pais pais, Pais otroPais){
          int comparacionAltura = Double.compare(pais.getAltura(), otroPais.getAltura());

          //esto lo puso para los test (no lo dice en la practica) pero sino no pasa el test
          if (comparacionAltura == 0) {
               return pais.compareTo(otroPais);
          }
          return comparacionAltura;
     }
}
