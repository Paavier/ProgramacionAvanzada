package org.cuentapalabras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringJoiner;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContadorPalabras {

     private List<PalabraEnTexto> palabras;

     public ContadorPalabras(){
          this.palabras = new ArrayList<>();
     }

     private int esta(String palabra){
          int posicion = -1;
          boolean encontrada = false;
          PalabraEnTexto auxiliar = new PalabraEnTexto(palabra);

          for (int i = 0; i< this.palabras.size() && !encontrada; i++){
               if(this.palabras.get(i).equals(auxiliar)){
                    encontrada = true;
                    posicion = i;
               }
          }

          return posicion;
     }

     protected void incluye(String palabra){
          if(palabra == null || palabra.isEmpty())
               return;

          int posicion = esta(palabra);
          if (posicion == -1){
               this.palabras.add(new PalabraEnTexto(palabra));
          }else{
              this.palabras.get(posicion).incrementa();
          }
     }

     private void incluyeTodas(String linea, String delimitadores){
          String[] palabrasLinea = linea.split(delimitadores);
          for(String palabra : palabrasLinea){
               incluye(palabra);
          }
     }

     public void incluyeTodas(String[] texto, String delimitadores){
          for(String lineaTexto : texto){
               incluyeTodas(lineaTexto, delimitadores);
          }
     }

     public void incluyeTodasFichero (String nombreFichero, String delimitadores) throws IOException {
          Path rutaFichero = Path.of(nombreFichero);
          try(BufferedReader bufferedReader = Files.newBufferedReader(rutaFichero)){
               String lineaFichero = bufferedReader.readLine();
               while(lineaFichero != null){
                    incluyeTodas(lineaFichero, delimitadores);
                    lineaFichero = bufferedReader.readLine();
               }
          }
     }

     public PalabraEnTexto encuentra(String palabra){
          int posicion = esta(palabra);
          if (posicion == -1)
               throw new NoSuchElementException();
          return this.palabras.get(posicion);
     }

     @Override
     public String toString(){
          StringJoiner listaPalabras = new StringJoiner(" - ", "[", "]");
          for (PalabraEnTexto palabra : this.palabras){
               listaPalabras.add(palabra.toString());
          }
          return listaPalabras.toString();
     }

     public void presentaPalabras(String fichero) throws FileNotFoundException {
          try (PrintWriter printWriter = new PrintWriter(fichero)){
               presentaPalabras(printWriter);
          }
     }

     public void presentaPalabras (PrintWriter printWriter){
          for(PalabraEnTexto palabraEnTexto : this.palabras){
               printWriter.println(palabraEnTexto.toString());
          }
     }
}
