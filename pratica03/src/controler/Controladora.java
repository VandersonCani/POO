package controler;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Produto;
import visual.EntradaSaida;

public class Controladora {

	public void exibeMenu() {
		boolean validaMenu = false;
		int opcoes = 0;
		ArrayList<Produto> listaDeProdutos = new ArrayList<>();

		do {
			opcoes = EntradaSaida.chamadaMenu();

			switch (opcoes) {
			case 0: // Cadastra Produtos
				Produto produto = new Produto();
				produto.setCodigoProduto(EntradaSaida.solicitaCodigoProduto());
				produto.setNomeProduto(EntradaSaida.solicitaNomeProduto());
				produto.setDescricao(EntradaSaida.solicitaDescricaoProduto());
				produto.setPreco(EntradaSaida.solicitaPrecoProduto());
				listaDeProdutos.add(produto);
				validaMenu = true;
				break;

			case 1: // Lista Produtos
				String txt = Produto.listaProdutos(listaDeProdutos);
				JOptionPane.showMessageDialog(null, txt);
				break;

			case 2: // Remove Produtos
				
				break;

			case 3: // Encerra Programa

				break;
			}

		} while (validaMenu == true);
	}
}
