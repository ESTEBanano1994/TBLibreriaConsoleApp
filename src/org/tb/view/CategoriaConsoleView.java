package org.tb.view;

import java.util.List;
import java.util.Scanner;
import org.tb.util.Conexion;
import org.tb.model.Categoria;

public class CategoriaConsoleView {

    private final Scanner leer = new Scanner(System.in);

    public int mostrarMenu() {

        System.out.println("--- GESTION DE CATEGORIAS ---");
        System.out.println("1. CREAR");
        System.out.println("2. LISTAR");
        System.out.println("3. BUSCAR");
        System.out.println("4. ACTUALIZAR");
        System.out.println("5. ELIMINAR");
        System.out.println("6. REGRESAR");

        return Integer.parseInt(leer.nextLine());
    }

    public int solicitarIdCategoria() {

        System.out.print("Ingrese ID Categoria: ");
        return Integer.parseInt(leer.nextLine());
    }

    public String solicitarNombreCategoria() {

        System.out.print("Ingrese nombre categoria: ");
        return leer.nextLine();
    }

    public void mostrarCategoria(Categoria categoria) {

        System.out.println("--- DATOS CATEGORIA ---");
        System.out.println("ID: " + categoria.getIdCategoria());
        System.out.println("NOMBRE: " + categoria.getNombreCategoria());
    }

    public void mostrarListaCategorias(List<Categoria> categorias) {

        System.out.println("--- LISTADO DE CATEGORIAS ---");

        System.out.printf("%-10s %-30s%n",
                "ID",
                "NOMBRE");

        for (Categoria categoria : categorias) {

            System.out.printf("%-10d %-30s%n",
                    categoria.getIdCategoria(),
                    categoria.getNombreCategoria());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}