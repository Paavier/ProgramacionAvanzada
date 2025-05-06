package org.indices;

import java.io.PrintWriter;
import java.util.*;

public class IndiceLineas extends IndiceContador{

     private SortedMap<String, SortedSet<Integer>> indice;

     public IndiceLineas(){
          super();
          this.indice = new TreeMap<>();
     }

     @Override
     public void resolver(String delimitadores){
          String palabra;
          SortedSet<Integer> numeroLineas;

          indice.clear();

          for (int i = 0; i < this.texto.size(); i++){
               try(Scanner scanner = new Scanner(this.texto.get(i))){
                    scanner.useDelimiter(delimitadores);
                    while(scanner.hasNext()){
                         palabra = scanner.next().toLowerCase();
                         SortedSet<Integer> apariciones = indice.getOrDefault(palabra, new TreeSet<>());
                         apariciones.add(i+1);
                         this.indice.put(palabra, apariciones);
                    }
               }
          }
     }

     @Override
     public void presentarIndice(PrintWriter printWriter){
          for(Map.Entry<String, SortedSet<Integer>> entrada : this.indice.entrySet()){
               StringJoiner stringJoiner = new StringJoiner(", ", "<", ">");
               for(int numero : entrada.getValue()){
                    stringJoiner.add("" + numero);
               }
               printWriter.println(entrada.getKey() + "\t" + stringJoiner.toString());
          }
     }
}
