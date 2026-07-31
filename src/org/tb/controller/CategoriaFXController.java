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
import org.tb.dao.CategoriaDAO;
import org.tb.impl.CategoriaDAOImpl;
import org.tb.model.Categoria;
import org.tb.system.Main;
 
public class CategoriaFXController implements Initializable {
 
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNombreCategoria;
    @FXML
    private Label lblMensaje;
    @FXML
    private TableView<Categoria> tablaCategorias;
 
    @FXML TableColumn<Categoria, String> colID;
    @FXML TableColumn<Categoria, String> colNombreCategoria;
    
    private final CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
    private final ObservableList<Categoria> listaCategoria = FXCollections.observableArrayList();
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        cargarTabla();
        seleccionarFila();
        configurarTabla();
    }
    
    private void configurarTabla(){
        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colNombreCategoria.setCellValueFactory(new PropertyValueFactory<>("NombreCategoria"));
    
    }
    private void cargarTabla() {
        listaCategoria.setAll(categoriaDAO.listarTodos());
        tablaCategorias.setItems(listaCategoria);
    }
 
    private void seleccionarFila() {
        tablaCategorias.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        txtID.setText(String.valueOf(newSelection.getID()));
                        txtNombreCategoria.setText(newSelection.getNombreCategoria());
                    }
                });
    }
 
    @FXML
    private void handleGuardar() {
        try {
            if (txtID.getText().isEmpty() || txtNombreCategoria.getText().isEmpty())
                {
                mostrarError("Todos los campos son obligatorios.");
                return;
            }
            
            Categoria categoria = new Categoria();
            categoria.setID(txtID.getText().trim());
            categoria.setNombreCategoria(txtNombreCategoria.getText().trim());
            if (categoriaDAO.insertar(categoria)) {
                lblMensaje.setText("Cliente registrado exitosamente.");
                cargarTabla();
                limpiarFormulario();
            } else {
                mostrarError("No se pudo registrar el cliente.");
            }
        } catch (NumberFormatException e) {
            mostrarError("El ID debe ser un número válido.");
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
        txtID.clear();
        txtNombreCategoria.clear();
    }
 
    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
 
}
