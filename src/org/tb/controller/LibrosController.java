package org.tb.controller;

import org.tb.dao.LibrosDAO;
import org.tb.dao.impl.LibriosDAOimpl;
import org.tb.view.LibrosConsoleView;

public class LibrosController {

    private final LibrosDAO dao;
    private final LibrosConsoleView vista;

    public LibrosController(LibrosConsoleView vista) {

        this.dao = new LibriosDAOimpl();
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

        vista.mostrarListaLibros(dao.listarTodos());
    }
}