package MudaFacilFx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entity.Articulo;


public class InterfazAgregarArticuloCliente {

    @FXML
    private TextField agregarArticulosClienteNombre;

    @FXML
    private TextField agregarArticulosClienteLargo;

    @FXML
    private TextField agregarArticulosClienteAncho;

    @FXML
    private TextField agregarArticulosClienteAlto;

    @FXML
    private Button agregarArticulosClienteBotonAgregar;

    @FXML
    private Button agregarArticulosClienteBotonSiguiente;

    @FXML
    private TableView<Articulo> agregarArticulosClienteTabla;

    @FXML
    private TableColumn<?, ?> agregarArticulosClienteTablaNombre;

    @FXML
    private TableColumn<?, ?> agregarArticulosClienteTablaLargo;

    @FXML
    private TableColumn<?, ?> agregarArticulosClienteTablaAlto;

    @FXML
    private TableColumn<?, ?> agregarArticulosClienteTablaAncho;

    @FXML
    private TableColumn<?, ?> agregarArticulosClienteTablaPeso;

    @FXML
    private TextField agregarArticulosClientePeso;

    @FXML
    private ChoiceBox<Integer> agregarArticulosClienteCantAyudantes;

    private Integer [] numAyudantes = {0,1,2};

    private ObservableList<Articulo> articulos;

    public void initialize(){
        agregarArticulosClienteCantAyudantes.getItems().addAll(numAyudantes);
        articulos = FXCollections.observableArrayList();

        this.agregarArticulosClienteTablaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.agregarArticulosClienteTablaAncho.setCellValueFactory(new PropertyValueFactory("ancho"));
        this.agregarArticulosClienteTablaAlto.setCellValueFactory(new PropertyValueFactory("alto"));
        this.agregarArticulosClienteTablaLargo.setCellValueFactory(new PropertyValueFactory("largo"));
        this.agregarArticulosClienteTablaPeso.setCellValueFactory(new PropertyValueFactory("peso"));



    }

    @FXML
    public void closeWindow(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MudaFacilFx/InterfazCrearMudanzaCliente.fxml"));
            Parent root = loader.load();

            InterfazCrearMudanzaCliente controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(e -> controller.closeWindow());

            Stage myStage = (Stage) this.agregarArticulosClienteAlto.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            Logger.getLogger(InterfazMenuCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void botonAgregar(ActionEvent event) {


        String nombre = agregarArticulosClienteNombre.getText();
        int largo = Integer.parseInt(agregarArticulosClienteLargo.getText());
        int ancho = Integer.parseInt(agregarArticulosClienteAncho.getText());
        int alto = Integer.parseInt(agregarArticulosClienteAlto.getText());
        int peso = Integer.parseInt(agregarArticulosClientePeso.getText());

        //ControllerDB.agregarArticuloMudanza(nombre,largo,ancho,alto,peso);
        Articulo aux= new Articulo(nombre,largo,ancho,alto,peso);
       // int volumen= largo*ancho*alto;

        this.articulos.add(aux);
        this.agregarArticulosClienteTabla.setItems(articulos);





    }

    @FXML
    void agregarSiguiente(ActionEvent event) {
        try{
            Integer[] cantiAyudantes = numAyudantes;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MudaFacilFx/InterfazCosto.fxml"));
            Parent root = loader.load();

            InterfazCostoTamanio controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(e -> controller.closeWindow());

            Stage myStage = (Stage) this.agregarArticulosClienteBotonSiguiente.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            Logger.getLogger(InterfazMenuCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    
}
