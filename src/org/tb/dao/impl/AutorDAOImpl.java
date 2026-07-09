package org.tb.dao.impl;

import java.util.List;
import java.util.ArrayList;
import org.tb.dao.AutorDAO;
import org.tb.model.Autores;
import org.tb.util.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;


public class AutorDAOImpl implements AutorDAO {

    @Override
    public boolean crear(Autores autor) {
        return false;
    }

    @Override
    public List<Autores> listarTodos() {
        //crear lista
        List<Autores> autores = new ArrayList<>();
        //creaer nuestra consulta
        String consulta = "{call sp_listarautores()}";
        
        //mapear el resultado de la consulta a objeto y lo agregamos a la lista
        //try with resources / intentar con recursos -> cierra el recurso al completar el intento
        //recurso: Conexion, al final se cierra
        try (
                Connection conexion = Conexion.getInstancia().conectar();
                CallableStatement consultaCall = conexion.prepareCall(consulta);
                ResultSet tablaResultado = consultaCall.executeQuery(); ) {
            //Ciclo para rellenar mi lista
            //verificar cada fila del result set
            //va a guardar cada celda dentro de cada atributo de mi objeto
            while (tablaResultado.next()) {
                autores.add(new Autores(
                        tablaResultado.getLong("id_autor"),
                        tablaResultado.getString("nombre_autor"),
                        tablaResultado.getString("apellido_autor"),
                        tablaResultado.getString("nacionalidad"),
                        tablaResultado.getString("biografia")
                ));
            }
            
        } catch (SQLException e) {
            System.err.print("Error al listar Clientes: " + e.getMessage());
        }
        // retornamos una lista
        return autores;
    }

    @Override
    public Autores buscarId(long id_autor) {
        return null;
    }

    @Override
    public boolean actualizar(Autores autor) {
        return false;
    }

    @Override
    public boolean eliminar(long id_autor) {
        return false;
    }

}