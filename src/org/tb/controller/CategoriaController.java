package org.tb.controller;

import org.tb.dao.CategoriaDAO;
import org.tb.impl.CategoriaDAOImpl;
import org.tb.model.Categoria;
import org.tb.view.CategoriaConsoleView;
public class CategoriaController {
    private final CategoriaDAO dao;
    private final CategoriaConsoleView vista;
    public CategoriaController(CategoriaConsoleView vista) {
        this.dao = new CategoriaDAOImpl();
        this.vista = vista;
    }
    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            if (opcion == 3) {
                listarTodos();
                
            }
            break;
        } while (opcion != 6);
    }
    private void listarTodos() {
        vista.mostrarCategoria((Categoria) dao.listarTodos());
    }
}