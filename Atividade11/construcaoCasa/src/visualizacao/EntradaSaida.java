package visualizacao;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import modelo.Aberturas;

public class EntradaSaida {

	public static int solicitaOpcao() {

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

	public static String solicitaTipoAbertura() {
		String[] opcoes = { "Porta", "Janela" };

		int tipoAbertura = JOptionPane.showOptionDialog(null, "Informe qual tipo de Abertura deseja movimentar",
				"Mover Abertura", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
	
		if (tipoAbertura == 0) {
			return "Porta";
		} else {
			return "Janela";
		}
	}

	@SuppressWarnings("unused")
	public static int solicitaAberturaMover(ArrayList<Aberturas> listaDeAberturas) {
		String tipoAbertura = listaDeAberturas.get(0).getClass().getName();
		tipoAbertura = tipoAbertura.replaceAll("modelo.", "");
		int qtdeAbertura = listaDeAberturas.size();
		String[] descricoesAberturas = new String[qtdeAbertura];

		for (int i = 0; i < qtdeAbertura; i++) {
			descricoesAberturas[i] = listaDeAberturas.get(i).getDescricao();
			return 0;
		}
		String msg = "Escolha a " + tipoAbertura + " a ser Movimentada";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox exibicaoAberturas = new JComboBox(descricoesAberturas);
		int confirmacao = JOptionPane.showConfirmDialog(null, exibicaoAberturas, msg, JOptionPane.OK_CANCEL_OPTION);

		if (confirmacao == 0) {
			return exibicaoAberturas.getSelectedIndex();
		} else {
			return -1;
		}
	}

	public static void exibeMsgAbertura() {
	JOptionPane.showMessageDialog(null,  "Nenhuma abertura será Movimentada");
		
	}
	public static void exibeInfoCasa(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Informações da Casa", JOptionPane.INFORMATION_MESSAGE);
	}
}
