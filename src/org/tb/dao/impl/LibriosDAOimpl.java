package org.tb.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.tb.dao.LibrosDAO;
import org.tb.model.Libros;
import org.tb.util.Conexion;

public class LibriosDAOimpl implements LibrosDAO {

    @Override
    public List<Libros> listarTodos() {

        List<Libros> libros = new ArrayList<>();

        String consulta = "{call sp_listarlibros()}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement consultaCall = conexion.prepareCall(consulta);
            ResultSet tablaResultado = consultaCall.executeQuery()
        ) {

            while (tablaResultado.next()) {

                Libros libro = new Libros();

                libro.setIsbn(
                    tablaResultado.getString("isbn")
                );

                libro.setTituloLibros(
                    tablaResultado.getString("titulo_libros")
                );

                libro.setFecha_publicacionLibros(
                    tablaResultado.getBoolean("fecha_publicacion_libros")
                );

                libro.setPrecioLibros(
                    tablaResultado.getString("precio_libros")
                );

                libro.setId_categoriaLibros(
                    tablaResultado.getLong("id_categoria_libros")
                );

                libro.setNit_editorialLibros(
                    tablaResultado.getString("nit_editorial_libros")
                );

                libros.add(libro);
            }

        } catch (Exception e) {

            System.err.println(
                "Error al listar libros: " + e.getMessage()
            );
        }

        return libros;
    }

    @Override
    public boolean insertar(Libros libro) {

        String consulta =
            "{call sp_insertarlibro(?,?,?,?,?,?)}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement consultaCall =
                conexion.prepareCall(consulta)
        ) {

            consultaCall.setString(
                1,
                libro.getIsbn()
            );

            consultaCall.setString(
                2,
                libro.getTituloLibros()
            );

            consultaCall.setBoolean(
                3,
                libro.isFecha_publicacionLibros()
            );

            consultaCall.setString(
                4,
                libro.getPrecioLibros()
            );

            consultaCall.setLong(
                5,
                libro.getId_categoriaLibros()
            );

            consultaCall.setString(
                6,
                libro.getNit_editorialLibros()
            );

            return consultaCall.executeUpdate() > 0;

        } catch (Exception e) {

            System.err.println(
                "Error al insertar libro: " + e.getMessage()
            );

            return false;
        }
    }

    @Override
    public Libros buscar(String isbn) {

        Libros libro = new Libros();

        String consulta =
            "{call sp_buscarLibro(?)}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement cs =
                conexion.prepareCall(consulta)
        ) {

            cs.setString(1, isbn);

            try (ResultSet rs = cs.executeQuery()) {

                if (rs.next()) {

                    libro.setIsbn(
                        rs.getString("isbn")
                    );

                    libro.setTituloLibros(
                        rs.getString("titulo_libros")
                    );

                    libro.setFecha_publicacionLibros(
                        rs.getBoolean("fecha_publicacion_libros")
                    );

                    libro.setPrecioLibros(
                        rs.getString("precio_libros")
                    );

                    libro.setId_categoriaLibros(
                        rs.getLong("id_categoria_libros")
                    );

                    libro.setNit_editorialLibros(
                        rs.getString("nit_editorial_libros")
                    );

                    return libro;

                } else {

                    System.out.println(
                        "No existe el libro con ese ISBN."
                    );

                    return null;
                }
            }

        } catch (Exception e) {

            System.err.println(
                "Error al buscar libro: " + e.getMessage()
            );

            return null;
        }
    }

    @Override
    public boolean actualizar(Libros libro) {

        String consulta =
            "{call sp_actualizarlibro(?,?,?,?,?,?)}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement cs =
                conexion.prepareCall(consulta)
        ) {

            cs.setString(
                1,
                libro.getIsbn()
            );

            cs.setString(
                2,
                libro.getTituloLibros()
            );

            cs.setBoolean(
                3,
                libro.isFecha_publicacionLibros()
            );

            cs.setString(
                4,
                libro.getPrecioLibros()
            );

            cs.setLong(
                5,
                libro.getId_categoriaLibros()
            );

            cs.setString(
                6,
                libro.getNit_editorialLibros()
            );

            cs.execute();

            return true;

        } catch (Exception e) {

            System.err.println(
                "Error al actualizar libro: " + e.getMessage()
            );

            return false;
        }
    }

    @Override
    public boolean eliminar(String isbn) {

        String consulta =
            "{call sp_eliminarlibro(?)}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement cs =
                conexion.prepareCall(consulta)
        ) {

            cs.setString(1, isbn);

            cs.execute();

            return true;

        } catch (Exception e) {

            System.err.println(
                "Error al eliminar libro: " + e.getMessage()
            );

            return false;
        }
    }
}