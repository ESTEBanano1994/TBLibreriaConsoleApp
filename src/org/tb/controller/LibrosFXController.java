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

import org.tb.dao.LibrosDAO;
import org.tb.dao.impl.LibriosDAOimpl;
import org.tb.model.Libros;
import org.tb.system.Main;

public class LibrosFXController implements Initializable {

    @FXML
    private TextField txtIsbn;

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtFechaPublicacion;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtIdCategoria;

    @FXML
    private TextField txtNitEditorial;

    @FXML
    private Label lblMensaje;

    @FXML
    private TableView<Libros> tablaLibros;

    @FXML
    private TableColumn<Libros, String> colIsbn;

    @FXML
    private TableColumn<Libros, String> colTitulo;

    @FXML
    private TableColumn<Libros, Boolean> colFechaPublicacion;

    @FXML
    private TableColumn<Libros, String> colPrecio;

    @FXML
    private TableColumn<Libros, Long> colIdCategoria;

    @FXML
    private TableColumn<Libros, String> colNitEditorial;

    private final LibrosDAO librosDAO = new LibriosDAOimpl();

    private final ObservableList<Libros> listaLibros =
            FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        configurarTabla();
        cargarTabla();
        seleccionarFila();
    }

    private void configurarTabla() {

        colIsbn.setCellValueFactory(
                new PropertyValueFactory<>("isbn")
        );

        colTitulo.setCellValueFactory(
                new PropertyValueFactory<>("tituloLibros")
        );

        colFechaPublicacion.setCellValueFactory(
                new PropertyValueFactory<>("fecha_publicacionLibros")
        );

        colPrecio.setCellValueFactory(
                new PropertyValueFactory<>("precioLibros")
        );

        colIdCategoria.setCellValueFactory(
                new PropertyValueFactory<>("id_categoriaLibros")
        );

        colNitEditorial.setCellValueFactory(
                new PropertyValueFactory<>("nit_editorialLibros")
        );
    }

    private void cargarTabla() {

        listaLibros.setAll(librosDAO.listarTodos());

        tablaLibros.setItems(listaLibros);
    }

    private void seleccionarFila() {

        tablaLibros.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (obs, oldSelection, newSelection) -> {

                            if (newSelection != null) {

                                txtIsbn.setText(
                                        newSelection.getIsbn()
                                );

                                txtTitulo.setText(
                                        newSelection.getTituloLibros()
                                );

                                txtFechaPublicacion.setText(
                                        String.valueOf(
                                                newSelection.isFecha_publicacionLibros()
                                        )
                                );

                                txtPrecio.setText(
                                        newSelection.getPrecioLibros()
                                );

                                txtIdCategoria.setText(
                                        String.valueOf(
                                                newSelection.getId_categoriaLibros()
                                        )
                                );

                                txtNitEditorial.setText(
                                        newSelection.getNit_editorialLibros()
                                );
                            }
                        }
                );
    }

    @FXML
    private void handleGuardar() {

        try {

            if (txtIsbn.getText().isEmpty()
                    || txtTitulo.getText().isEmpty()
                    || txtFechaPublicacion.getText().isEmpty()
                    || txtPrecio.getText().isEmpty()
                    || txtIdCategoria.getText().isEmpty()
                    || txtNitEditorial.getText().isEmpty()) {

                mostrarError("Todos los campos son obligatorios.");

                return;
            }

            Libros libro = new Libros();

            libro.setIsbn(
                    txtIsbn.getText().trim()
            );

            libro.setTituloLibros(
                    txtTitulo.getText().trim()
            );

            libro.setFecha_publicacionLibros(
                    Boolean.parseBoolean(
                            txtFechaPublicacion.getText().trim()
                    )
            );

            libro.setPrecioLibros(
                    txtPrecio.getText().trim()
            );

            libro.setId_categoriaLibros(
                    Long.parseLong(
                            txtIdCategoria.getText().trim()
                    )
            );

            libro.setNit_editorialLibros(
                    txtNitEditorial.getText().trim()
            );

            if (librosDAO.insertar(libro)) {

                lblMensaje.setText(
                        "Libro registrado exitosamente."
                );

                cargarTabla();
                limpiarFormulario();

            } else {

                mostrarError(
                        "No se pudo registrar el libro."
                );
            }

        } catch (NumberFormatException e) {

            mostrarError(
                    "El ID de categoría debe ser un número válido."
            );

        } catch (Exception e) {

            mostrarError(
                    "Error al guardar: " + e.getMessage()
            );
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

        lblMensaje.setText(
                "Tabla actualizada."
        );
    }

    @FXML
    private void handleVolver() {

        try {

            Main.cambiarVista(
                    "/org/tb/view/MenuPrincipal.fxml"
            );

        } catch (Exception e) {

            mostrarError(
                    "Error al volver al menú: "
                    + e.getMessage()
            );
        }
    }

    private void limpiarFormulario() {

        txtIsbn.clear();
        txtTitulo.clear();
        txtFechaPublicacion.clear();
        txtPrecio.clear();
        txtIdCategoria.clear();
        txtNitEditorial.clear();
    }

    private void mostrarError(String mensaje) {

        Alert alert =
                new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error");

        alert.setHeaderText(null);

        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}