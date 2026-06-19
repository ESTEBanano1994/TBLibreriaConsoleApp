package org.tb.model;

public class Editorial {
    /*
    create table editorial
        
    */
    
    //Atributos de clasde
    private String nit;
    private String nombre_editorial;
    private String telefono_editorial;
    private String direccion_editoria;
    
    //Constructores: asignacion de datos, instanciar objetos
    //vacio, lleno, personalizado.
    public Editorial() {
    }
    //llene 
    public Editorial(String nit, String nombre_editorial, String telefono_editorial, String direccion_editoria) {
        this.nit = nit;
        this.nombre_editorial = nombre_editorial;
        this.telefono_editorial = telefono_editorial;
        this.direccion_editoria = direccion_editoria;
    }
    
        //getter and setters

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre_editorial() {
        return nombre_editorial;
    }

    public void setNombre_editorial(String nombre_editorial) {
        String nombreMayusculas = nombre_editorial.toUpperCase();
        this.nombre_editorial = nombre_editorial;
    }

    public String getTelefono_editorial() {
        return telefono_editorial;
    }

    public void setTelefono_editorial(String telefono_editorial) {
        this.telefono_editorial = telefono_editorial;
    }

    public String getDireccion_editoria() {
        return direccion_editoria;
    }

    public void setDireccion_editoria(String direccion_editoria) {
        this.direccion_editoria = direccion_editoria;
    }

}
