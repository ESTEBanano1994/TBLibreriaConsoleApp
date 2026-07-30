package org.tb.controller;

import org.tb.dao.CategoriaDAO;
import org.tb.impl.CategoriaDAOImpl;
import org.tb.model.Categoria;
import org.tb.view.CategoriaConsoleView;

public class CategoriaController {

    private final CategoriaDAO dao;
    private final CategoriaConsoleView vista;

    public CategoriaController(
            CategoriaConsoleView vista) {

        this.dao = new CategoriaDAOImpl();
        this.vista = vista;
    }

    public void iniciar() {

        int opcion;

        do {

            opcion = vista.mostrarMenu();

            switch (opcion) {

                case 1:
                    crear();
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    buscar();
                    break;

                case 4:
                    actualizar();
                    break;

                case 5:
                    eliminar();
                    break;

                case 6:
                    break;

                default:
                    vista.mostrarMensaje("Opción inválida");
            }

        } while (opcion != 6);
    }

    private void crear() {

        String nombre =
                vista.solicitarNombreCategoria();

        Categoria categoria =
                new Categoria(0, nombre);

        if (dao.crear(categoria)) {

            vista.mostrarMensaje(
                    "Categoría creada correctamente");
        }
    }

    private void listar() {

        vista.mostrarListaCategorias(
                dao.listarTodos());
    }

    private void buscar() {

        int id =
                vista.solicitarIdCategoria();

        Categoria categoria =
                dao.buscarPorId(id);

        if (categoria != null) {

            vista.mostrarCategoria(categoria);

        } else {

            vista.mostrarMensaje(
                    "Categoría no encontrada");
        }
    }

    private void actualizar() {

        int id =
                vista.solicitarIdCategoria();

        String nombre =
                vista.solicitarNombreCategoria();

        Categoria categoria =
                new Categoria(id, nombre);

        if (dao.actualizar(categoria)) {

            vista.mostrarMensaje(
                    "Categoría actualizada correctamente");
        }
    }

    private void eliminar() {

        int id =
                vista.solicitarIdCategoria();

        if (dao.eliminar(id)) {

            vista.mostrarMensaje(
                    "Categoría eliminada correctamente");
        }
    }
}