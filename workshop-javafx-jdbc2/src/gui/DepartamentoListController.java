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
import modelo.services.DepartamentoService;

public class DepartamentoListController implements Initializable {
	private DepartamentoService service;
	
	@FXML
	private TableView<Departamento> tableViewDepartamento;
	
	@FXML
	private TableColumn<Departamento, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Departamento, String> tableColumnNome;
	
	@FXML
	private Button btNovo;
	
	private ObservableList<Departamento> obsList;
	
	@FXML
	public void onBtNovoAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		Departamento dep = new Departamento();
		createDialogForm(dep, "/gui/DepartamentoForm.fxml", parentStage);
		
	}
	
	public void setDepartamentoService (DepartamentoService service) {
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
		List<Departamento> list = service.bucarTodos();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartamento.setItems(obsList);
		
	}
	
	private void createDialogForm(Departamento obj, String nomeAbsoluto, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeAbsoluto));
			Pane pane = loader.load();
			
			DepartamentoFormController controller = loader.getController();
			controller.setDepartamento(obj);
			controller.setDepartamentoService(new DepartamentoService());
			controller.updateFormData();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Insira os dados do Departamento");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro carregando tela", e.getMessage(), AlertType.ERROR);
		}
	}

}
