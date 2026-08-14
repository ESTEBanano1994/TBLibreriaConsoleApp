package org.tb.view;

import java.util.Scanner;
import org.tb.controller.ClienteController;
import org.tb.controller.CategoriaController;
import org.tb.controller.EditorialController;

public class MenuPrincipal {

    Scanner leer = new Scanner(System.in);

    public void iniciar() {
        int opcion = 0;

        do {
            System.out.println("Bienvenido, seleccione una opcion!");
            System.out.println("1. Modulo Cliente");
            System.out.println("2. Modulo Autores");
            System.out.println("3. Modulo Categorias");
            System.out.println("4. Modulo Editoriales");
            System.out.println("5. Salir");

            opcion = Integer.parseInt(leer.nextLine());

            switch (opcion) {

                case 1:
                    System.out.println("Cliente");
                    ClienteConsoleView vistaCliente = new ClienteConsoleView();
                    ClienteController controladorCliente =
                            new ClienteController(vistaCliente);
                    controladorCliente.iniciar();
                    break;

                case 2:
                    System.out.println("AUTORES");
                    break;

                case 3:
                    System.out.println("Categoria");
                    CategoriaConsoleView vistaCategoria =
                            new CategoriaConsoleView();
                    CategoriaController controladorCategoria =
                            new CategoriaController(vistaCategoria);
                    controladorCategoria.iniciar();
                    break;

                case 4:
                    EditorialConsoleView vistaEditorial =
                            new EditorialConsoleView();
                    EditorialController controladorEditorial =
                            new EditorialController(vistaEditorial);
                    controladorEditorial.iniciar();
                    break;

                case 5:
                    System.out.println("\nHasta luego!");
                    break;

                default:
                    System.out.println("No existe esta opción");
            }

        } while (opcion != 5);
    }
}