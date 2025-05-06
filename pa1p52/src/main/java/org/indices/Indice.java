package org.indices;

import java.io.PrintWriter;

public interface Indice {
     void agregarFrase(String frase);
     void resolver(String delimitadores);
     void presentarIndice(PrintWriter printWriter);
     default void presentarIndiceConsola(){
          PrintWriter printWriter = new PrintWriter(System.out, true);
          presentarIndice(printWriter);
     }
}
