package org.indices;

import java.io.PrintWriter;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Scanner;

public class IndiceContador extends IndiceAbstracto{
     private SortedMap<String, Integer> indice;

     public IndiceContador(){
          super();
          this.indice = new TreeMap<>();
     }

     @Override
     public void resolver(String delimitadores){
          String palabra;
          this.indice.clear();
          for(String frase : this.texto){
               try(Scanner scanner = new Scanner(frase)){
                    scanner.useDelimiter(delimitadores);
                    while(scanner.hasNext()){
                         palabra = scanner.next().toLowerCase();
                         // devuelve el numero de veces asociado a la clave palabra, si no la encuentra deveulve el valor default
                         int veces = this.indice.getOrDefault(palabra, 0);
                         // si la clave esta en el indice cambia su valor y si no está la añade
                         this.indice.put(palabra, veces + 1);
                    }
               }
          }
     }

     @Override
     public void presentarIndice (PrintWriter printWriter){
          for(Map.Entry<String, Integer> entrada : this.indice.entrySet()){
               printWriter.println(entrada.getKey() + "\t" + entrada.getValue());
          }
     }
}
