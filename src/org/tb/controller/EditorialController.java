package org.tb.controller;

import org.tb.dao.EditorialDao;
import org.tb.dao.impl.EditorialDAOimpl;
import org.tb.view.EditorialConsoleView;
public class EditorialController {
    private final EditorialDao dao;
    private final EditorialConsoleView vista;
    public EditorialController(EditorialConsoleView vista) {
        this.dao = new EditorialDAOimpl();
        this.vista = vista;
    }
    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            if (opcion == 2) {
                listarTodos();
                
            }
            break;
        } while (opcion != 6);
    }
    private void listarTodos() {
        vista.mostrarListaEditoriales(dao.listarTodos());
    }
}