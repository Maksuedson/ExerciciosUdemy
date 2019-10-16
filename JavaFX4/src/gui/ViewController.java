package gui;

import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {
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
}
