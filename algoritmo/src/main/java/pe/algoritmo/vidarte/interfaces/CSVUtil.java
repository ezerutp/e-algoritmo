package pe.algoritmo.vidarte.interfaces;

public interface CSVUtil {
    void fromCSV(String csv);
    String toCSV();
    String getModelName();
    int getId();
}