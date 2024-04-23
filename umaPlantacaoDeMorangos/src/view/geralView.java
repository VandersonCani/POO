package view;

import javax.swing.JOptionPane;

public class geralView {

	public static String solicitaDataDaVenda() {
		String data = JOptionPane.showInputDialog("Digite a data da Venda: ");
		return data;
	}

	public static int solicitaQtdCaixas() {
		int qtdCaixas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de Caixas Vendidas: "));
		return qtdCaixas;
	
	}

	public static double solicitaValorRecebido() {
		double valorRecebido = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor Recebido: "));
		return valorRecebido;
	}
	
	public static String apresenta(String exibeTexto) {
		JOptionPane.showMessageDialog(null, exibeTexto);

		return exibeTexto;
	}

	public static int selecionaProducaoAtualizar(String exibeTexto) {
		
		int nroProducao = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero referente a produção a ser atualizada: " +  exibeTexto));
		
		return nroProducao;
		
		
	}

	public static int selecionaProducaoRemover(String exibeTexto) {
		
		int nroProducao = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero referente a produção a ser Removida: " +  exibeTexto));
		
		return nroProducao;
	}
}
