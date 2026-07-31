package org.tb.model;

public class Categoria {

    private String ID;
    private String nombreCategoria;

    public Categoria() {
    }
    
    public Categoria(String ID, String nombreCategoria) {
        this.ID = ID;
        this.nombreCategoria = nombreCategoria;
    }
    
        //getter and setters

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombre_categoria) {
        String nombreMayusculas = nombre_categoria.toUpperCase();
        this.nombreCategoria = nombre_categoria;
    }

}