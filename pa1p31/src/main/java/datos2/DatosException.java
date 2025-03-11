package datos2;

// las excepciones comprobadas heredan de Exception y las no comprobadas de RunTimeException
public class DatosException extends Exception{

    public DatosException(){
        super();
    }

    public DatosException(String mensaje){
        super(mensaje);
    }

}
