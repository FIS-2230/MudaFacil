package MudaFacilFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InterfazBuscarMudanzaAyudante {

    @FXML
    private Button buscarMudanzaAyudanteBotonSeleccionar;

    @FXML
    private TableView<?> buscarMudanzaAyudanteTabla;

    @FXML
    private TableColumn<?, ?> buscarMudanzaAyudanteTablaRecogida;

    @FXML
    private TableColumn<?, ?> buscarMudanzaAyudanteTablaPago;

    @FXML
    private TableColumn<?, ?> buscarMudanzaAyudanteTablaDia;

    @FXML
    private TableColumn<?, ?> buscarMudanzaAyudanteTablaHora;

    @FXML
    private TableColumn<?, ?> buscarMudanzaAyudanteTablaNumAyudantes;

    @FXML
    private TableColumn<?, ?> buscarMudanzaAyudanteTablaTipo;

    @FXML
    public void closeAyudante() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MudaFacilFx/InterfazMenuAyudante.fxml"));
            Parent root = loader.load();

            InterfazMenuAyudante controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(e -> controller.closeWindow());

            Stage myStage = (Stage) this.buscarMudanzaAyudanteTabla.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            Logger.getLogger(InterfazMenuCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void tomarMudanzaSiguiente(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MudaFacilFx/InterfazBuscarExitoso.fxml"));
            Parent root = loader.load();

            InterfazBuscarExitoso controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(e -> controller.closeAyudante());

            Stage myStage = (Stage) this.buscarMudanzaAyudanteBotonSeleccionar.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            Logger.getLogger(InterfazMenuCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
