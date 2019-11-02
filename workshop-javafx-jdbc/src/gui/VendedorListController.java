package gui;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import aplicacao.Main;
import db.DbIntegrityException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.entidade.Vendedor;
import modelo.services.DepartamentoService;
import modelo.services.VendedorService;

public class VendedorListController implements Initializable, DataChangeListener {
	private VendedorService service;

	@FXML
	private TableView<Vendedor> tableViewVendedor;

	@FXML
	private TableColumn<Vendedor, Integer> tableColumnId;

	@FXML
	private TableColumn<Vendedor, String> tableColumnNome;
	
	@FXML
	private TableColumn<Vendedor, String> tableColumnEmail;
	
	@FXML
	private TableColumn<Vendedor, Date> tableColumnDataNasc;
	
	@FXML
	private TableColumn<Vendedor, Double> tableColumnSalarioBase;	

	@FXML
	private TableColumn<Vendedor, Vendedor> tableColumnEDIT;

	@FXML
	private TableColumn<Vendedor, Vendedor> tableColumnEXCLUIR;

	@FXML
	private Button btNovo;

	private ObservableList<Vendedor> obsList;

	@FXML
	public void onBtNovoAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		Vendedor dep = new Vendedor();
		createDialogForm(dep, "/gui/VendedorForm.fxml", parentStage);

	}

	public void setVendedorService(VendedorService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle rs) {
		iniciarNodes();
	}

	private void iniciarNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		tableColumnDataNasc.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
		Utils.formatTableColumnDate(tableColumnDataNasc, "dd/MM/yyyy");
		tableColumnSalarioBase.setCellValueFactory(new PropertyValueFactory<>("SalarioBase"));
		Utils.formatTableColumnDouble(tableColumnSalarioBase, 2);

		// para a tableview ocupar toda a tela
		Stage stage = (Stage) Main.getScenePrincipal().getWindow();
		tableViewVendedor.prefHeightProperty().bind(stage.heightProperty());
	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service estava null");
		}
		List<Vendedor> list = service.buscarTodos();
		obsList = FXCollections.observableArrayList(list);
		tableViewVendedor.setItems(obsList);
		initEditButtons();
		initRemoveButtons();

	}

	
	  private void createDialogForm(Vendedor obj, String nomeAbsoluto, Stage parentStage) { 
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeAbsoluto));
			Pane pane = loader.load();

			VendedorFormController controller = loader.getController();
			controller.setVendedor(obj);
			controller.setServices(new VendedorService(), new DepartamentoService());
			controller.objetosAssociados();
			controller.inscreveDataChangeListener(this);
			controller.updateFormData();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Insira os dados do Vendedor");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			Alerts.showAlert("IO Exception", "Erro carregando tela", e.getMessage(), AlertType.ERROR);
		}
			  }
	 

	@Override
	public void OnDataChange() {
		updateTableView();
	}

	private void initEditButtons() {
		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEDIT.setCellFactory(param -> new TableCell<Vendedor, Vendedor>() {
			private final Button button = new Button("editar");

			@Override
			protected void updateItem(Vendedor obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> createDialogForm(obj, "/gui/VendedorForm.fxml", Utils.currentStage(event)));
			}
		});
	}

	private void initRemoveButtons() {
		tableColumnEXCLUIR.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEXCLUIR.setCellFactory(param -> new TableCell<Vendedor, Vendedor>() {
			private final Button button = new Button("remove");

			@Override
			protected void updateItem(Vendedor obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> removeEntity(obj));
			}
		});
	}

	private void removeEntity(Vendedor obj) {
		Optional<ButtonType> result = Alerts.showConfirmation("Confirmação", "Você tem certeza que quer deletar");
		
		if (result.get() == ButtonType.OK) {
			if (service == null) {
				throw new IllegalStateException("O serviço estava nulo");
			}
			try {
				service.deletar(obj);
				updateTableView();
			} catch (DbIntegrityException e) {
				Alerts.showAlert("Erro deletar objeto", null, e.getMessage(), AlertType.ERROR);
			}			
		}
	}	

}
