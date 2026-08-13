package org.tb.view;
import java.util.Scanner;
import org.tb.view.CategoriaConsoleView;
import org.tb.controller.CategoriaController;

import java.util.Scanner;
import org.tb.controller.EditorialController;
 
public class MenuPrincipal {
    Scanner leer = new Scanner(System.in);
    
    public void iniciar(){
        int opcion = 0;
        do {
            System.out.println("Bienvenido, selecciones una opcion!");
            System.out.println("1. Modulo Cliente");
            System.out.println("2. Modulo Autores");
            System.out.println("3. Modulo Categorias");
            System.out.println("5. Modulo Editoriales");
            System.out.println("4. Salir");
            opcion = Integer.parseInt(leer.nextLine());
            
            switch (opcion) {
                case 1:
                    //instanciar la vista CLIENTES
                case 2:
                    //instanciar la vista EDITORIALES
                    System.out.println("CATEGORIAS");
                    break;
                case 3:
                    System.out.println("Categoria");
                    CategoriaConsoleView vista = new CategoriaConsoleView();
                    CategoriaController control = new CategoriaController(vista);
                    control.iniciar();
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
            
        } while (opcion != 4);
    }
}