package visualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.*;

public class entradaSaida {

	public static String solicitarModelo() {
		// TODO Auto-generated method stub
		String modelo = JOptionPane.showInputDialog("Qual o modelo do Veiculo?");

		return modelo;
	}

	public static String solicitarCor() {
		String cor = JOptionPane.showInputDialog("Qual a cor do Veiculo?");

		return cor;
	}

	public static int apresentaMenu() {
		String opcoes[] = { "Fabricar Carro", "Vender Carro", "Encerrar Programa" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a Opção Desejada", JOptionPane.OK_CANCEL_OPTION);

		return menu.getSelectedIndex();
	}

	public static void mostraCarro(Carro carro) {

		JOptionPane.showConfirmDialog(null, "Modelo: " + carro.getModelo() + "\nCor: " + carro.getCor(),
				"Confirma a criação do carro?", JOptionPane.OK_CANCEL_OPTION);

	}

	public static int solicitaQtdFabricar() {
		int qtdCarros = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Qual a Quantidade de Carros que você Deseja Fabricar?"));
		return qtdCarros;
	}

	public static int solicitaQualCarroVender(String txt) {
		int venderCarro = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual Carro você Deseja Vender?\n" + txt ));
		return venderCarro;
	}

	public static void encerraPrograma() {
		JOptionPane.showMessageDialog(null, "Obrigado por utilizar o programa!");
	}

}
