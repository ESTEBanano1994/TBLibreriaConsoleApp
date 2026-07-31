package org.tb.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.tb.dao.UsuarioDAO;
import org.tb.system.Main;
import org.tb.util.SecurityUtil;
import org.tb.util.ValidacionException;

public class RegistrarUsuarioController implements Initializable {

    @FXML
    private TextField txtUsusario;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtConfirmarPassword;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnRegresar;

    @FXML
    private Label lblMensaje;

    private UsuarioDAO usuarioDAO;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarioDAO = new UsuarioDAO();
        lblMensaje.setText("");
    }

    @FXML
    public void eventoRegistrar(ActionEvent evento) {

        try {

            ValidacionException.validarNoVacio(txtUsusario.getText(), "usuario");
            ValidacionException.validarNoVacio(txtPassword.getText(), "contraseña");
            ValidacionException.validarNoVacio(txtConfirmarPassword.getText(), "confirmar contraseña");

            ValidacionException.validarCoincidencia(
                    txtPassword.getText(),
                    txtConfirmarPassword.getText(),
                    "Las contraseñas no coinciden");

            ValidacionException.validarLongitudMinima(
                    txtPassword.getText(),
                    6,
                    "La contraseña debe tener al menos 6 caracteres");

            String usuario = txtUsusario.getText().trim();
            String password = txtPassword.getText();

            String passwordHash = SecurityUtil.hashSHA256(password);

            boolean registrado = usuarioDAO.registrarUsuario(usuario, passwordHash);

            if (registrado) {

                mostrarAlerta(Alert.AlertType.INFORMATION,
                        "Usuario registrado con éxito");

                Main.cambiarVista("/org/tb/view/InicioSesionView.fxml");

            } else {

                mostrarAlerta(Alert.AlertType.ERROR,
                        "Error al registrar. El usuario podría ya existir.");

            }

        } catch (ValidacionException e) {

            mostrarAlerta(Alert.AlertType.WARNING, e.getMessage());
            lblMensaje.setText(e.getMessage());

        } catch (Exception e) {

            System.err.println("Error al volver al Login: " + e.getMessage());
            e.printStackTrace();

        }

    }

    @FXML
    public void eventoRegresar(ActionEvent evento) {

        try {

            Main.cambiarVista("/org/tb/view/InicioSesionView.fxml");

        } catch (Exception e) {

            System.err.println("Error al cargar el login: " + e.getMessage());
            lblMensaje.setText("Error interno");

        }

    }

    private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {

        Alert alerta = new Alert(tipo, mensaje, ButtonType.OK);
        alerta.showAndWait();

    }

}