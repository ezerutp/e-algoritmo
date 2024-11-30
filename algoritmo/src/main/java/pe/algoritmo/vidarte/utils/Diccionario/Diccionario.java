package pe.algoritmo.vidarte.utils.Diccionario;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase Diccionario que implementa un diccionario hash para almacenar pares clave-valor.
 * 
 * Ahora es iterable, permitiendo recorrer los valores usando un bucle for-each.
 * 
 * @param <K> El tipo de la clave.
 * @param <V> El tipo del valor.
 */
public class Diccionario<K, V> implements Iterable<V> {
    private static final int capacidad = 100; // Capacidad inicial del arreglo de nodos.
    private static final double reload = 0.75; // Factor de carga para redimensionar el arreglo.
    private Nodo<K, V>[] nodos; // Arreglo de nodos.
    private int size = 0; // Tamaño actual del diccionario.

    @SuppressWarnings("unchecked")
    public Diccionario() {
        nodos = new Nodo[capacidad];
    }

    private int hash(K clave) {
        return Math.abs(clave.hashCode() % nodos.length);
    }

    public V get(K clave) {
        int index = hash(clave);
        Nodo<K, V> actual = nodos[index];
        
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.valor;
            }
            actual = actual.next;
        }
        return null;
    }

    public void put(K clave, V valor) {
        if (size >= nodos.length * reload) {
            resize();
        }

        int index = hash(clave);
        Nodo<K, V> nuevoNodo = new Nodo<>(clave, valor);

        if (nodos[index] == null) {
            nodos[index] = nuevoNodo;
        } else {
            Nodo<K, V> actual = nodos[index];
            while (actual != null) {
                if (actual.clave.equals(clave)) {
                    actual.valor = valor;
                    return;
                }
                if (actual.next == null) break;
                actual = actual.next;
            }
            actual.next = nuevoNodo;
        }
        size++;
    }

    public V remove(K clave) {
        int index = hash(clave);
        Nodo<K, V> actual = nodos[index];
        Nodo<K, V> prev = null;

        while (actual != null) {
            if (actual.clave.equals(clave)) {
                if (prev == null) {
                    nodos[index] = actual.next;
                } else {
                    prev.next = actual.next;
                }
                size--;
                return actual.valor;
            }
            prev = actual;
            actual = actual.next;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Nodo<K, V>[] oldNodos = nodos;
        nodos = new Nodo[oldNodos.length * 2];
        size = 0;

        for (Nodo<K, V> nodo : oldNodos) {
            while (nodo != null) {
                put(nodo.clave, nodo.valor);
                nodo = nodo.next;
            }
        }
    }

    private static class Nodo<K, V> {
        K clave;
        V valor;
        Nodo<K, V> next;

        public Nodo(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
            this.next = null;
        }
    }

    /**
     * Implementación del método iterator para recorrer los valores.
     * 
     * @return Un iterador que recorre todos los valores en el diccionario.
     */
    @Override
    public Iterator<V> iterator() {
        return new DiccionarioIterator();
    }

    /**
     * Iterador para recorrer los valores del diccionario.
     */
    private class DiccionarioIterator implements Iterator<V> {
        private int index = 0;
        private Nodo<K, V> current = null;

        public DiccionarioIterator() {
            avanzarAlSiguiente();
        }

        private void avanzarAlSiguiente() {
            while (index < nodos.length && current == null) {
                current = nodos[index++];
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            V valor = current.valor;
            current = current.next;
            if (current == null) {
                avanzarAlSiguiente();
            }
            return valor;
        }
    }
}
