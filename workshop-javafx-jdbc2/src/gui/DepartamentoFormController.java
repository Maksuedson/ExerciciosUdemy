package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import gui.util.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.entidade.Departamento;
import modelo.services.DepartamentoService;

public class DepartamentoFormController implements Initializable {	
	private Departamento entidade;
	private DepartamentoService service;
	
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
	
	@FXML
	public void onBtCancelarAction() {
	}
	
	@FXML
	public void onBtSalvarAction() {
		entidade = getFormData();
		service.salvarOuAlterar(entidade);
	}	
	
	private Departamento getFormData() {
		Departamento obj  = new Departamento();
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setNome(txtNome.getText());
		return obj;
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
