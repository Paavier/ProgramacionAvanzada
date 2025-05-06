package org.indices;

import java.util.ArrayList;
import java.util.List;

public abstract class IndiceAbstracto implements Indice{
     protected List<String> texto;

     public IndiceAbstracto(){
          this.texto = new ArrayList<>();
     }

     @Override
     public void agregarFrase(String frase){
          this.texto.add(frase);
     }
}
