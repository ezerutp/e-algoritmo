package pe.algoritmo.vidarte.utils;

public class Nodo <T> {
    T data;
    Nodo<T> next;

    // Constructor para inicializar el nodo
    public Nodo(T data) {
        this.data = data;
        this.next = null;
    }

    // Getters y Setters
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Nodo<T> getNext() {
        return this.next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }
}