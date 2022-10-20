package MudaFacilFx;

import Control.ControllerDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InterfazRastrearMudanza {

    @FXML
    private Button rastrearMudanzaBoton;

    @FXML
    private TableView<?> rastrearMudanzaTabla;

    @FXML
    public void closeWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MudaFacilFx/InterfazMenuCliente.fxml"));
            Parent root = loader.load();

            InterfazMenuCliente controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(e -> controller.closeWindow());

            Stage myStage = (Stage) this.rastrearMudanzaBoton.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            Logger.getLogger(InterfazMenuCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    public void closeEmpresa() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MudaFacilFx/InterfazMenuEmpresa.fxml"));
            Parent root = loader.load();

            InterfazMenuEmpresa controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(e -> controller.closeWindow());

            Stage myStage = (Stage) this.rastrearMudanzaBoton.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            Logger.getLogger(InterfazMenuCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void rastrear(ActionEvent event) throws SQLException, ClassNotFoundException {
        ControllerDB ControlDB = new ControllerDB();
        String TCuenta = ControlDB.BuscarTCuenta(InterfazLogin.aux.nom, InterfazLogin.aux.con);
        try {
            if (TCuenta.equalsIgnoreCase("Cliente")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/MudaFacilFx/InterfazRastrearExitoso.fxml"));
                Parent root = loader.load();

                InterfazRastrearExitoso controller = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();

                stage.setOnCloseRequest(e -> controller.closeWindow());

                Stage myStage = (Stage) this.rastrearMudanzaBoton.getScene().getWindow();
                myStage.close();
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/MudaFacilFx/InterfazRastrearExitoso.fxml"));
                Parent root = loader.load();

                InterfazRastrearExitoso controller = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();

                stage.setOnCloseRequest(e -> controller.closeEmpresa());

                Stage myStage = (Stage) this.rastrearMudanzaBoton.getScene().getWindow();
                myStage.close();
            }
        } catch (IOException e) {
            Logger.getLogger(InterfazMenuCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
