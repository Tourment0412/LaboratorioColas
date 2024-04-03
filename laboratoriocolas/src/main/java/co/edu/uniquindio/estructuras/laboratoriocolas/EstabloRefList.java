package co.edu.uniquindio.estructuras.laboratoriocolas;

import co.edu.uniquindio.estructuras.laboratoriocolas.clases.Oveja;
import co.edu.uniquindio.estructuras.laboratoriocolas.provisional.ColaRefList;

public class EstabloRefList {

	public static void main(String[] args) {
		ColaRefList<Oveja> rebanio = new ColaRefList<Oveja>();

		rebanio.addLast(new Oveja("Pepa", 43));
		rebanio.addLast(new Oveja("Ana", 22));
		rebanio.addLast(new Oveja("Royer", 12));
		rebanio.addLast(new Oveja("Londgav", 55));
		rebanio.addLast(new Oveja("Ama", 66));
		rebanio.addLast(new Oveja("Lola", 10));
		rebanio.addLast(new Oveja("Juan", 25));
		rebanio.addLast(new Oveja("Ron", 40));
		rebanio.addLast(new Oveja("Herminio", 59));

		System.out.println(rebanio.getSize());
		
		ordenarColaPorPesoRef(rebanio);
		imprimirColaRefList(rebanio);

	}
	
	public static void imprimirColaRefList(ColaRefList<Oveja> ovejas) {
		while (ovejas.isLLena()) {
			System.out.println(ovejas.removeFirst().toString());

		}
	}
	
	public static void ordenarColaPorPesoRef(ColaRefList<Oveja> cola) {
		ColaRefList<Oveja> colaAux = new ColaRefList<>();

		while (!cola.isVacia()) {
			Oveja oveja = cola.desencolar();
			insertarOrdenadoRefList(colaAux, oveja);
		}
		while (!colaAux.isVacia()) {
			cola.encolar(colaAux.desencolar());
		}
	}

	private static void insertarOrdenadoRefList(ColaRefList<Oveja> cola, Oveja oveja) {

		// Buscar la posición adecuada para insertar la oveja manteniendo el orden
		ColaRefList<Oveja> colaTemp = new ColaRefList<>();
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
