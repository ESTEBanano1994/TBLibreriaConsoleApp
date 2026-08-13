package org.tb.dao;

import java.util.List;
import org.tb.model.Categoria;
 
public interface CategoriaDAO {
    //firmas de metodos
    boolean insertar(Categoria categorias);
    List<Categoria> listarTodos();
    Categoria buscar(String ID);
    boolean actualizar(Categoria categoria);
    boolean eliminar(String ID);
}