package org.tb.model;

public class Editorial {
    /*
    create table editorial
        
    */
    
    //Atributos de clasde
    private String nit;
    private String nombreEditorial;
    private String telefonoEditorial;
    private String direccionEditorial;
    
    //Constructores: asignacion de datos, instanciar objetos
    //vacio, lleno, personalizado.
    public Editorial() {
    }
    //llene 
    public Editorial(String nit, String nombreEditorial, String telefonoEditorial, String direccionEditorial) {
        this.nit = nit;
        this.nombreEditorial = nombreEditorial;
        this.telefonoEditorial = telefonoEditorial;
        this.direccionEditorial = direccionEditorial;
    }
    
        //getter and setters

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombre_editorial) {
        String nombreMayusculas = nombre_editorial.toUpperCase();
        this.nombreEditorial = nombre_editorial;
    }

    public String getTelefonoEditorial() {
        return telefonoEditorial;
    }

    public void setTelefonoEditorial(String telefono_editorial) {
        this.telefonoEditorial = telefono_editorial;
    }

    public String getDireccionEditorial() {
        return direccionEditorial;
    }

    public void setDireccionEditorial(String direccion_editoria) {
        this.direccionEditorial = direccion_editoria;
    }

}
