package ch.makery.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Produto_papelaria {

		private int id;
		private String nome_do_produto;
		private String descricao;
		private int quantidade;
				

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getnome_do_produto() {
			return nome_do_produto;
		}

		public void setnome_do_produto(String nome_do_produto) {
			this.nome_do_produto = nome_do_produto;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public int getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}

		
	}
	
	
	
