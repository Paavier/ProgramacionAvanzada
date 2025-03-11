import jarras.Mesa; // para crear el objeto y los metodos no estaticos
import static jarras.Mesa.Posicion.*; // para poder usar el enum

public class EjemploUsoMesa1 {

	public static void main(String[] args) {
		Mesa mesa = new Mesa(7, 5);
		mesa.llena(Derecha);
		System.out.println(mesa);
		mesa.llenaDesde(Derecha);
		System.out.println(mesa);
		mesa.llena(Derecha);
		System.out.println(mesa);
		mesa.llenaDesde(Derecha);
		System.out.println(mesa);
		mesa.vacia(Izquierda);
		System.out.println(mesa);
		mesa.llenaDesde(Derecha);
		System.out.println(mesa);
		mesa.llena(Derecha);
		System.out.println(mesa);
		mesa.llenaDesde(Derecha);
		System.out.println(mesa);
	}
}
