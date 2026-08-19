package org.tb.model;

public class Libros {

    //Atributos de clasde
    private String isbn;
    private String tituloLibros;
    private boolean fecha_publicacionLibros;
    private String precioLibros;
    private long id_categoriaLibros;
    private String nit_editorialLibros;
     
        public Libros() {
    }
    public Libros(String isbn, String tituloLibros, boolean fecha_publicacionLibros, String precioLibros, long id_categoriaLibros, String nit_editorialLibros) {
        this.isbn = isbn;
        this.tituloLibros = tituloLibros;
        this.fecha_publicacionLibros = fecha_publicacionLibros;
        this.precioLibros = precioLibros;
        this.id_categoriaLibros = id_categoriaLibros;
        this.nit_editorialLibros = nit_editorialLibros;
    }
    // getters y setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTituloLibros() {
        return tituloLibros;
    }

    public void setTituloLibros(String tituloLibros) {
        this.tituloLibros = tituloLibros;
    }

    public boolean isFecha_publicacionLibros() {
        return fecha_publicacionLibros;
    }

    public void setFecha_publicacionLibros(boolean fecha_publicacionLibros) {
        this.fecha_publicacionLibros = fecha_publicacionLibros;
    }

    public String getPrecioLibros() {
        return precioLibros;
    }

    public void setPrecioLibros(String precioLibros) {
        this.precioLibros = precioLibros;
    }

    public long getId_categoriaLibros() {
        return id_categoriaLibros;
    }

    public void setId_categoriaLibros(long id_categoriaLibros) {
        this.id_categoriaLibros = id_categoriaLibros;
    }

    public String getNit_editorialLibros() {
        return nit_editorialLibros;
    }

    public void setNit_editorialLibros(String nit_editorialLibros) {
        this.nit_editorialLibros = nit_editorialLibros;
    }
    
}


