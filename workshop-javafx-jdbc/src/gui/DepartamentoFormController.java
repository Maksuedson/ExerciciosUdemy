package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.entidade.Departamento;
import modelo.exceptions.ValidationException;
import modelo.services.DepartamentoService;

public class DepartamentoFormController implements Initializable {
	private Departamento entidade;
	private DepartamentoService service;
	private List<DataChangeListener> dataChangeListener = new ArrayList<>();

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtNome;

	@FXML
	private Label labelErroNome;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btCancelar;

	public void setDepartamento(Departamento entidade) {
		this.entidade = entidade;
	}

	public void setDepartamentoService(DepartamentoService service) {
		this.service = service;
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

	private Departamento getFormData() {
		Departamento obj = new Departamento();

		ValidationException exception = new ValidationException("Erro de Validação");

		obj.setId(Utils.tryParseToInt(txtId.getText()));
		if (txtNome.getText() == null || txtNome.getText().trim().equals("")) {
			exception.addError("nome_departamento", "O campo não pode ser vazio");
		}
		obj.setNome(txtNome.getText());

		if (exception.getErros().size() > 0) {
			throw exception;
		}
		return obj;
	}

	private void setErrosMessages(Map<String, String> erros) {
		Set<String> campos = erros.keySet();

		if (campos.contains("nome_departamento")) {
			labelErroNome.setText(erros.get("nome_departamento"));
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rs) {
		initializeNodes();
	}

	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtNome, 30);
	}

	public void updateFormData() {
		if (entidade == null) {
			throw new IllegalStateException("Entidade estava nula");
		}
		txtId.setText(String.valueOf(entidade.getId()));
		txtNome.setText(entidade.getNome());
	}

}
