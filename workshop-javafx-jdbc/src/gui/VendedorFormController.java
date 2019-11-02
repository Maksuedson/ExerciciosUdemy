package gui;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import modelo.entidade.Departamento;
import modelo.entidade.Vendedor;
import modelo.exceptions.ValidationException;
import modelo.services.DepartamentoService;
import modelo.services.VendedorService;

public class VendedorFormController implements Initializable {
	private Vendedor entidade;
	private VendedorService service;
	private DepartamentoService departamentoService;
	private List<DataChangeListener> dataChangeListener = new ArrayList<>();

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtEmail;

	@FXML
	private DatePicker dpDataNasc;

	@FXML
	private TextField txtSalarioBase;

	@FXML
	private Label labelErroNome;

	@FXML
	private Label labelErroEmail;

	@FXML
	private Label labelErroDataNasc;

	@FXML
	private Label labelErroSalarioBase;

	@FXML
	private ComboBox<Departamento> comboBoxDepartamento;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btCancelar;

	private ObservableList<Departamento> obsList;

	public void setVendedor(Vendedor entidade) {
		this.entidade = entidade;
	}

	public void setServices(VendedorService service, DepartamentoService departamentoService) {
		this.service = service;
		this.departamentoService = departamentoService;
	}

	public void inscreveDataChangeListener(DataChangeListener listener) {
		dataChangeListener.add(listener);
	}

	@FXML
	public void onBtCancelarAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	@FXML
	public void onBtSalvarAction(ActionEvent event) {
		if (entidade == null) {
			throw new IllegalStateException("A entidade estava nula");
		}
		if (service == null) {
			throw new IllegalStateException("O serviço estava nulo");
		}
		try {
			entidade = getFormData();
			service.salvarOuAlterar(entidade);
			notificarDataChangeListeners();
			Utils.currentStage(event).close();

		} catch (ValidationException e) {
			setErrosMessages(e.getErros());
		} catch (DbException e) {
			Alerts.showAlert("Erro salvar objeto", null, e.getMessage(), Alert.AlertType.ERROR);
		}

	}

	private void notificarDataChangeListeners() {
		for (DataChangeListener listener : dataChangeListener) {
			listener.OnDataChange();
		}

	}

	private Vendedor getFormData() {
		Vendedor obj = new Vendedor();

		ValidationException exception = new ValidationException("Erro de Validação");

		obj.setId(Utils.tryParseToInt(txtId.getText()));

		if (txtNome.getText() == null || txtNome.getText().trim().equals("")) {
			exception.addError("nome", "O campo não pode ser vazio");
		}
		obj.setNome(txtNome.getText());

		if (txtEmail.getText() == null || txtEmail.getText().trim().equals("")) {
			exception.addError("email", "O campo não pode ser vazio");
		}
		obj.setEmail(txtEmail.getText());

		if (dpDataNasc.getValue() == null) {
			exception.addError("datanasc", "O campo não pode ser vazio");
		} else {
			Instant instant = Instant.from(dpDataNasc.getValue().atStartOfDay(ZoneId.systemDefault()));
			obj.setDataNasc(Date.from(instant));
		}

		if (txtSalarioBase.getText() == null || txtSalarioBase.getText().trim().equals("")) {
			exception.addError("salariobase", "O campo não pode ser vazio");
		}
		obj.setSalarioBase(Utils.tryParseToDouble(txtSalarioBase.getText()));
		
		obj.setDepartamento(comboBoxDepartamento.getValue());

		if (exception.getErros().size() > 0) {
			throw exception;
		}
		return obj;
	}

	private void setErrosMessages(Map<String, String> erros) {
		Set<String> campos = erros.keySet();
		labelErroNome.setText((campos.contains("nome") ? erros.get("nome") : ""));
		labelErroEmail.setText((campos.contains("email") ? erros.get("email") : ""));
		labelErroSalarioBase.setText((campos.contains("salariobase") ? erros.get("salariobase") : ""));
		labelErroDataNasc.setText((campos.contains("datanasc") ? erros.get("datanasc") : ""));
		
//		if (campos.contains("nome")) {
//			labelErroNome.setText(erros.get("nome"));
//		}
//		if (campos.contains("email")) {
//			labelErroEmail.setText(erros.get("email"));
//		}
//		if (campos.contains("salariobase")) {
//			labelErroSalarioBase.setText(erros.get("salariobase"));
//		}
//		if (campos.contains("datanasc")) {
//			labelErroDataNasc.setText(erros.get("datanasc"));
//		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rs) {
		initializeNodes();
	}

	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtNome, 70);
		Constraints.setTextFieldDouble(txtSalarioBase);
		Constraints.setTextFieldMaxLength(txtEmail, 70);
		Utils.formatDatePicker(dpDataNasc, "dd/MM/yyyy");
		initializeComboBoxDepartment();

	}

	public void updateFormData() {
		if (entidade == null) {
			throw new IllegalStateException("Entidade estava nula");
		}
		txtId.setText(String.valueOf(entidade.getId()));
		txtNome.setText(entidade.getNome());
		txtEmail.setText(entidade.getEmail());
		Locale.setDefault(Locale.US);
		txtSalarioBase.setText(String.format("%.2f", entidade.getSalarioBase()));
		if (entidade.getDataNasc() != null) {
			dpDataNasc.setValue(LocalDate.ofInstant(entidade.getDataNasc().toInstant(), ZoneId.systemDefault()));
		}
		if (entidade.getDepartamento() == null) {
			comboBoxDepartamento.getSelectionModel().selectFirst();
		} else {
			comboBoxDepartamento.setValue(entidade.getDepartamento());
		}
	}

	public void objetosAssociados() {
		if (departamentoService == null) {
			throw new IllegalStateException("DepartamentoService estava nulo");
		}
		List<Departamento> list = departamentoService.bucarTodos();
		obsList = FXCollections.observableArrayList(list);
		comboBoxDepartamento.setItems(obsList);
	}

	private void initializeComboBoxDepartment() {
		Callback<ListView<Departamento>, ListCell<Departamento>> factory = lv -> new ListCell<Departamento>() {
			@Override
			protected void updateItem(Departamento item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getNome());
			}
		};
		comboBoxDepartamento.setCellFactory(factory);
		comboBoxDepartamento.setButtonCell(factory.call(null));
	}

}
