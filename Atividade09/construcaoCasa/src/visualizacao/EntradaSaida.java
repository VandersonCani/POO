package visualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

	public static int SolicitaOpcao() {

		String[] opcoes = { "Construir Casa", "Movimentar Portas Ou Janelas", "ver Informações da casa",
				"Sair do Programa" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a Opção Desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();

	}

	public static void exibeMsgEncerraPrograma() {

		JOptionPane.showMessageDialog(null, "O programa será Encerrado");

	}

	public static String solicitaDescricao(String descricao, int ordem) {
		if (ordem == 0) {
			return JOptionPane.showInputDialog("Informe a Descrição da " + descricao);
		} else {
			return JOptionPane.showInputDialog("Informe a Descrição da " + ordem + " " + descricao);
		}
	}

	public static String solicitaCor() {

		return JOptionPane.showInputDialog("Informe a cor da casa: ");

	}

	public static int solicitaQtdAberturas(String abertura) {

		return Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de " + abertura));

	}

	public static int solicitaEstado(String tipoAbertura) {
		String[] opcoes = { "Fechada", "Aberta" };

		return JOptionPane.showOptionDialog(null, "Informe o estado da " + tipoAbertura, "Estado",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[1]);

	}
}