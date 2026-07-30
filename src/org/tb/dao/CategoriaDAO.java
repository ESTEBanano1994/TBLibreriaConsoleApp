package org.tb.dao;

import java.util.List;
import org.tb.model.Categoria;

public interface CategoriaDAO {

    boolean crear(Categoria categoria);

    List<Categoria> listarTodos();

    Categoria buscarPorId(int idCategoria);

    boolean actualizar(Categoria categoria);

    boolean eliminar(int idCategoria);

}