package co.edu.uniquindio.estructuras.laboratoriocolas;

import co.edu.uniquindio.estructuras.laboratoriocolas.clases.Cola;
import co.edu.uniquindio.estructuras.laboratoriocolas.clases.Oveja;

public class Establo {

	public static void main(String[] args) {

		Cola<Oveja> rebanio = new Cola<Oveja>();
		rebanio.encolar(new Oveja("Pepa", 43));
		rebanio.encolar(new Oveja("Ana", 22));
		rebanio.encolar(new Oveja("Royer", 12));
		rebanio.encolar(new Oveja("Londgav", 55));
		rebanio.encolar(new Oveja("Ama", 66));
		rebanio.encolar(new Oveja("Lola", 10));
		rebanio.encolar(new Oveja("Juan", 25));
		rebanio.encolar(new Oveja("Ron", 40));
		rebanio.encolar(new Oveja("Herminio", 59));

		System.out.println(rebanio.getSize());

		ordenarColaPorPeso(rebanio);
		imprimirCola(rebanio);

	}

	public static void imprimirCola(Cola<Oveja> ovejas) {
		while (ovejas.isLLena()) {
			System.out.println(ovejas.desencolar().toString());

		}
	}

	public static void ordenarColaPorPeso(Cola<Oveja> cola) {
		Cola<Oveja> colaAux = new Cola<>();

		while (!cola.isVacia()) {
			Oveja oveja = cola.desencolar();
			insertarOrdenado(colaAux, oveja);
		}
		while (!colaAux.isVacia()) {
			cola.encolar(colaAux.desencolar());
		}
	}

	private static void insertarOrdenado(Cola<Oveja> cola, Oveja oveja) {

		// Buscar la posición adecuada para insertar la oveja manteniendo el orden
		Cola<Oveja> colaTemp = new Cola<>();
		while (!cola.isVacia() && cola.getHead().getValue().getPeso() < oveja.getPeso()) {
			colaTemp.encolar(cola.desencolar());
		}

		colaTemp.encolar(oveja);
		while (!cola.isVacia()) {
			colaTemp.encolar(cola.desencolar());
		}

		while (!colaTemp.isVacia()) {
			cola.encolar(colaTemp.desencolar());
		}

	}

}
