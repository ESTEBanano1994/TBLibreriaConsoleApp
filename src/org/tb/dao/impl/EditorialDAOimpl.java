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
        CallableStatement cs = conexion.prepareCall(consulta);
        ResultSet rs = cs.executeQuery()
    ) {
        while (rs.next()) {
            Editorial edi = new Editorial();
            edi.setNit(rs.getString("nit"));
            edi.setNombreEditorial(rs.getString("nombre_editorial"));
            edi.setTelefonoEditorial(rs.getString("telefono_editorial"));
            edi.setDireccionEditorial(rs.getString("direccion_editoria"));
            editoriales.add(edi);
        }
    } catch (Exception e) {
        System.err.println("Error al listar editoriales: " + e.getMessage());
    }
    return editoriales;
}
@Override
public boolean insertar(Editorial editorial) {
    return false;
}
@Override
public Editorial buscar(String nit) {


    Editorial edi = new Editorial();
 
    String consulta = "{call sp_buscar_editorial(?)}";
 
    try (

        Connection conexion = Conexion.getInstancia().conectar();

        CallableStatement cs = conexion.prepareCall(consulta)

    ) {
 
        cs.setString(1, nit);
 
        ResultSet rs = cs.executeQuery();
 
        if (rs.next()) {
            edi.setNit(rs.getString("nit"));
            edi.setNombreEditorial(rs.getString("nombre_editorial"));
            edi.setTelefonoEditorial(rs.getString("telefono_editorial"));
            edi.setDireccionEditorial(rs.getString("direccion_editorial"));
            return edi;

        } else {
 
            System.out.println("No existe la editorial con ese NIT.");

            return null;

        }
 
    } catch (Exception e) {
 
        System.err.println("Error al buscar editorial: " + e.getMessage());
 
    }
 
    return null;
 
}
@Override
public boolean actualizar(Editorial editorial) {
    return false;
}
@Override
public boolean eliminar(String nit) {
    return false;
}
}