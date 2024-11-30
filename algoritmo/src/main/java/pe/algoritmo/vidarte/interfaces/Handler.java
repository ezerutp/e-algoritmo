package pe.algoritmo.vidarte.interfaces;

public interface Handler {
    void setNext(Handler handler);
    boolean handle();
}