package org.indices;

import java.io.PrintWriter;
import java.util.*;

public class IndicePosicionesEnLineas extends IndiceAbstracto{

     private SortedMap<String, SortedMap<Integer, SortedSet<Integer>>> indice;
     //                        palabra                  linea              posicionEnLinea

     public IndicePosicionesEnLineas(){
          super();
          this.indice = new TreeMap<>();
     }

     @Override
     public void resolver(String delimitadores){
          String palabra;
          int posicionEnLinea = 1;
          SortedMap<Integer, SortedSet<Integer>> numeroLineasConPosiciones;
          SortedSet<Integer> posiciones;

          indice.clear();

          for (int i = 0; i < this.texto.size(); i++){
               try(Scanner scanner = new Scanner(this.texto.get(i))){
                    scanner.useDelimiter(delimitadores);
                    while(scanner.hasNext()){
                         palabra = scanner.next().toLowerCase();

                         numeroLineasConPosiciones = indice.getOrDefault(palabra, new TreeMap<>());
                         posiciones = numeroLineasConPosiciones.getOrDefault(i+1, new TreeSet<>());
                         posiciones.add(posicionEnLinea);

                         numeroLineasConPosiciones.put(i+1, posiciones);
                         this.indice.put(palabra, numeroLineasConPosiciones);
                         posicionEnLinea++;
                    }
               }
               posicionEnLinea = 1;
          }
     }

     @Override
     public void presentarIndice(PrintWriter printWriter) {
          for(Map.Entry<String, SortedMap<Integer, SortedSet<Integer>>> entrada : this.indice.entrySet()){
               printWriter.println(entrada.getKey());
               for (Map.Entry<Integer, SortedSet<Integer>> entrada2 : entrada.getValue().entrySet()){
                    StringJoiner stringJoiner = new StringJoiner(", ", "<", ">");
                    for(int numero : entrada2.getValue()){
                         stringJoiner.add("" + numero);
                    }
                    printWriter.println("\t" + entrada2.getKey() + " " + stringJoiner.toString());
               }
          }

     }
}
