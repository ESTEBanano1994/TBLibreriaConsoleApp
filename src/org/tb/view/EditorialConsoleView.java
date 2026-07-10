package org.tb.view;
 
import java.util.List;
import java.util.Scanner;
import org.tb.model.Editorial;
 
public class EditorialConsoleView {
 
    private final Scanner leer = new Scanner(System.in);
 
    // Mostrar menú

    public int mostrarMenu() {

        int opcion;
 
        System.out.println("------- GESTION DE EDITORIALES -------");

        System.out.println("1. CREAR NUEVA EDITORIAL");

        System.out.println("2. LISTAR EDITORIALES");

        System.out.println("3. BUSCAR EDITORIAL POR NIT");

        System.out.println("4. MODIFICAR EDITORIAL");

        System.out.println("5. ELIMINAR EDITORIAL");

        System.out.println("6. REGRESAR AL MENU PRINCIPAL");

        System.out.print("Seleccione una opción: ");
 
        opcion = Integer.parseInt(leer.nextLine());

        return opcion;

    }
 
    public String solicitarNit() {

        System.out.print("Ingrese el NIT: ");

        return leer.nextLine();

    }
 
    public String solicitarNombreEditorial() {

        System.out.print("Ingrese el nombre de la editorial: ");

        return leer.nextLine();

    }
 
    public String solicitarTelefonoEditorial() {

        System.out.print("Ingrese el teléfono: ");

        return leer.nextLine();

    }
 
    public String solicitarDireccionEditorial() {

        System.out.print("Ingrese la dirección: ");

        return leer.nextLine();

    }
 
    // Mostrar una editorial

    public void mostrarEditorial(Editorial edi) {

        System.out.println("----- DATOS DE LA EDITORIAL -----");

        System.out.println("NIT: " + edi.getNit());

        System.out.println("NOMBRE: " + edi.getNombre_editorial());

        System.out.println("TELÉFONO: " + edi.getTelefono_editorial());

        System.out.println("DIRECCIÓN: " + edi.getDireccion_editoria());

    }
 
    // Mostrar lista de editoriales

    public void mostrarListaEditoriales(List<Editorial> editoriales) {
 
        System.out.println("----------- LISTA DE EDITORIALES -----------");
 
        System.out.printf("%-15s %-25s %-20s %-25s%n",

                "NIT", "NOMBRE", "TELÉFONO", "DIRECCIÓN");
 
        for (Editorial edi : editoriales) {

            System.out.printf("%-15s %-25s %-20s %-25s%n",

                    edi.getNit(),

                    edi.getNombre_editorial(),

                    edi.getTelefono_editorial(),

                    edi.getDireccion_editoria());

        }

    }
 
    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);

    }

}

 