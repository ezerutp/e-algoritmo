package pe.algoritmo.vidarte.utils;

import java.util.Iterator;

public class Lista<T> implements Iterable<T>{
    private Nodo<T> head; // Referencia al primer nodo de la lista

    // Constructor para inicializar la lista vacía
    public Lista() {
        this.head = null;
    }

    // Método para agregar un nodo al inicio de la lista
    public void agregarAlInicio(T data) {
        Nodo<T> nuevoNodo = new Nodo<>(data);
        nuevoNodo.next = head;
        head = nuevoNodo;
    }

    // Método para agregar un nodo al final de la lista
    public void agregarAlFinal(T data) {
        Nodo<T> nuevoNodo = new Nodo<>(data);
        if (head == null) { // Si la lista está vacía
            head = nuevoNodo;
        } else {
            Nodo<T> actual = head;
            while (actual.next != null) {
                actual = actual.next;
            }
            actual.next = nuevoNodo;
        }
    }

    // Método para eliminar el primer nodo de la lista
    public void eliminarAlInicio() {
        if (head != null) {
            head = head.next;
        } else {
            System.out.println("La lista está vacía");
        }
    }

    // Método para imprimir los elementos de la lista
    public void imprimirLista() {
        Nodo<T> actual = head;
        while (actual != null) {
            System.out.print(actual.data + " -> ");
            actual = actual.next;
        }
        System.out.println("null"); // Indica el final de la lista
    }

    // Implementación de la interfaz Iterable
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> actual = head;

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
}
