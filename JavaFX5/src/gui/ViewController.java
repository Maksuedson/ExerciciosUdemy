package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable{
	@FXML
	private TextField txtNumero1;
	@FXML
	private TextField txtNumero2;
	@FXML
	private Label LblResultado;
	
	@FXML
	private Button btnSoma;
	
	public void onBtTestAction() {
		try {
		Locale.setDefault(Locale.US);
		double number1 = Double.parseDouble(txtNumero1.getText());
		double number2 = Double.parseDouble(txtNumero2.getText());
		
		double soma =  number1 +number2;
		
		LblResultado.setText(String.format("%.2f", soma));
		}catch (NumberFormatException e){
			Alerts.showAlert("Erro", "Parse erro", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rs) {
		Constraints.setTextFieldDouble(txtNumero1);
		Constraints.setTextFieldDouble(txtNumero2);
		Constraints.setTextFieldMaxLength(txtNumero1, 7);
		Constraints.setTextFieldMaxLength(txtNumero2, 7);
	}
}
