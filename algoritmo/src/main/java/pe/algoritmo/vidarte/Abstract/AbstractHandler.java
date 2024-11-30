package pe.algoritmo.vidarte.Abstract;

import pe.algoritmo.vidarte.interfaces.Handler;

public abstract class AbstractHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public boolean handle() {
        if (next != null) {
            return next.handle();
        }
        return true;
    }
}