package org.tb.dao;

import java.util.List;
import org.tb.model.Autores;

public interface AutorDAO {

    boolean crear(Autores autor);

    List<Autores> listarTodos();

    Autores buscarId(long id_autor);

    boolean actualizar(Autores autor);

    boolean eliminar(long id_autor);
}