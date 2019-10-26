package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
import modelo.services.DepartamentoService;

public class MainViewController implements Initializable{
	@FXML
	private MenuItem menuitemvendedor;

	@FXML
	private MenuItem menuitemdepartamento;
	
	@FXML
	private MenuItem menuitemabout;
	
	@FXML
	public void onMenuItemAboutAction() {
	loadView("/gui/About.fxml", x -> {});
	}
	
	@FXML
	public void onMenuItemDepartamentoAction() {
		loadView("/gui/DepartamentoLista.fxml", (DepartamentoListController controller)-> {
		controller.setDepartamentoService(new DepartamentoService());
		controller.updateTableView();
		
		});
	}
	
	@FXML
	public void onMenuItemVendedorAction() {
	System.out.println("onMenuItemVendedorAction");
	}
	
	public synchronized <T> void loadView(String nomeAbsoluto, Consumer<T> inicializarAcao) {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeAbsoluto));
		VBox newvbox = loader.load();
		
		Scene scenePrincipal = Main.getScenePrincipal();
		VBox mainVbox = (VBox)((ScrollPane)scenePrincipal.getRoot()).getContent();
		
		Node mainMenu = mainVbox.getChildren().get(0);
		mainVbox.getChildren().clear();
		mainVbox.getChildren().add(mainMenu);
		mainVbox.getChildren().addAll(newvbox.getChildren());
		
		T controller = loader.getController();
		inicializarAcao.accept(controller);
		}
		catch(IOException e) {
			Alerts.showAlert("IO Exception", "Erro loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rs) {
		
	}

}
