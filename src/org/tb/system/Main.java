package org.tb.system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage escenarioPrincipal;

    @Override
    public void start(Stage stage) throws Exception {

        escenarioPrincipal = stage;

        cambiarVista("/org/tb/view/InicioSesionView.fxml");

        escenarioPrincipal.setTitle("TB Librería");
        escenarioPrincipal.show();
    }

    public static void cambiarVista(String fxmlPath) throws Exception {

        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));

        Parent root = loader.load();

        escenarioPrincipal.setScene(new Scene(root));

        escenarioPrincipal.centerOnScreen();
        escenarioPrincipal.sizeToScene();

    }

    public static void main(String[] args) {
        launch(args);
    }
}