package org.tb.view;
 
import java.util.Scanner;
import org.tb.controller.CategoriaController;
import org.tb.controller.ClienteController;
import org.tb.controller.EditorialController;

 
public class MenuPrincipal {
 
    private final Scanner leer = new Scanner(System.in);
 
    public void iniciarSistema() {
        int opcion = 0;
 
        do {
            System.out.println("--------------------------------------");
            System.out.println("    SISTEMA CENTRAL LIBRERIA - IN4CM");
            System.out.println("--------------------------------------");
            System.out.println("1. Entrar a CLIENTES");
            System.out.println("2. Entrada a CATEGORIAS");
            System.out.println("3. Entrada a LIBROS");
            System.out.println("4. Entrada a EDITORIALES");
            System.out.println("5. Entrada a COMPRAS");
            System.out.println("6. Entrada a AUTORES");
            System.out.println("7. Entrada a DETALLE AUTORES");
            System.out.println("8. SALIR DEL SISTEMA");
            System.out.print("Seleccione una opción: ");
 
            try {
                opcion = Integer.parseInt(leer.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1; // Fuerza la ejecución del bloque 'default' si ingresan texto
            }
 
            switch (opcion) {
                case 1:
                    System.out.println("\n--- CLIENTES ---");
                    ClienteConsoleView vistaCliente = new ClienteConsoleView();
                        ClienteController controladorCliente = new ClienteController(vistaCliente);
                        controladorCliente.iniciar();
                    break;
 
                case 2:
                    System.out.println("\n--- CATEGORIAS ---");
                   CategoriaConsoleView vistaCategoria =
                            new CategoriaConsoleView();
                    CategoriaController controladorCategoria =
                            new CategoriaController(vistaCategoria);
                    controladorCategoria.iniciar();

                    break;
 
                case 3:
                    System.out.println("\n--- LIBROS ---");
                    break;
 
                case 4:
                    System.out.println("\n--- EDITORIALES ---");
                    EditorialConsoleView vistaEditorial = new EditorialConsoleView();
                    EditorialController controlEditorial = new EditorialController(vistaEditorial);
                    controlEditorial.iniciar();
                    break;
 
                case 5:
                    System.out.println("\n--- COMPRAS ---");
                    break;
 
                case 6:
                    System.out.println("\n--- AUTORES ---");
                    break;
 
                case 7:
                    System.out.println("\n--- DETALLE AUTORES ---");
                    break;
 
                case 8:
                    System.out.println("\nHasta pronto chaval...");
                    System.out.println("Hasta luego sixseveniano...");
                    break;
 
                default:
                    System.out.println("\nNo existe esta opción. Intente de nuevo.");
                    break;
            }
            System.out.println(); // Salto de línea para dar espacio entre repeticiones
 
        } while (opcion != 8);
    }
}