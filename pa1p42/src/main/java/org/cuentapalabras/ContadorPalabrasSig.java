package org.cuentapalabras;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ContadorPalabrasSig extends ContadorPalabras{

     private List<String> noSignificativas;

     public ContadorPalabrasSig (){
          super();
          this.noSignificativas = new ArrayList<>();
     }

     public void leeArrayNoSig(String[] palabrasNoSignificativas) {
          this.noSignificativas.clear();
          for(String palabraNoSignificativa : palabrasNoSignificativas){
               if(palabraNoSignificativa !=null && !palabraNoSignificativa.isEmpty())
                    this.noSignificativas.add(palabraNoSignificativa.toUpperCase());
          }
     }

     public void leeFicheroNoSig(String nombreFichero, String delimitadores) throws IOException {
          this.noSignificativas.clear();
          Path rutaFichero = Path.of(nombreFichero);
          try(BufferedReader bufferedReader = Files.newBufferedReader(rutaFichero)){
               String lineaFichero = bufferedReader.readLine();
               while (lineaFichero != null){
                    anyadePalabrasNoSignificativas(lineaFichero, delimitadores);
                    lineaFichero = bufferedReader.readLine();
               }
          }
     }

     private void anyadePalabrasNoSignificativas(String linea, String delimitadores){
          String[] palabrasNoSignificativasLinea = linea.split(delimitadores);
          for(String palabraNoSignificativa : palabrasNoSignificativasLinea){
               if(palabraNoSignificativa !=null && !palabraNoSignificativa.isEmpty())
                    this.noSignificativas.add(palabraNoSignificativa.toUpperCase());
          }
     }

     @Override
     protected void incluye(String palabra){
          if(!this.noSignificativas.contains(palabra.toUpperCase())){
               super.incluye(palabra.toUpperCase());
          }
     }
}
