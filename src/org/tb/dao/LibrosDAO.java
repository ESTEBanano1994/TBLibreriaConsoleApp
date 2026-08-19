package org.tb.dao;

import java.util.List;
import org.tb.model.Libros;

public interface LibrosDAO {
    boolean insertar(Libros libros);
    List<Libros> listarTodos();
    Libros buscar(String isbn);
    boolean actualizar(Libros libros);
    boolean eliminar(String isbn);
}