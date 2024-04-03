package co.edu.uniquindio.estructuras.laboratoriocolas;



import co.edu.uniquindio.estructuras.laboratoriocolas.clases.Cola;
import co.edu.uniquindio.estructuras.laboratoriocolas.clases.Oveja;

public class Establo {
	
	public static void main (String []args) {
		Cola<Oveja> rebanio = new Cola<Oveja>();
		/*rebanio.encolar(new Oveja("Pepa", 43));
		rebanio.encolar(new Oveja("Ana", 22));
		rebanio.encolar(new Oveja("Royer", 12));
		rebanio.encolar(new Oveja("Londgav", 55));
		rebanio.encolar(new Oveja("Ama", 66));*/
		
		rebanio.encolar(new Oveja("Royer", 22));
		rebanio.encolar(new Oveja("Londgav", 33));
		rebanio.encolar(new Oveja("Ama", 24));
		
		System.out.println(rebanio.getSize());
		//imprimirCola(rebanio);
		
		/*Cola <Oveja> result= ordenarOvejas(rebanio);
		imprimirCola(result);*/
		
		ordenarColaPorPeso(rebanio);
		imprimirCola(rebanio);
	}
	
	public static void imprimirCola(Cola<Oveja> ovejas) {
		while(ovejas.isLLena()) {
			System.out.println(ovejas.desencolar().toString());
			
		}
	}
	
	
	
	/*
	public static void ordenarColaPorPeso(Cola<Oveja> cola) {
        Cola<Oveja> colaAux = new Cola<>();

        while (!cola.isVacia()) {
            Oveja oveja = cola.desencolar();
            if (colaAux.isVacia() || oveja.getPeso() <= colaAux.getHead().getValue().getPeso()) {
                colaAux.encolar(oveja);
            } else {
                while (!colaAux.isVacia() && oveja.getPeso() > colaAux.getHead().getValue().getPeso()) {
                    cola.encolar(oveja);
                }
                colaAux.encolar(oveja);
            }
        }

        while (!colaAux.isVacia()) {
            cola.encolar(colaAux.desencolar());
        }
    }*/
	public static void ordenarColaPorPeso(Cola<Oveja> cola) {
        Cola<Oveja> colaLivianas = new Cola<>();
        Cola<Oveja> colaPesadas = new Cola<>();

        while (!cola.isVacia()) {
            Oveja oveja = cola.desencolar();
            if (oveja.getPeso() < 50) {
                insertarOrdenado(colaLivianas, oveja);
            } else {
                insertarOrdenado(colaPesadas, oveja);
            }
        }

        // Vaciar las colas auxiliares en la cola original
        while (!colaLivianas.isVacia()) {
            cola.encolar(colaLivianas.desencolar());
        }
        while (!colaPesadas.isVacia()) {
            cola.encolar(colaPesadas.desencolar());
        }
    }

	private static void insertarOrdenado(Cola<Oveja> cola, Oveja oveja) {
        // Si la cola está vacía o la oveja actual es más liviana que la primera oveja de la cola
        if (cola.isVacia() || oveja.getPeso() > cola.getHead().getValue().getPeso()) {
            cola.encolar(oveja);
        } else {
            // Buscar la posición adecuada para insertar la oveja manteniendo el orden
            Cola<Oveja> colaTemp = new Cola<>();
            while (!cola.isVacia() && cola.getHead().getValue().getPeso() >= oveja.getPeso()) {
                colaTemp.encolar(cola.desencolar());
            }
            cola.encolar(oveja);
            while (!colaTemp.isVacia()) {
                cola.encolar(colaTemp.desencolar());
            }
        }
    
    }
    
    
    public static Cola<Oveja> ordenarOvejas (Cola<Oveja> colaOvejas){
		Cola<Oveja> result= new Cola<Oveja>();
		int tamOriginal= colaOvejas.getSize();
		result.encolar(colaOvejas.desencolar());
		
		while(true) {
			int cont= result.getSize();
			if(cont==tamOriginal) {
				break;
			}
			Oveja ovejaOriginalAux= colaOvejas.desencolar();
			Oveja ovejaOrdenadaAux= result.desencolar();
			if(ovejaOrdenadaAux.compareTo(ovejaOriginalAux)>0) {
				result.encolar(ovejaOriginalAux);
				colaOvejas.encolar(ovejaOrdenadaAux);
			}else if(ovejaOrdenadaAux.compareTo(ovejaOriginalAux)<0){
				colaOvejas.encolar(ovejaOriginalAux);
				result.encolar(ovejaOrdenadaAux);
			}else {
				result.encolar(ovejaOrdenadaAux);
				result.encolar(ovejaOriginalAux);
			}
		}
		return result;
		
	}
	

}
