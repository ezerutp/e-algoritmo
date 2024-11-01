package pe.algoritmo.vidarte.utils;

public class Utilidades {

    public static Partido tipoPartido(String partido) {
        try {
            if (partido.equalsIgnoreCase("PUM J")) { partido = "PUM_J"; }
            return Partido.valueOf(partido.toUpperCase());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public enum Partido {
        ELECTORES,
        ABSTENCIONES,
        VOTANTES,
        BLANCOS,
        VALIDOS,
        NULOS,
        PSOE,
        FO,
        PP,
        PACMA,
        PCTE,
        PUM_J,
        PUEDE,
        AEEV,
        VOX,
        SUMAR,
        RC
    }
}
