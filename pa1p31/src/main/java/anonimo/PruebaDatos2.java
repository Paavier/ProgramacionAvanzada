package anonimo;

import datos2.Datos;
import datos2.DatosException;

import java.util.Arrays;

public class PruebaDatos2 {
    public static void main(String[] args) {
        try {
            if (args.length < 3)
                throw new DatosException("Error, no hay valores suficientes");

            double min = Double.parseDouble(args[0]);
            double max = Double.parseDouble(args[1]);

            String[] valores = Arrays.copyOfRange(args, 2, args.length);

            Datos datos = new Datos(valores, min, max);

            System.out.println(datos);

            datos.setRango("0;4");
            System.out.println(datos);

            datos.setRango("15 25");
            System.out.println(datos);

        } catch (NumberFormatException e) {
            System.out.println("Error, al convertir un valor a número real (" + e.getMessage() + ")");
        } catch (DatosException e) {
            System.out.println(e.getMessage());
        }
    }
}
