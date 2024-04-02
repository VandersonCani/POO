package visual;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

	public static int chamadaMenu() {
		String [] opcoes = {"Cadastrar Produto", "Listar Produtos" , "Remover Produto", "Encerrar Programa"};
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
			int codigoProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto que deseja Remover: "));
			
			return codigoProduto;
	}

}
