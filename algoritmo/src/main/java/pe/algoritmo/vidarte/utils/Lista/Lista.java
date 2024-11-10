package pe.algoritmo.vidarte.utils.Lista;

import java.util.Iterator;

public class Lista<T> implements Iterable<T> {
    private Nodo head; // Referencia al primer nodo de la lista
    private int length;

    // Constructor para inicializar la lista vacía
    public Lista() {
        this.head = null;
        this.length = 0;
    }

    // Método para agregar un nodo al inicio de la lista
    public void agregarAlInicio(T data) {
        Nodo nuevoNodo = new Nodo(data);
        nuevoNodo.next = head;
        head = nuevoNodo;
        length++;
    }

    // Método para agregar un nodo al final de la lista
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

    // Método para eliminar el primer nodo de la lista
    public void eliminarAlInicio() {
        if (head != null) {
            head = head.next;
            length--;
        } else {
            System.out.println("La lista está vacía");
        }
    }

    // Método para imprimir los elementos de la lista
    public void imprimirLista() {
        Nodo actual = head;
        while (actual != null) {
            System.out.print(actual.data + " -> ");
            actual = actual.next;
        }
        System.out.println("null"); // Indica el final de la lista
    }

    // Tamaño de la lista
    public int size() {
        return length;
    }

    // Funcion que devuelve el elemento de la lista
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

    // Implementación de la interfaz Iterable
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

    // Clase nodo para la Lista
    private class Nodo {
        T data;
        Nodo next;

        // Constructor para inicializar el nodo
        public Nodo(T data) {
            this.data = data;
            this.next = null;
        }
    }
}