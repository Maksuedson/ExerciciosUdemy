package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import aplicacao.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.entidade.Departamento;
import modelo.services.DepartamentoServices;

public class DepartamentoListController implements Initializable {
	private DepartamentoServices service;
	
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
	public void onBtNovoAction() {
		System.out.println("onBtNovoAction");
	}
	
	public void setDepartamentoService (DepartamentoServices service) {
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

}
