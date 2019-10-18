package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import aplicacao.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{
	@FXML
	private MenuItem menuitemvendedor;

	@FXML
	private MenuItem menuitemdepartamento;

	@FXML
	private MenuItem menuitemabout;
	
	@FXML
	public void onMenuItemAboutAction() {
	loadView("/gui/About.fxml");
	}
	
	@FXML
	public void onMenuItemDepartamentoAction() {
		loadView("/gui/DepartamentoLista.fxml");
	}
	
	@FXML
	public void onMenuItemVendedorAction() {
	System.out.println("onMenuItemVendedorAction");
	}
	
	public synchronized void loadView(String nomeAbsoluto) {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeAbsoluto));
		VBox newvbox = loader.load();
		
		Scene scenePrincipal = Main.getScenePrincipal();
		VBox mainVbox = (VBox)((ScrollPane)scenePrincipal.getRoot()).getContent();
		
		Node mainMenu = mainVbox.getChildren().get(0);
		mainVbox.getChildren().clear();
		mainVbox.getChildren().add(mainMenu);
		mainVbox.getChildren().addAll(newvbox.getChildren());
		}
		catch(IOException e) {
			Alerts.showAlert("IO Exception", "Erro loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rs) {
		
	}

}
