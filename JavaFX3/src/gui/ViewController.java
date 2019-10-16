package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ViewController {
	
	@FXML
	private Button tbTest;
	
	public void onBtTestAction() {
		//System.out.println("Click");
		Alerts.showAlert("Título do Alerta", "Cabeçalho do Alerta", "Olá", AlertType.CONFIRMATION);
	}
}
