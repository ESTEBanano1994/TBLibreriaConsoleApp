package org.tb.controller;
 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.tb.dao.EditorialDao;
import org.tb.dao.impl.EditorialDAOimpl;
import org.tb.model.Editorial;
import org.tb.system.Main;
 
public class EditorialFXController implements Initializable {
 
    @FXML
    private TextField txtNit;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDireccion;
    @FXML
    private Label lblMensaje;
    @FXML
    private TableView<Editorial> tablaEditoriales;//Tabla de entidad: Editorial
 
    @FXML TableColumn<Editorial, String> colNit;
    @FXML TableColumn<Editorial, String> colNombre;
    @FXML TableColumn colTelefono;
    @FXML TableColumn<Editorial, String> colDireccion;
    
    private final EditorialDao editorialDAO = new EditorialDAOimpl();
    private final ObservableList<Editorial> listaEditorial = FXCollections.observableArrayList();//Entidad: Editorial
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        cargarTabla();
        seleccionarFila();
        configurarTabla();
    }
    
    private void configurarTabla(){
        colNit.setCellValueFactory(new PropertyValueFactory<>("nit"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreEditorial"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<Editorial, String>("telefonoEditorial"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccionEditorial"));
    }
 
    private void cargarTabla() {
        listaEditorial.setAll(editorialDAO.listarTodos());
        tablaEditoriales.setItems(listaEditorial);
    }
 
    private void seleccionarFila() {
        tablaEditoriales.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        txtNit.setText(String.valueOf(newSelection.getNit()));
                        txtNombre.setText(newSelection.getNombreEditorial());
                        txtTelefono.setText(newSelection.getTelefonoEditorial());
                        txtDireccion.setText(newSelection.getDireccionEditorial());
                    }
                });
    }
 
    @FXML
    private void handleGuardar() {
        try {
            if (txtNit.getText().isEmpty() || txtNombre.getText().isEmpty()
                    || txtTelefono.getText().isEmpty() || txtDireccion.getText().isEmpty()) {
                mostrarError("Todos los campos son obligatorios.");
                return;
            }
            
            Editorial editorial = new Editorial();
            editorial.setNit(txtNit.getText().trim());  
            editorial.setNombreEditorial(txtNombre.getText().trim());
            editorial.setTelefonoEditorial(txtTelefono.getText().trim());
            editorial.setDireccionEditorial(txtDireccion.getText().trim());
 
            if (editorialDAO.insertar(editorial)) {
                lblMensaje.setText("Editorial registrado exitosamente.");
                cargarTabla();
                limpiarFormulario();
            } else {
                mostrarError("No se pudo registrar el Editorial.");
            }
        } catch (NumberFormatException e) {
            mostrarError("El NIT debe ser un número válido.");
        } catch (Exception e) {
            mostrarError("Error al guardar: " + e.getMessage());
        }
    }
 
    @FXML
    private void handleLimpiar() {
        limpiarFormulario();
        lblMensaje.setText("");
    }
 
    @FXML
    private void handleActualizar() {
        cargarTabla();
        lblMensaje.setText("Tabla actualizada.");
    }
 
    @FXML
    private void handleVolver() {
        try {
            Main.cambiarVista("/org/tb/view/MenuPrincipal.fxml");
        } catch (Exception e) {
            mostrarError("Error al volver al menú: " + e.getMessage());
        }
    }
 
    private void limpiarFormulario() {
        txtNit.clear();
        txtNombre.clear();
        txtTelefono.clear();
        txtDireccion.clear();
    }
 
    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
 
}
