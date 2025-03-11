package datos2;

import java.util.ArrayList;
import java.util.List;

public class Datos {

    private List<Double> datos;
    private List<String> errores;
    private double min;
    private double max;

    public Datos(String[] datos, double min, double max){
        this.datos = new ArrayList<>();
        this.errores = new ArrayList<>();
        this.min = min;
        this.max = max;
        rellenarListas(datos);
    }

    private void rellenarListas(String[] datos){
        double numero;
        for(String numeroString : datos){
            try{
                numero = Double.parseDouble(numeroString);
                this.getDatos().add(numero);
            }catch (NumberFormatException e){
                this.getErrores().add(numeroString);
            }
        }
    }

    public double calcMedia() throws DatosException{
        List<Double> numerosEnRango = numerosEnRango();
        double sumaTotal = 0;

        if (numerosEnRango.size() == 0)
            throw new DatosException("No hay datos en el rango especificado");

        for (double numero : numerosEnRango){
            sumaTotal += numero;
        }

        return sumaTotal/numerosEnRango.size();
    }

    private List<Double> numerosEnRango(){
        List<Double> numerosEnRango = new ArrayList<>();

        for (double numero : this.getDatos()){
            if (numero >= this.min && numero <= this.max)
                numerosEnRango.add(numero);
        }

        return numerosEnRango;
    }

    public double calcDesvTipica() throws DatosException{
        List<Double> numerosEnRango = numerosEnRango();
        double sumaTotal = 0;
        double media = calcMedia();


        if (numerosEnRango.size() == 0)
            throw new DatosException("No hay datos en el rango especificado");

        for (double numero : numerosEnRango){
            sumaTotal += Math.pow((numero - media), 2);
        }

        return Math.sqrt(sumaTotal/numerosEnRango.size());
    }

    public void setRango(String rango) throws DatosException{
        int indicePuntoComa = rango.indexOf(';');
        if (indicePuntoComa == -1 || indicePuntoComa == 0 || indicePuntoComa == rango.length() - 1)
            throw new DatosException("Error en los datos al establecer el rango");

        try{
            this.min = Double.parseDouble(rango.substring(0, indicePuntoComa));
            this.max = Double.parseDouble(rango.substring(indicePuntoComa + 1));
        }catch (NumberFormatException e){
            throw new DatosException("Error en los datos al establecer el rango");
        }
    }

    public List<Double> getDatos(){
        return this.datos;
    }

    public List<String> getErrores(){
        return this.errores;
    }

    @Override
    public String toString(){
        String media = "ERROR";
        String DesvTipica = "ERROR";
        try{
            media = "" + this.calcMedia();
            DesvTipica = ""+ this.calcDesvTipica();
        }catch (DatosException e){};
        return "Min: " + this.min + ", Max: " + this.max + ", " + this.getDatos() + ", " + this.getErrores() +
                ", Media: " + media + ", DesvTipica: " + DesvTipica;
    }
}