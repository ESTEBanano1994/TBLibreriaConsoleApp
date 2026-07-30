package org.tb.view;

import java.util.Scanner;
import org.tb.controller.EditorialController;
 
public class MenuPrincipal {
    private final Scanner leer = new Scanner(System.in);
    //heramienta scanner: lee datos del usuario
    public void iniciarSistema(){
        int opcion;
        //ciclo para el menu: do while
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
            System.out.println("Selecciones una opción: ");
            opcion = Integer.parseInt(leer.nextLine());
        //swich / case
            switch (opcion) {
                case 1:
                    //instanciar la vista CLIENTES
                case 2:
                    //instanciar la vista EDITORIALES
                    System.out.println("CATEGORIAS");
                    break;
                case 3:
                    //instanciar la vista LIBROS
                    System.out.println("LIBROS");
                    break;
                case 4:
                    EditorialConsoleView vista = new EditorialConsoleView();
                    EditorialController  control = new EditorialController(vista);
                    control.iniciar();
                    break;
                case 5:
                    //instanciar la vista LIBROS
                    System.out.println("COMPRAS");
                    break;
                 case 6:
                    //instanciar la vista LIBROS
                    System.out.println("AUTORES");
                    break;
                case 7:
                    //instanciar la vista LIBROS
                    System.out.println("DETALLE AUTORES");
                    break;
                case 8:
                    //instanciar la vista LIBROS
                    System.out.println("\n Hasta luego sixseveniano...");
                    break;
                default:
                    System.out.println("no existe esta opción");
            }
        } while (opcion != 8);
    }
}