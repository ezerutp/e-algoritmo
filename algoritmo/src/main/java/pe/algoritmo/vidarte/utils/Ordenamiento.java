package pe.algoritmo.vidarte.utils;

import pe.algoritmo.vidarte.utils.Lista.*;
import java.util.function.BiPredicate;

public class Ordenamiento {

    public static <T> Lista<T> burbuja(Lista<T> lista, BiPredicate<T,T> predicado){
        
        int tamaño = lista.size();
        
        for(int i = 0; i < tamaño - 1; i++){
            for(int j = 0; j < tamaño - i - 1; j++){
                if(predicado.test(lista.get(j), lista.get(j+1))){
                    //Si es verdadero intercambiamos
                    T tmp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, tmp);
                }
            }
        }

        return lista;
    }
}