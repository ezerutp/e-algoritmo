package pe.algoritmo.vidarte.utils.Diccionario;

/**
 * Clase Diccionario que implementa un diccionario hash para almacenar pares clave-valor.
 * 
 * Esta clase utiliza un arreglo de nodos para almacenar los pares clave-valor. Cada nodo
 * contiene una clave, un valor y una referencia al siguiente nodo en la lista. El
 * diccionario utiliza un hash para determinar el índice del arreglo donde se almacena
 * cada par clave-valor.
 * 
 * @param <K> El tipo de la clave.
 * @param <V> El tipo del valor.
 * @author Vidarte
 */

public class Diccionario<K, V> {
    private static final int capacidad = 100; // Capacidad inicial del arreglo de nodos.
    private static final double reload = 0.75; // Factor de carga para redimensionar el arreglo.
    private Nodo<K, V>[] nodos; // Arreglo de nodos.
    private int size = 0; // Tamaño actual del diccionario.

    /**
     * Constructor de la clase Diccionario.
     * 
     * Inicializa el arreglo de nodos con la capacidad especificada.
     */
    @SuppressWarnings("unchecked")
    public Diccionario() {
        nodos = new Nodo[capacidad];
    }

    /**
     * Calcula el índice del arreglo basado en la clave.
     * 
     * Utiliza el código hash de la clave para calcular el índice del arreglo.
     * 
     * @param clave La clave para calcular el índice.
     * @return El índice del arreglo.
     */
    private int hash(K clave) {
        return Math.abs(clave.hashCode() % nodos.length);
    }

    /**
     * Obtiene el valor asociado a una clave.
     * 
     * Busca el valor asociado a una clave específica en el diccionario.
     * 
     * @param clave La clave del valor a buscar.
     * @return El valor asociado a la clave si existe, de lo contrario devuelve null.
     */
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

    /**
     * Inserta o actualiza un par clave-valor en el diccionario.
     * 
     * Si el diccionario está cerca de alcanzar su capacidad, se redimensiona. Luego,
     * busca el índice adecuado para insertar o actualizar el par clave-valor.
     * 
     * @param clave La clave del par.
     * @param valor El valor del par.
     */
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

    /**
     * Elimina un par clave-valor del diccionario.
     * 
     * Busca el par clave-valor especificado y lo elimina del diccionario.
     * 
     * @param clave La clave del par a eliminar.
     * @return El valor eliminado si existe, de lo contrario devuelve null.
     */
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

    /**
     * Redimensiona el arreglo de nodos.
     * 
     * Duplica la capacidad del arreglo de nodos y reinserta todos los pares clave-valor.
     */
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

    /**
     * Clase Nodo que representa un par clave-valor.
     * 
     * Esta clase contiene una clave, un valor y una referencia al siguiente nodo.
     * 
     * @param <K> El tipo de la clave.
     * @param <V> El tipo del valor.
     */
    private static class Nodo<K, V> {
        K clave;
        V valor;
        Nodo<K, V> next;

        /**
         * Constructor de la clase Nodo.
         * 
         * Inicializa la clave y el valor del nodo.
         * 
         * @param clave La clave del nodo.
         * @param valor El valor del nodo.
         */
        public Nodo(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
            this.next = null;
        }
    }
}
