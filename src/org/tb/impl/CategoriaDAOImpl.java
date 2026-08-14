package org.tb.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.tb.dao.CategoriaDAO;
import org.tb.model.Categoria;
import org.tb.util.Conexion;

public class CategoriaDAOImpl implements CategoriaDAO {

    @Override
    public List<Categoria> listarTodos() {
        List<Categoria> categorias = new ArrayList<>();

        String consulta = "{call sp_listarcategorias()}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement cs = conexion.prepareCall(consulta);
            ResultSet rs = cs.executeQuery()
        ) {

            while (rs.next()) {

                Categoria categ = new Categoria();

                categ.setID(rs.getString("id_categoria"));
                categ.setNombreCategoria(rs.getString("nombre_categoria"));

                categorias.add(categ);
            }

        } catch (Exception e) {
            System.err.println("Error al listar categorias: " + e.getMessage());
        }

        return categorias;
    }

    @Override
    public boolean insertar(Categoria categoria) {

        String consulta = "{call sp_insertarcategoria(?)}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement consultaCall = conexion.prepareCall(consulta)
        ) {

            // Solo se envía el nombre porque el ID es AUTO_INCREMENT
            consultaCall.setString(1, categoria.getNombreCategoria());

            return consultaCall.executeUpdate() > 0;

        } catch (SQLException e) {

            System.err.println("Error al crear Categoria: " + e.getMessage());

        }

        return false;
    }

    @Override
    public Categoria buscar(String ID) {

        Categoria categ = new Categoria();

        String consulta = "{call sp_buscarcategoria(?)}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement cs = conexion.prepareCall(consulta)
        ) {

            cs.setString(1, ID);

            ResultSet rs = cs.executeQuery();

            if (rs.next()) {

                categ.setID(rs.getString("id_categoria"));
                categ.setNombreCategoria(rs.getString("nombre_categoria"));

                return categ;

            } else {

                System.out.println("No existe la categoria con ese ID.");

                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al buscar categoria: " + e.getMessage());

        }

        return null;
    }

    @Override
    public boolean actualizar(Categoria categoria) {
        return false;
    }

    @Override
    public boolean eliminar(String ID) {
        return false;
    }
}