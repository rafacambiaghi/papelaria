package ch.makery.address.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import banco_de_dados.Papelaria_banco;
import ch.makery.address.model.Produto_papelaria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PapelariaViewController implements Initializable {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	 @FXML
	private Label txtLabel;

	@FXML
    private Button txtbuscar;

    @FXML
    private Button txtdeletar;

    @FXML
    private Button txteditar;

    @FXML
    private Button txtinserir;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Produto_papelaria> Buscar() {

		Papelaria_banco dao = new Papelaria_banco();

		System.out.print("Sucesso");
		return dao.buscarTodas();

	}
	 @FXML
	    void busca(ActionEvent event) {
		 
		 
	    }

	    @FXML
	    void deleta(ActionEvent event) {
	    }

	    @FXML
	    void edita(ActionEvent event) {
	    }

	    @FXML
	    void insere(ActionEvent event) {
	    }


}
