
package org.tb.util;
import org.tb.model.Usuario;

public class SesionContext {
    private static SesionContext instancia;
    private Usuario usuairoActual;

    public SesionContext() {
    }
    
    public static synchronized SesionContext getInstancia(){
        if (instancia == null) {
            instancia = new SesionContext();
        }
        return instancia;
    }

    public Usuario getUsuairoActual() {
        return usuairoActual;
    }

    public void setUsuairoActual(Usuario usuairoActual) {
        this.usuairoActual = usuairoActual;
    }
    
    public void cerrarSesion(){
        this.usuairoActual = null;
    }
    
}
