package visual;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.Produto;

public class EntradaSaida {

	public static int chamadaMenu() {
		String[] opcoes = { "Produto", "Listar Estoque", "Remove Produtos", "Encerrar Programa" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a Opcao Desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static int chamadaMenu2() {
		String[] opcoes = { "Cadastrar", "Receber", "Vender", "Encerrar Programa" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a Opcao Desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static String solicitaNomeProduto() {
		String nome = JOptionPane.showInputDialog("Digite o Nome do Produto: ");

		return nome;
	}

	public static String solicitaDescricaoProduto() {
		String descricao = JOptionPane.showInputDialog("Digite a descrição do Produto: ");

		return descricao;
	}

	public static int solicitaCodigoProduto() {
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o Código do Produto: "));

		return codigo;
	}

	public static double solicitaPrecoProduto() {
		double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite Preço do Produto: "));

		return preco;
	}

	public static int solicitaQualProdutoRemover() {
		int codigoProduto = Integer
				.parseInt(JOptionPane.showInputDialog("Digite o código do produto que deseja Remover: "));

		return codigoProduto;
	}

	public static void exibeErroSemProdutos() {
		JOptionPane.showMessageDialog(null, "Não há Produtos Cadastrados!");
	}

	public static int solicitaQuantidade(int quantidade2, boolean venda, String tipo) {
		boolean validaSolicita = false;
		do {
			int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite Quantidade a " + tipo + ": "));

			if (quantidade > quantidade2 && venda == true) {
				JOptionPane.showMessageDialog(null,
						"A quantidade de Venda é maior que a Quantidade de Estoque. \nQuantidade em Estoque: \n"
								+ quantidade2);
			} else {
				validaSolicita = true;
				return quantidade;
			}
		} while (validaSolicita != true);
		return quantidade2;
	}

	public static void exibeErroExclusaoComProdutosEmEstoque() {

		JOptionPane.showMessageDialog(null, "Você Está Tentando Excluir um Produto com Quantidade em Estoque. \n");

	}

	public static boolean confirmaPagamento(int quantidadeVenda, Produto produtos) {
		String opcoes1[] = { "SIM", "NÃO" };
		int retorno = 0;
		boolean confirma = false;

		double valorTotal = quantidadeVenda * produtos.getPreco();

		retorno = JOptionPane.showOptionDialog(null, "Valor Total a Receber: " + valorTotal + "\n\nConfirma Pagamento?",
				null, retorno, retorno, null, opcoes1, opcoes1);

		System.out.println(retorno);

		if (retorno == 0) {
			confirma = true;
		} else {
			confirma = false;
		}

		return confirma;
	}

	public static void exibeLista(String txt) {
		JOptionPane.showMessageDialog(null, txt);
	}

}
