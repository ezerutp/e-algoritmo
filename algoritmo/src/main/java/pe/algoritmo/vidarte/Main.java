package pe.algoritmo.vidarte;

import java.util.LinkedHashSet;
import java.util.Set;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Elecciones;
import pe.algoritmo.vidarte.utils.Lista;

public class Main {
    public static void main(String[] args) {
        
        CSV<Elecciones> micsv = new CSV<>(Elecciones.class);
        Lista<Elecciones> listita = micsv.leerCSV();
        Set<String> datosUnicos = new LinkedHashSet<>();

        int counter = 1;

        for (Elecciones e : listita) {
            String jijiji = e.getDistrito() + ";" + e.getSeccion() + ";" + e.getMesa();
            datosUnicos.add(jijiji);
        }

        for (String string : datosUnicos) {
            System.out.println(counter + ";" + string);
            counter += 1;
        }

    }
}