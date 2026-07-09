package org.tb.dao.impl;

import java.util.List;
import org.tb.model.Editorial;
 
public interface EditorialDAO {
    //firmas de metodos
    boolean insertar(Editorial editoriales);
    List<Editorial> listar();
    Editorial buscar(String cui);
    boolean actualizar(Editorial cliente);
    boolean eliminar(String cui);
}