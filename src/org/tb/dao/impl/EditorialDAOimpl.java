package org.tb.dao.imp;

import org.ar.model.Editorial;
import org.ar.dao.EditorialDAO;

import java.util.List;
import org.tb.dao.impl.EditorialDAO;

public class EditorialDAOImpl implements EditorialDAO {

    @Override
    public boolean insertar(Editorial editorial) {
        return false;
    }

    @Override
    public List<Editorial> listar() {
        return null;
    }

    @Override
    public Editorial buscar(String nit) {
        return null;
    }

    @Override
    public boolean actualizar(Editorial editorial) {
        return false;
    }

    @Override
    public boolean eliminar(String nit) {
        return false;
    }

}