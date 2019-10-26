package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import aplicacao.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.entidade.Departamento;
import modelo.entidade.Vendedor;
import modelo.services.DepartamentoService;
import modelo.services.VendedorService;

public class VendedorListController implements Initializable {
	private VendedorService service;
	
	@FXML
	private TableView<Vendedor> tableViewDepartamento;
	
	@FXML
	private TableColumn<Vendedor, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Vendedor, String> tableColumnNome;
	
	@FXML
	private Button btNovo;
	
	private ObservableList<Vendedor> obsList;
	
	/*
	 * @FXML public void onBtNovoAction(ActionEvent event) { Stage parentStage =
	 * Utils.currentStage(event); Vendedor obj = new Vendedor();
	 * createDialogForm(obj, "/gui/VendedorForm.fxml", parentStage);
	 * 
	 * }
	 */
	
	public void setVendedorService (VendedorService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle rs) {
		iniciarNodes();
	}

	private void iniciarNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		
		//para a tableview ocupar toda a tela
		Stage stage = (Stage) Main.getScenePrincipal().getWindow();
		tableViewDepartamento.prefHeightProperty().bind(stage.heightProperty());		
	}
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service estava null");
		}
		List<Vendedor> list = service.buscarTodos();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartamento.setItems(obsList);
		
	}
	
	/*
	 * private void createDialogForm(Vendedor obj, String nomeAbsoluto, Stage
	 * parentStage) { try { FXMLLoader loader = new
	 * FXMLLoader(getClass().getResource(nomeAbsoluto)); Pane pane = loader.load();
	 * 
	 * VendedorFormController controller = loader.getController();
	 * controller.setDepartamento(obj); controller.setDepartamentoService(new
	 * DepartamentoService()); controller.updateFormData();
	 * 
	 * Stage dialogStage = new Stage();
	 * dialogStage.setTitle("Insira os dados do Departamento");
	 * dialogStage.setScene(new Scene(pane)); dialogStage.setResizable(false);
	 * dialogStage.initOwner(parentStage);
	 * dialogStage.initModality(Modality.WINDOW_MODAL); dialogStage.showAndWait(); }
	 * catch (IOException e) { Alerts.showAlert("IO Exception",
	 * "Erro carregando tela", e.getMessage(), AlertType.ERROR); } }
	 */

}
