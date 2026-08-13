package org.tb.view;
import java.util.List;
import java.util.Scanner;
import org.tb.model.Categoria;

public class CategoriaConsoleView {
 
    private final Scanner leer = new Scanner(System.in);
 
    // Mostrar menú

    public int mostrarMenu() {

        int opcion;
 
        System.out.println("------- GESTION DE CATEGORIAS -------");

        System.out.println("1. CREAR NUEVA CATEGORIA");

        System.out.println("2. LISTAR CATEGORIAS");

        System.out.println("3. BUSCAR POR ID");

        System.out.println("4. MODIFICAR CATEGORIA");

        System.out.println("5. ELIMINAR CATEGORIA");

        System.out.println("6. REGRESAR AL MENU PRINCIPAL");

        System.out.print("Seleccione una opción: ");
 
        opcion = Integer.parseInt(leer.nextLine());

        return opcion;

    }
 
    public String solicitarID() {

        System.out.print("Ingrese el ID: ");

        return leer.nextLine();

    }
 
    public String solicitarNombreCategoria() {

        System.out.print("Ingrese el nombre de la editorial: ");

        return leer.nextLine();

    }


    public void mostrarCategoria(Categoria categ) {

        System.out.println("----- DATOS DE LA CATEGORIA -----");

        System.out.println("ID: " + categ.getID());

        System.out.println("NOMBRE CATEGORIA: " + categ.getNombreCategoria());

    }


    public void mostrarListaCategoria(List<Categoria> categorias) {
 
        System.out.println("----------- LISTA DE CATEGORIAS -----------");
 
        System.out.printf("%-15s %-25s %-20s %-25s%n",

                "NIT", "NOMBRE CATEGORIA");
 
        for (Categoria categ : categorias) {

            System.out.printf("%-15s %-25s %-20s %-25s%n",

                    categ.getID(),

                    categ.getNombreCategoria());


        }

    }
 
    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);

    }

}

 