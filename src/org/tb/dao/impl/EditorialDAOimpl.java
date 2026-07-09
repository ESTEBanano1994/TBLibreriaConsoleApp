package org.tb.dao.impl;

import java.util.ArrayList;
import org.tb.model.Editorial;
import org.tb.dao.EditorialDao;
import org.tb.util.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
 
import java.util.List;
import java.sql.Connection;

public class EditorialDAOimpl implements EditorialDao {

    @Override
    public boolean insertar(Editorial editorial) {
        return false;
    }

    @Override
    public List<Editorial> listar() {
        List<Editorial> editorial = new ArrayList<>();
        String consulta = "{call sp_listarClientes()}";
        // maperar el resultado de la consulta a objeto y lo agregamos a la lista 
                //try with resorurces / intentar con recursos ---> cierra el recurso al completar el intento
                //recurso: Conexion, al final se cierra
        try (  Connection conexion = Connection.getInstancia().conectar();
                CallableStatement consultaCall = conexion.prepareCall(consulta)
                ResultSet tablaResultado = consultaCall.executeQuery();) 
                    
                    while (tablaResultado.next()) {
                        editorial.add(new Editorial(
                                tablaResultado.getString("nit"),
                                tablaResultado.getString("nombre_editorial"),
                                tablaResultado.getString("telefono_editorial"),
                                tablaResultado.getString("direccion_editorial")
                        ));
                    }
            //ciclo para rellenar mi lista
            //verificador cada filta de result set
            //va a gaurda cada celda dentro de cada atributo de mi objeto

        } catch (Exception e) {
            System.out.println("Error al lsitar Clientes: " + e.getMessage());
        }
        
        return editorial;
    }

    @Override
    public Editorial buscar(String nit) {
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