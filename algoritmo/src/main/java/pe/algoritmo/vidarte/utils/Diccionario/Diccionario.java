package pe.algoritmo.vidarte.utils.Diccionario;

public class Diccionario<K, V> {
    private static final int capacidad = 100;
    private static final double reload = 0.75;
    private Nodo<K, V>[] nodos;
    private int size = 0;

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

        //volvemos a insertar los datos al nuevo array
        for (Nodo<K, V> nodo : oldNodos) {
            while (nodo != null) {
                put(nodo.clave, nodo.valor);
                nodo = nodo.next;
            }
        }
    }

    // Clase Nodo
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
}
