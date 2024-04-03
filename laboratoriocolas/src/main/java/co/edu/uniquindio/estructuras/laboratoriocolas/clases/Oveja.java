package co.edu.uniquindio.estructuras.laboratoriocolas.clases;

public class Oveja implements Comparable<Oveja>{
	
	private String nombre;
	private Double peso;
	
	
	
	public Oveja(String nombre, double peso) {
		super();
		this.nombre = nombre;
		this.peso = peso;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public double getPeso() {
		return peso;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}



	@Override
	public int compareTo(Oveja o) {
		return this.peso.compareTo(o.getPeso());
	}



	@Override
	public String toString() {
		return "Oveja [nombre=" + nombre + ", peso=" + peso + "]";
	}
	
	

}
