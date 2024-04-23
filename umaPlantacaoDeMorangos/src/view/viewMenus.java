package view;

import javax.swing.JComboBox;

import javax.swing.JOptionPane;

public class viewMenus {

	public static int MenuInicial() {
		String opcoes[] = { "Cadastrar Plantação", "Navegar Pela Plantação Cadastrada" };

		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a Opção Desejada: ", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static int navegacaoPlantacoes() {
			String opcoes[] = { "Movimentar Produção", "Movimentar Insumos", "Aplicar Venda"};
		
			JComboBox<String> menu = new JComboBox<String>(opcoes);
			JOptionPane.showConfirmDialog(null, menu, "Escolha o que deseja Atualizar", JOptionPane.OK_CANCEL_OPTION);
			return menu.getSelectedIndex();
	}

	public static int movimentarProducao() {
		String opcoes[] = { "Adicionar Produção", "Atualizar Produção", "Remover Produção"};
		
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Escolha o que deseja Atualizar", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static Object movimentarInsumos() {
		String opcoes[] = { "Adicionar Insumos", "Atualizar Insumos", "Remover Insumos"};
		
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Escolha o que deseja Atualizar", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
		
	}

	public static String SolicitaProducaoAplicarVenda() {
		
		return null;
	}


}
