package ch.makery.address;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApp extends Application {

	private AnchorPane pane;
	private TextField txLogin;
	private PasswordField txSenha;
	private Button btEntrar;
	private Button btSair;

	private void initComponents() {
		pane = new AnchorPane();
		pane.setPrefSize(400, 300);
		txLogin = new TextField();
		txLogin.setPromptText("Digite seu login");
		txSenha = new PasswordField();
		txSenha.setPromptText("Digite aqui sua senha");
		btEntrar = new Button("Entrar");
		btSair = new Button("Sair");
		pane.getChildren().addAll(txLogin, txSenha, btEntrar, btSair);
	}

	private void initLayout() {
		txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
		txLogin.setLayoutY(50);
		txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
		txSenha.setLayoutY(100);
		btEntrar.setLayoutX((pane.getWidth() - btEntrar.getWidth()) / 2);
		btEntrar.setLayoutY(150);
		btEntrar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				verificarCamposPreenchidos();
			}
		});
		btSair.setLayoutX((pane.getWidth() - btSair.getWidth()) / 2);
		btSair.setLayoutY(200);
		btSair.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				fecharAplicacao();
			}
		});
	}

	private void fecharAplicacao() {
		System.exit(0);
	}

	private void verificarCamposPreenchidos() {
		if (txLogin.getText().equals("admin") && txSenha.getText().equals("admin")) {
			// TODO Abrir a tela VitrineApp
			try {
				new MainApp().start(new Stage());
				LoginApp.getStage().close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private static Stage getStage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void start(Stage stage) throws Exception {
		initComponents();
		initLayout();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		// Remove a opção de maximizar a tela
		stage.setResizable(false);
		// Dá um título para a tela
		stage.setTitle("Login - Papelaria");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
