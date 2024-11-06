package pe.algoritmo.vidarte;

import pe.algoritmo.vidarte.controllers.VotacionController;
import pe.algoritmo.vidarte.models.Votacion;
import pe.algoritmo.vidarte.utils.Lista;

public class Main {
    public static void main(String[] args) {

        VotacionController control = new VotacionController();
        Lista<Votacion> lista = control.getVotaciones();

        for (Votacion v : lista) {
            System.out.println(v.toCSV());
        }
    
    }
}