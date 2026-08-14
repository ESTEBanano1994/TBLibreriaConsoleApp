package org.tb.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import org.tb.dao.UsuarioDAO;
import org.tb.model.Usuario;
import org.tb.system.Main;
import org.tb.util.SecurityUtil;
import org.tb.util.SesionContext;
import org.tb.util.ValidacionException;

public class InicioSesionController implements Initializable {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Label lblMensaje;

    private UsuarioDAO usuarioDAO;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarioDAO = new UsuarioDAO();
        lblMensaje.setText("");
    }

    @FXML
    public void eventoInicioSesion(ActionEvent evento) {

        try {

            ValidacionException.validarNoVacio(txtUsuario.getText(), "usuario");
            ValidacionException.validarNoVacio(txtPassword.getText(), "contraseña");

            String usuario = txtUsuario.getText();
            String password = txtPassword.getText();

            String passwordHash = SecurityUtil.hashSHA256(password);

            Usuario usuarioIniciado = usuarioDAO.iniciarSesion(usuario, passwordHash);

            if (usuarioIniciado != null) {

                mostrarAlerta(Alert.AlertType.INFORMATION, "Inicio de sesión correcto");
                abrirDashboard(usuarioIniciado);

            } else {

                mostrarAlerta(Alert.AlertType.ERROR, "Usuario o contraseña incorrectos");

            }

        } catch (ValidacionException e) {

            mostrarAlerta(Alert.AlertType.WARNING, e.getMessage());
            lblMensaje.setText(e.getMessage());

        }

    }

    @FXML
    public void eventoRegistrarse(ActionEvent evento) {

        try {

            Main.cambiarVista("/org/tb/view/RegistrarUsuarioView.fxml");

        } catch (Exception e) {

            System.err.println("Error al abrir el registro: " + e.getMessage());
            lblMensaje.setText("No fue posible abrir el registro.");

        }

    }

    private void abrirDashboard(Usuario usuario) {

        SesionContext.getInstancia().setUsuairoActual(usuario);

        try {

            // Aquí se abre la interfaz principal de la librería
            Main.cambiarVista("/org/tb/view/MenuPrincipal.fxml");

        } catch (Exception e) {

            System.err.println("Error al abrir el menú principal: " + e.getMessage());
            lblMensaje.setText("No fue posible abrir el sistema.");

        }

    }

    private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {

        Alert alerta = new Alert(tipo, mensaje, ButtonType.OK);
        alerta.showAndWait();

    }

}
