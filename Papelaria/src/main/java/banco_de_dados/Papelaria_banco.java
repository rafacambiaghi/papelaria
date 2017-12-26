package banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ch.makery.address.model.Produto_papelaria;

public class Papelaria_banco {

	final String USUARIO = "root";
	final String SENHA = "admin";
	final String URL_BANCO = "jdbc:mysql://localhost:3306/papelaria";

	// constantes de acesso
	final String CLASSE_DRIVER = "com.mysql.jdbc.Driver";

	// comandos
	final String INSERIR = "INSERT INTO produto_papelaria(nome_do_produto, descricao, quantidade) VALUES(?, ?, ?)";
	final String ATUALIZAR = "UPDATE contas SET nome_do_produto=?, descricao=?, quantidade=? WHERE id = ?";
	final String BUSCAR = "SELECT id, nome_do_produto, descricao, quantidade FROM contas WHERE ID = ?";
	final String BUSCAR_TODOS = "SELECT id, nome_do_produto, descricao, quantidade FROM contas WHERE ID = ?\" FROM Produto_papelaria";
	final String APAGAR = "DELETE FROM contas WHERE id = ?";

	public void salvar(Produto_papelaria Papelaria) {
		try {
			Connection con = conexao();
			PreparedStatement salvar = con.prepareStatement(INSERIR);
			salvar.setString(1, Papelaria.getnome_do_produto());
			salvar.setString(2, Papelaria.getDescricao());
			salvar.setInt(3, Papelaria.getQuantidade());
			salvar.executeUpdate();
			salvar.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("ERROR SALVANDO CONTA");
			System.exit(0);
		}
	}

	public ArrayList<Produto_papelaria> buscarTodas() {
		ArrayList<Produto_papelaria> produtos = new ArrayList<>();
		try {
			Connection con = conexao();
			PreparedStatement buscarTodos = con.prepareStatement(BUSCAR_TODOS);
			ResultSet resultadoBusca = buscarTodos.executeQuery();
			while (resultadoBusca.next()) {
				Produto_papelaria Produto_papelaria = extraiConta(resultadoBusca);
				produtos.add(Produto_papelaria);
			}
			buscarTodos.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("ERROR BUSCANDO TODAS AS CONTAS.");
			System.exit(0);
		}
		return produtos;
	}

	public Produto_papelaria buscaPorId(int id) {
		Produto_papelaria papelaria = null;
		try {
			Connection con = conexao();
			PreparedStatement buscar = con.prepareStatement(BUSCAR);
			buscar.setInt(1, id);
			ResultSet resultadoBusca = buscar.executeQuery();
			resultadoBusca.next();
			papelaria = extraipapelaria(resultadoBusca);
			buscar.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("ERROR BUSCANDO CONTA COM ID " + id);
			System.exit(0);
		}
		return papelaria;
	}

	private Produto_papelaria extraipapelaria(ResultSet resultadoBusca) {
		// TODO Auto-generated method stub
		return null;
	}

	public void apagar(int id) {
		try {
			Connection con = conexao();
			PreparedStatement apagar = con.prepareStatement(APAGAR);
			apagar.setInt(1, id);
			apagar.executeUpdate();
			apagar.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("ERROR APAGANDO CONTA COM ID " + id);
			System.exit(0);
		}
	}

	public void atualizar(Produto_papelaria papelaria) {
		try {
			Connection con = conexao();
			PreparedStatement atualizar = con.prepareStatement(ATUALIZAR);
			atualizar.setString(1, papelaria.getnome_do_produto());
			atualizar.setString(2, papelaria.getDescricao());
			atualizar.setInt(3, papelaria.getQuantidade());
			atualizar.setInt(4, papelaria.getId());
			atualizar.executeUpdate();
			atualizar.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("ERROR ATUALIZANDO CONTA COM ID " + papelaria.getId());
			System.exit(0);
		}

	}

	// abre uma nova conexão com o banco de dados. Se algum erro for lançado
	// aqui, verifique o erro com atenção e se o banco está rodando
	private Connection conexao() {
		try {
			Class.forName(CLASSE_DRIVER);
			return DriverManager.getConnection(URL_BANCO, USUARIO, SENHA);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof ClassNotFoundException) {
				System.err.println("VERIFIQUE SE O DRIVER DO BANCO DE DADOS ESTÁ NO CLASSPATH");
			} else {
				System.err.println("VERIFIQUE SE O BANCO ESTÁ RODANDO E SE OS DADOS DE CONEXÃO ESTÃO CORRETOS");
			}
			System.exit(0);
			// o sistema deverá sair antes de chegar aqui...
			return null;
		}
	}

	// extrai no objeto Conta do result set
	private Produto_papelaria extraiConta(ResultSet resultadoBusca) throws SQLException, ParseException {
		Produto_papelaria papelaria = new Produto_papelaria();
		papelaria.setId(resultadoBusca.getInt(1));
		papelaria.setnome_do_produto(resultadoBusca.getString(2));
		papelaria.setDescricao(resultadoBusca.getString(3));
		papelaria.setQuantidade(resultadoBusca.getInt(4));
		return papelaria;
	}

}
