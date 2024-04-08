package model;

import java.util.ArrayList;

import visual.EntradaSaida;

public class Produto {
	int codigoProduto = 0;
	String nomeProduto = "";
	String descricao = "";
	double preco = 0.0;
	int quantidade = 0;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;

	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public static String listaProdutos(ArrayList<Produto> listaDeProdutos) {
		String txt = "Lista de Produtos \n\n";
		boolean validaMsg = false;

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produto produtos = listaDeProdutos.get(i);

			if (produtos.getNomeProduto() == "" || produtos.getNomeProduto() == null) {
				validaMsg = false;
			} else {
				txt += "Produto " + (i + 1) + "\nCódigo: " + produtos.getCodigoProduto() + "\nNome Produto: "
						+ produtos.getNomeProduto() + "\nDescrição Produto: " + produtos.getDescricao() + "\nPreço: "
						+ produtos.getPreco() + "\nQuantidade: " + produtos.getQuantidade();
				validaMsg = true;
			}
		}
		if (validaMsg == false) {
			EntradaSaida.exibeErroSemProdutos();
		}
		return txt;
	}

	public static void removeProduto(ArrayList<Produto> listaDeProdutos, int codigo) {

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produto produto1 = listaDeProdutos.get(i);

			if (produto1.getCodigoProduto() == codigo) {
				listaDeProdutos.remove(i);
			}
		}
	}
}
