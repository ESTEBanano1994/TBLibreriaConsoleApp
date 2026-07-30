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
    public boolean crear(Categoria categoria) {

        String sql = "{call sp_insertarcategoria(?)}";

        try (
                Connection conexion = Conexion.getInstancia().conectar();
                CallableStatement stmt = conexion.prepareCall(sql)) {

            stmt.setString(1, categoria.getNombreCategoria());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al crear categoría: "
                    + e.getMessage());
        }

        return false;
    }

    @Override
    public List<Categoria> listarTodos() {

        List<Categoria> categorias = new ArrayList<>();

        String sql = "{call sp_listarcategorias()}";

        try (
                Connection conexion = Conexion.getInstancia().conectar();
                CallableStatement stmt = conexion.prepareCall(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                categorias.add(
                        new Categoria(
                                rs.getInt("id_categoria"),
                                rs.getString("nombre_categoria")
                        )
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al listar categorías: "
                    + e.getMessage());
        }

        return categorias;
    }

    @Override
    public Categoria buscarPorId(int idCategoria) {

        String sql = "{call sp_buscarcategoria(?)}";

        try (
                Connection conexion = Conexion.getInstancia().conectar();
                CallableStatement stmt = conexion.prepareCall(sql)) {

            stmt.setInt(1, idCategoria);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre_categoria")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar categoría: "
                    + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean actualizar(Categoria categoria) {

        String sql = "{call sp_actualizarcategoria(?, ?)}";

        try (
                Connection conexion = Conexion.getInstancia().conectar();
                CallableStatement stmt = conexion.prepareCall(sql)) {

            stmt.setInt(1, categoria.getIdCategoria());
            stmt.setString(2, categoria.getNombreCategoria());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar categoría: "
                    + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean eliminar(int idCategoria) {

        String sql = "{call sp_eliminarcategoria(?)}";

        try (
                Connection conexion = Conexion.getInstancia().conectar();
                CallableStatement stmt = conexion.prepareCall(sql)) {

            stmt.setInt(1, idCategoria);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar categoría: "
                    + e.getMessage());
        }

        return false;
    }
}