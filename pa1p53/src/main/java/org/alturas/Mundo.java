package org.alturas;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Mundo {

    private List<Pais> paises;

    public Mundo (){
        this.paises = new ArrayList<>();
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void cargar(String nombreFichero) throws IOException{
        Pais pais;
        String[] datosPais;
        String linea;

        Path rutaFichero = Path.of(nombreFichero);
        try(BufferedReader bufferedReader = Files.newBufferedReader(rutaFichero)){
            linea = bufferedReader.readLine();
            while(linea != null){
                try{
                    datosPais = linea.split(",");
                    pais = new Pais(datosPais[0], datosPais[1], Double.parseDouble(datosPais[2]));
                    this.paises.add(pais);
                }catch (NumberFormatException | ArrayIndexOutOfBoundsException ignore){
                    //ignoradas
                }

                linea = bufferedReader.readLine();
            }
        }
    }

    public static <K,V> void presentaEnConsola(Map<K,V> map){
        for(Map.Entry<K,V> entrada : map.entrySet()){
            System.out.println(entrada.getKey() + " " + entrada.getValue());
        }
    }

    public SortedMap<String, Integer> numeroDePaisesPorContinente(){
        SortedMap<String, Integer> paisesPorContinente = new TreeMap<>();
        int numeroPaises;

        for(Pais pais : this.paises){
            numeroPaises = paisesPorContinente.getOrDefault(
                    pais.getContinente(),
                    0
            );

            paisesPorContinente.put(pais.getContinente(), numeroPaises + 1);
        }

        return paisesPorContinente;
    }

    public SortedMap<Double, List<Pais>> paisesPorAltura(){
        SortedMap<Double, List<Pais>> paisesPorAltura = new TreeMap<>();
        List<Pais> paisesConDeterminadaAltura;
        double alturaPais;

        for(Pais pais : this.paises){
            alturaPais = Math.floor(pais.getAltura()*10.0) / 10.0;
            paisesConDeterminadaAltura = paisesPorAltura.getOrDefault(
                    alturaPais,
                    new ArrayList<>()
            );

            paisesConDeterminadaAltura.add(pais);
            paisesPorAltura.put(alturaPais, paisesConDeterminadaAltura);
        }

        return paisesPorAltura;
    }

    public SortedMap<String, SortedSet<Pais>> paisesPorContinente(){
        SortedMap<String, SortedSet<Pais>> paisesPorContinente = new TreeMap<>();
        SortedSet<Pais> paisesDelContinente;

        for(Pais pais : this.paises){
            paisesDelContinente = paisesPorContinente.getOrDefault(
                    pais.getContinente(),
                    new TreeSet<>()
            );

            paisesDelContinente.add(pais);
            paisesPorContinente.put(pais.getContinente(), paisesDelContinente);
        }

        return paisesPorContinente;
    }

    public SortedSet<Pais> paisesOrdenadosPorAltura(){
        SortedSet<Pais> paisesOrdenados = new TreeSet<>(new CompAltura());
        paisesOrdenados.addAll(this.paises);
        return paisesOrdenados;
    }

    public SortedMap<String, SortedSet<Pais>> paisesPorContinenteAltura(){
        SortedMap<String, SortedSet<Pais>> paisesPorContinente = new TreeMap<>();
        SortedSet<Pais> paisesDelContinenteOrdenados;

        for(Pais pais : this.paises){
            paisesDelContinenteOrdenados = paisesPorContinente.getOrDefault(
                    pais.getContinente(),
                    new TreeSet<>(new CompAltura())
            );

            paisesDelContinenteOrdenados.add(pais);
            paisesPorContinente.put(pais.getContinente(), paisesDelContinenteOrdenados);
        }

        return paisesPorContinente;
    }

    public SortedMap<String, SortedSet<Pais>> paisesPorContinenteAlturaDec(){
        SortedMap<String, SortedSet<Pais>> paisesPorContinente = new TreeMap<>();
        SortedSet<Pais> paisesDelContinenteOrdenados;

        for(Pais pais : this.paises){
            paisesDelContinenteOrdenados = paisesPorContinente.getOrDefault(
                    pais.getContinente(),
                    new TreeSet<>(new CompAltura().reversed())
            );

            paisesDelContinenteOrdenados.add(pais);
            paisesPorContinente.put(pais.getContinente(), paisesDelContinenteOrdenados);
        }

        return paisesPorContinente;
    }

    public SortedMap<Character, SortedSet<Pais>> paisesPorInicial(){
        SortedMap<Character, SortedSet<Pais>> paisesPorInicial = new TreeMap<>();
        SortedSet<Pais> paisesOrdenados;

        for(Pais pais : this.paises){
            paisesOrdenados = paisesPorInicial.getOrDefault(
                    pais.getNombre().charAt(0),
                    new TreeSet<>()
            );
            paisesOrdenados.add(pais);
            paisesPorInicial.put(pais.getNombre().charAt(0), paisesOrdenados);
        }

        return paisesPorInicial;
    }

    public SortedMap<String, Double> mediaPorContinente() {
        SortedMap<String, Double> mediaPorContinente = new TreeMap<>();
        SortedMap<String, SortedSet<Pais>> paisesPorContinente = paisesPorContinente();
        double media;

        for(Map.Entry<String, SortedSet<Pais>> entrada : paisesPorContinente.entrySet()){
            media = calcularMedia(entrada.getValue());
            mediaPorContinente.put(entrada.getKey(), media);
        }

        return mediaPorContinente;
    }

    private double calcularMedia(SortedSet<Pais> conjuntoPaises){
        double total = 0;

        for(Pais pais : conjuntoPaises){
            total += pais.getAltura();
        }

        return total/conjuntoPaises.size();
    }

    public List<String> continentesConMasPaises() {
        List<String> continentesConMasPaises = new ArrayList<>();
        Map<String, Integer> numeroDePaisesPorContinente = numeroDePaisesPorContinente();

        int mayorNumeroDePaises = Collections.max(numeroDePaisesPorContinente.values());

        for (Map.Entry<String, Integer> entrada : numeroDePaisesPorContinente.entrySet()) {
            if (entrada.getValue() == mayorNumeroDePaises) {
                continentesConMasPaises.add(entrada.getKey());
            }
        }

        return continentesConMasPaises;
    }
}
