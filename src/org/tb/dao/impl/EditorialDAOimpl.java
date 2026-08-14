package org.tb.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.tb.dao.EditorialDao;
import org.tb.model.Editorial;
import org.tb.util.Conexion;

public class EditorialDAOimpl implements EditorialDao {

    @Override
    public List<Editorial> listarTodos() {

        List<Editorial> editoriales = new ArrayList<>();

        String consulta = "{call sp_listareditoriales()}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement consultaCall = conexion.prepareCall(consulta);
            ResultSet tablaResultado = consultaCall.executeQuery()
        ) {

            while (tablaResultado.next()) {

                Editorial edi = new Editorial();

                edi.setNit(
                    tablaResultado.getString("nit")
                );

                edi.setNombreEditorial(
                    tablaResultado.getString("nombre_editorial")
                );

                edi.setTelefonoEditorial(
                    tablaResultado.getString("telefono_editorial")
                );

                edi.setDireccionEditorial(
                    tablaResultado.getString("direccion_editoria")
                );

                editoriales.add(edi);
            }

        } catch (Exception e) {

            System.err.println(
                "Error al listar editoriales: " + e.getMessage()
            );
        }

        return editoriales;
    }

    @Override
    public boolean insertar(Editorial editorial) {

        String consulta = "{call sp_insertareditorial(?,?,?,?)}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement consultaCall =
                conexion.prepareCall(consulta)
        ) {

            consultaCall.setString(
                1,
                editorial.getNit()
            );

            consultaCall.setString(
                2,
                editorial.getNombreEditorial()
            );

            consultaCall.setString(
                3,
                editorial.getTelefonoEditorial()
            );

            consultaCall.setString(
                4,
                editorial.getDireccionEditorial()
            );

            return consultaCall.executeUpdate() > 0;

        } catch (Exception e) {

            System.err.println(
                "Error al insertar editorial: " + e.getMessage()
            );

            return false;
        }
    }

    @Override
    public Editorial buscar(String nit) {

        Editorial edi = new Editorial();

        String consulta = "{call sp_buscareditorial(?)}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement cs =
                conexion.prepareCall(consulta)
        ) {

            cs.setString(1, nit);

            try (ResultSet rs = cs.executeQuery()) {

                if (rs.next()) {

                    edi.setNit(
                        rs.getString("nit")
                    );

                    edi.setNombreEditorial(
                        rs.getString("nombre_editorial")
                    );

                    edi.setTelefonoEditorial(
                        rs.getString("telefono_editorial")
                    );

                    edi.setDireccionEditorial(
                        rs.getString("direccion_editoria")
                    );

                    return edi;

                } else {

                    System.out.println(
                        "No existe la editorial con ese NIT."
                    );

                    return null;
                }
            }

        } catch (Exception e) {

            System.err.println(
                "Error al buscar editorial: " + e.getMessage()
            );

            return null;
        }
    }

    @Override
    public boolean actualizar(Editorial editorial) {

        String consulta =
            "{call sp_actualizareditorial(?,?,?,?)}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement cs =
                conexion.prepareCall(consulta)
        ) {

            cs.setString(
                1,
                editorial.getNit()
            );

            cs.setString(
                2,
                editorial.getNombreEditorial()
            );

            cs.setString(
                3,
                editorial.getTelefonoEditorial()
            );

            cs.setString(
                4,
                editorial.getDireccionEditorial()
            );

            cs.execute();

            return true;

        } catch (Exception e) {

            System.err.println(
                "Error al actualizar editorial: " + e.getMessage()
            );

            return false;
        }
    }

    @Override
    public boolean eliminar(String nit) {

        String consulta =
            "{call sp_eliminareditorial(?)}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement cs =
                conexion.prepareCall(consulta)
        ) {

            cs.setString(1, nit);

            cs.execute();

            return true;

        } catch (Exception e) {

            System.err.println(
                "Error al eliminar editorial: " + e.getMessage()
            );

            return false;
        }
    }
}