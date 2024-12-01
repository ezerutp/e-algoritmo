package pe.algoritmo.vidarte.utils.Lista;

import java.util.Iterator;

/**
 * Clase Lista que implementa una lista enlazada genérica.
 * 
 * Esta clase proporciona métodos para agregar, eliminar y obtener elementos de la lista,
 * así como para imprimir la lista y obtener su tamaño.
 * 
 * @param <T> El tipo de los elementos de la lista.
 * @author Vidarte
 */ 
public class Lista<T> implements Iterable<T> {
    private Nodo head; // Referencia al primer nodo de la lista
    private int length;

    /**
     * Constructor para inicializar la lista vacía.
     */
    public Lista() {
        this.head = null;
        this.length = 0;
    }

    /**
     * Método para agregar un nodo al inicio de la lista.
     * 
     * @param data El elemento a agregar al inicio de la lista.
     */
    public void agregarAlInicio(T data) {
        Nodo nuevoNodo = new Nodo(data);
        nuevoNodo.next = head;
        head = nuevoNodo;
        length++;
    }

    /**
     * Método para agregar un nodo al final de la lista.
     * 
     * @param data El elemento a agregar al final de la lista.
     */
    public void agregarAlFinal(T data) {
        Nodo nuevoNodo = new Nodo(data);
        if (head == null) { // Si la lista está vacía
            head = nuevoNodo;
        } else {
            Nodo actual = head;
            while (actual.next != null) {
                actual = actual.next;
            }
            actual.next = nuevoNodo;
        }
        length++;
    }

    /**
     * Método para eliminar el primer nodo de la lista.
     */
    public void eliminarAlInicio() {
        if (head != null) {
            head = head.next;
            length--;
        } else {
            System.out.println("La lista está vacía");
        }
    }

    /**
     * Método para imprimir los elementos de la lista.
     */
    public void imprimirLista() {
        Nodo actual = head;
        while (actual != null) {
            System.out.print(actual.data + " -> ");
            actual = actual.next;
        }
        System.out.println("null"); // Indica el final de la lista
    }

    /**
     * Método para obtener el tamaño de la lista.
     * 
     * @return El tamaño de la lista.
     */
    public int size() {
        return length;
    }

    /**
     * Método para establecer un valor en una posición específica.
     * 
     * @param index El índice de la posición donde se establecerá el valor.
     * @param data El valor a establecer.
     */
    public void set(int index, T data) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Índice " + index + " está fuera de los límites");
        }

        Nodo actual = head;
        for (int i = 0; i < index; i++) {
            actual = actual.next;
        }
        actual.data = data;
    }

    /**
     * Método para obtener el elemento de la lista en una posición específica.
     * 
     * @param index El índice de la posición del elemento a obtener.
     * @return El elemento en la posición especificada.
     */
    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Índice " + index + " está fuera de los límites");
        }

        Nodo actual = head;
        for (int i = 0; i < index; i++) {
            actual = actual.next;
        }
        return actual.data;
    }

    public void remover(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            length--;
            return;
        }

        Nodo actual = head;
        while (actual.next != null) {
            if (actual.next.data.equals(data)) {
                actual.next = actual.next.next;
                length--;
                return;
            }
            actual = actual.next;
        }
    }   

    /**
     * Implementación de la interfaz Iterable para iterar sobre la lista.
     * 
     * @return Un iterador sobre la lista.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo actual = head;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                T data = actual.data;
                actual = actual.next;
                return data;
            }
        };
    }

    /**
     * Clase nodo para la Lista.
     * 
     * Esta clase representa un nodo individual de la lista, conteniendo el dato y una referencia al siguiente nodo.
     */
    private class Nodo {
        T data;
        Nodo next;

        /**
         * Constructor para inicializar el nodo.
         * 
         * @param data El dato a almacenar en el nodo.
         */
        public Nodo(T data) {
            this.data = data;
            this.next = null;
        }
    }
}