package controler;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Produto;
import visual.EntradaSaida;

public class Controladora {

	public void exibeMenu() {

		ArrayList<Produto> listaDeProdutos = new ArrayList<>();
		ArrayList<Produto> listaDeVendas = new ArrayList<>();
		boolean validaMenu = false;
		int opcoes = 0;

		String tipo = " Receber";
		boolean validaVenda = true;
		int codigo = 0;

		do {
			opcoes = EntradaSaida.chamadaMenu();
			switch (opcoes) {

			case 0: // Produto
				opcoes = EntradaSaida.chamadaMenu2();
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

				case 1: // Receber Produtos
					tipo = " Receber";
					validaVenda = false;

					codigo = Integer.parseInt(JOptionPane.showInputDialog(Produto.listaProdutos(listaDeProdutos)
							+ "\n\nDigite o Código do Produto que deseja Receber: \n"));

					for (int i = 0; i < listaDeProdutos.size(); i++) {
						Produto produtos = listaDeProdutos.get(i);
						if (produtos.getCodigoProduto() == codigo) {

							int quantidade = produtos.getQuantidade();
							quantidade += EntradaSaida.solicitaQuantidade(quantidade, validaVenda, tipo);
							produtos.setQuantidade(quantidade);
						}
					}
					break;

				case 2: // Vender Produtos
					tipo = " Vender";
					validaVenda = true;

					codigo = Integer.parseInt(JOptionPane.showInputDialog(Produto.listaProdutos(listaDeProdutos)
							+ "\n\nDigite o Código do Produto que deseja Vender: \n"));

					for (int i = 0; i < listaDeProdutos.size(); i++) {
						Produto produtos = listaDeProdutos.get(i);
						if (produtos.getCodigoProduto() == codigo) {

							int quantidadeEstoque = produtos.getQuantidade();
							int quantidadeVenda = EntradaSaida.solicitaQuantidade(quantidadeEstoque, validaVenda, tipo);
							boolean confirmaVenda = EntradaSaida.confirmaPagamento(quantidadeVenda, produtos);
							
							if (confirmaVenda == true) {
								quantidadeEstoque -= quantidadeVenda;
								produtos.setQuantidade(quantidadeEstoque);

								Produto venda = new Produto();
								venda.setCodigoProduto(codigo);
								venda.setDescricao(produtos.getDescricao());
								venda.setNomeProduto(produtos.getNomeProduto());
								venda.setQuantidadeVendido(quantidadeVenda);
								double valorVenda = (produtos.getPreco() * venda.getQuantidadeVendido()); 
								venda.setValorTotalVendido(valorVenda);

								listaDeVendas.add(venda);
							} else {
								JOptionPane.showMessageDialog(null, "Pagamento Não Confirmado, Tente Novamente! \n");
							}
						
						produtos.listaVendas(listaDeVendas);
						
						}
					}
					
					break;
				}
				break;

			case 1: // Listar Estoque
				String txt = Produto.listaProdutos(listaDeProdutos);
				JOptionPane.showMessageDialog(null, txt);
				break;

			case 2: // Remove Produtos
				codigo = EntradaSaida.solicitaQualProdutoRemover();

				for (int i = 0; i < listaDeProdutos.size(); i++) {
					Produto produtos = listaDeProdutos.get(i);
					if (produtos.getCodigoProduto() == codigo) {
						if (produtos.getQuantidade() > 0) {
							EntradaSaida.exibeErroExclusaoComProdutosEmEstoque();
						} else {
							Produto.removeProduto(listaDeProdutos, codigo);
						}
					}
				}
				break;

			case 3: // Encerra Programa
				validaMenu = false;
				break;
			}
		} while (validaMenu == true);
	}
}
