package co.edu.uniquindio.estructuras.laboratoriocolas.provisional;

import java.util.NoSuchElementException;


public class ColaRefList <E> {
	
	
	private SimpleNode<E> head;
	private SimpleNode <E> tail;
	private int size;
	
	
	public ColaRefList() {
		this.head=null;
		this.tail=null;
		this.size=0;
	}
	
	public void encolar(E value) {
		SimpleNode<E> nuevoNodo = new SimpleNode<>(value);
        if (isVacia()) {
            head = nuevoNodo;
        } else {
            tail.setNext(nuevoNodo);
        }
        tail = nuevoNodo;
        size++;
	}
	
	/*
	 * SimpleNode<E> current= new SimpleNode<>(value);
		if(tail==null) {
			tail= current;
			head= current;
			size++;
			return;
		}
		tail.setNext(current);
		tail=current;
		size++;
	 */
	
	
	/**
	 * Es importante retornar el elemento primero, por que para saber que elementos hay en la cola hay que 
	 * desencolar, por lo que se ve
	 * @return aux, valor del nodo primero o cabeza
	 */
	public E desencolar() {
		if (isVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        E dato = head.getValue();
        head = head.getNext();
        size--;
        if (head == null) {
            tail = null;
        }
        return dato;
	}
	
	public boolean isVacia() {
		return head==null;
	}
	
	public boolean isLLena() {
		return head!=null;
	}
	
	public SimpleNode<E> getHead(){
		return head;
	}
	public int size() {
		return size;
	}
	
	public ColaRefList<E> copyOf(){
		ColaRefList<E> cola= new ColaRefList<>();
		if(this.head==null) {
			return cola;
		}
		cola.head= this.head;
		cola.tail=this.tail;
		cola.size= this. size;
		return cola;
	}

	public SimpleNode<E> getTail() {
		return tail;
	}

	public void setTail(SimpleNode<E> tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setHead(SimpleNode<E> head) {
		this.head = head;
	}
	
	 void linkLast(E e) {
	        final SimpleNode<E> l = tail;
	        final SimpleNode<E> newNode = new SimpleNode<E>(l, e, null);
	        tail = newNode;
	        if (l == null)
	            head = newNode;
	        else
	            l.setNext(newNode);
	        size++;
	        
	    }
	 
	 public void addLast(E e) {
	        linkLast(e);
	    }
	 
	 public E removeFirst() {
	        final SimpleNode<E> f = head;
	        if (f == null)
	            throw new NoSuchElementException();
	        return unlinkFirst(f);
	    }
	 
	 private E unlinkFirst(SimpleNode<E> f) {
	        // assert f == first && f != null;
	        final E element = f.getValue();
	        final SimpleNode<E> next = f.getNext();
	        f.setValue(null);
	        f.setNext(null); 
	        head = next;
	        if (next == null)
	            tail = null;
	        else
	            next.setPrev(null);
	        size--;
	      
	        return element;
	    }
	
	
}
