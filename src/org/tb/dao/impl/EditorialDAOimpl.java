package org.tb.dao.impl;

import java.util.ArrayList;
import org.tb.model.Editorial;

import java.util.List;
import org.tb.dao.impl.EditorialDao;
import org.tb.util.Conexion;

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
        try (  Conexion conexion = Conexion.getInsancia().conectar();
                CallableStatement consultaCall = conexion.prepareCall(consulta)
                ResultSet tablaResultado = consultaCall.executeQuery();)
            //ciclo para rellenar mi lista
            //verificador cada filta de result set
            //va a gaurda cada celda dentro de cada atributo de mi objeto
                
                
                
        } catch (Exception e) {
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