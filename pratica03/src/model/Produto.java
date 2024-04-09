package model;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import visual.EntradaSaida;

public class Produto {
	int codigoProduto = 0;
	String nomeProduto = "";
	String descricao = "";
	double preco = 0.0;
	int quantidade = 0;
	int quantidadeVendido = 0;
	double valorTotalVendido = 0.0;
	Date data;

	public double getValorTotalVendido() {
		return valorTotalVendido;
	}

	public void setValorTotalVendido(double valorTotal) {
		this.valorTotalVendido = valorTotal;
	}

	public int getQuantidadeVendido() {
		return quantidadeVendido;
	}

	public void setQuantidadeVendido(int quantidadeVendido) {
		this.quantidadeVendido = quantidadeVendido;
	}

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

	public void listaVendas(ArrayList<Produto> listaDeVendas) {
		String txt = "";
		for (int i = 0; i < listaDeVendas.size(); i++) {
			Produto vendas = listaDeVendas.get(i);

			txt = "Produto " + (i + 1) + "\nCódigo: " + vendas.getCodigoProduto() + "\nNome Produto: "
					+ vendas.getNomeProduto() + "\nDescrição Produto: " + vendas.getDescricao() + "\nPreço: "
					+ vendas.getPreco() + "\nQuantidade: " + vendas.getQuantidade();
		}
		JOptionPane.showMessageDialog(null, txt);
	}
}
