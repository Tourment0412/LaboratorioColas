package co.edu.uniquindio.estructuras.laboratoriocolas.provisional;

public class SimpleNode<E> {

	private E value;
	private SimpleNode<E> next;
	private SimpleNode <E> prev;

	public SimpleNode(E valor) {
		this.value = valor;
		this.next = null;
		this.prev=null;
	}
	
	

	public SimpleNode(SimpleNode<E> prev,E value, SimpleNode<E> next ) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}



	public SimpleNode<E> getPrev() {
		return prev;
	}



	public void setPrev(SimpleNode<E> prev) {
		this.prev = prev;
	}



	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public SimpleNode<E> getNext() {
		return next;
	}

	public void setNext(SimpleNode<E> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return next != null ? String.format("%s, %s", value, next) : value.toString();
	}

}
