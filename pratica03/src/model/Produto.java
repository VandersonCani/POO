package model;

import java.util.ArrayList;

public class Produto {
	int codigoProduto = 0;
	String nomeProduto = "";
	String descricao = "";
	double preco = 0.0;
	
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
		
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produto produtos = listaDeProdutos.get(i);
			
			txt += "Produto " + (i+1) +"\nCódigo: " + produtos.getCodigoProduto() + "\nNome Produto: " + produtos.getNomeProduto()
					+ "\nDescrição Produto: " + produtos.getDescricao() + "\nPreço: " + produtos.getPreco() + "\n\n";
		}
		return txt;
	}
	
	
	
}
