package org.tb.view;

import java.util.List;
import java.util.Scanner;
import org.tb.model.Libros;

public class LibrosConsoleView {

    private final Scanner leer = new Scanner(System.in);

    // Mostrar menú
    public int mostrarMenu() {

        int opcion;

        System.out.println("------- GESTION DE LIBROS -------");

        System.out.println("1. CREAR NUEVO LIBRO");

        System.out.println("2. LISTAR LIBROS");

        System.out.println("3. BUSCAR LIBRO POR ISBN");

        System.out.println("4. MODIFICAR LIBRO");

        System.out.println("5. ELIMINAR LIBRO");

        System.out.println("6. REGRESAR AL MENU PRINCIPAL");

        System.out.print("Seleccione una opción: ");

        opcion = Integer.parseInt(leer.nextLine());

        return opcion;
    }

    public String solicitarIsbn() {

        System.out.print("Ingrese el ISBN: ");

        return leer.nextLine();
    }

    public String solicitarTituloLibros() {

        System.out.print("Ingrese el título del libro: ");

        return leer.nextLine();
    }

    public boolean solicitarFechaPublicacionLibros() {

        System.out.print("Ingrese la fecha de publicación (true/false): ");

        return Boolean.parseBoolean(leer.nextLine());
    }

    public String solicitarPrecioLibros() {

        System.out.print("Ingrese el precio del libro: ");

        return leer.nextLine();
    }

    public long solicitarIdCategoriaLibros() {

        System.out.print("Ingrese el ID de la categoría: ");

        return Long.parseLong(leer.nextLine());
    }

    public String solicitarNitEditorialLibros() {

        System.out.print("Ingrese el NIT de la editorial: ");

        return leer.nextLine();
    }

    // Mostrar un libro
    public void mostrarLibro(Libros libro) {

        System.out.println("----- DATOS DEL LIBRO -----");

        System.out.println("ISBN: " + libro.getIsbn());

        System.out.println("TÍTULO: " + libro.getTituloLibros());

        System.out.println("FECHA DE PUBLICACIÓN: "
                + libro.isFecha_publicacionLibros());

        System.out.println("PRECIO: " + libro.getPrecioLibros());

        System.out.println("ID CATEGORÍA: "
                + libro.getId_categoriaLibros());

        System.out.println("NIT EDITORIAL: "
                + libro.getNit_editorialLibros());
    }

    // Mostrar lista de libros
    public void mostrarListaLibros(List<Libros> libros) {

        System.out.println("----------- LISTA DE LIBROS -----------");

        System.out.printf(
                "%-15s %-25s %-20s %-15s %-15s %-20s%n",
                "ISBN",
                "TÍTULO",
                "PUBLICACIÓN",
                "PRECIO",
                "ID CATEGORÍA",
                "NIT EDITORIAL"
        );

        for (Libros libro : libros) {

            System.out.printf(
                    "%-15s %-25s %-20s %-15s %-15s %-20s%n",
                    libro.getIsbn(),
                    libro.getTituloLibros(),
                    libro.isFecha_publicacionLibros(),
                    libro.getPrecioLibros(),
                    libro.getId_categoriaLibros(),
                    libro.getNit_editorialLibros()
            );
        }
    }

    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }
}