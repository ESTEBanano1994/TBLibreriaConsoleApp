package org.tb.view;

import java.util.Scanner;

public class AutorConsoleView {
    private final Scanner leer = new Scanner(System.in);
    
    //metodo para mostrar las opciones de este menu
    public int mostrarMenu(){
        int opcion = 0;
        //todo el menu
        System.out.println("--- GESTION DE CLIENTES ---");
        System.out.println("--- 1. Crear nuevo Autor ---");
        System.out.println("--- 2. Listar todos los Autores ---");
        System.out.println("--- 3. Buscar Autores por ID ---");
        System.out.println("--- 4. Modificar Autor ---");
        System.out.println("--- 5. Eliminar nuevo Autor ---");
        System.out.println("--- 6. Regresar a menú Principal ---");
        opcion = Integer.parseInt(leer.nextLine());
        return opcion;
        
    }
    
    public long SolicitarId(){
        System.out.println("Ingrese el ID del Autor: ");
        return Long.parseLong(leer.nextLine());
    } 
    //nombreAutor
    public String solicitarNombreAutor(){
        String nombre;
        System.out.println("Ingrese nombre del Autor: ");
        nombre = leer.nextLine();
        return nombre;
        //return leer.nextLine();
    }
    //apellidoAutor
    public String solicitarApellidoAutor(){
        System.out.println("Ingrese apellido del Autor: ");
        return leer.nextLine();
    }
    //Nacionalidad
    public String solicitarNacionalidad(){
        System.out.println("Ingrese la nacionalidad: ");
        return leer.nextLine();
    }
    //Biografia
    public String solicitarBiografia(){
        System.out.println("Ingrese la Biografia: ");
        return leer.nextLine();
    }
    
    //mostrar el detalle de un Autor
    public void mostrarAutor(Autor autor){
        System.out.println("--- DATOS DEL AUTOR ---");
        System.out.println("ID: " + autor.getId);
        System.out.println("NOMBRE: " + autor.getNombre);
        System.out.println("APELLIDO: " + autor.getApellido);
        System.out.println("NACIONALIDAD: " + autor.getNacionalidad);
        System.out.println("BIOGRAFIA: " + autor.getBiografia);
    }
    
    //mostrar la Lista de Autore
    
}
