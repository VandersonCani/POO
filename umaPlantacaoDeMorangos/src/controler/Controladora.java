package controler;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Plantacao;
import model.Producao;
import view.geralView;
import view.viewCadastroPlantacao;
import view.viewMenus;

public class Controladora {
	static ArrayList<Plantacao> listaPlantacao = new ArrayList<>();
	ArrayList<String> nomes = new ArrayList<>();
	static ArrayList<Producao> listaProducao = new ArrayList<>();
	static String exibeTexto;
	
	public void minhaPlantacao() {
		boolean validaMenu = false;

		do {
			int opcoesMenu = viewMenus.MenuInicial();

			switch (opcoesMenu) {

			case 0: // Cadastra Plantacao e Terreno

				Plantacao plantacao = new Plantacao();

				plantacao.setDono(viewCadastroPlantacao.solicitaNomeDono());
				plantacao.setEndereco(viewCadastroPlantacao.solicitaEndereco());
				plantacao.setMetrosQuadrados(viewCadastroPlantacao.solicitaMetragem());
				plantacao.setDataDeCadastro(viewCadastroPlantacao.solicitaData());
				plantacao.setProducao(null);
				plantacao.setInsumos(null);
				listaPlantacao.add(plantacao);
				break;

			case 1: // Navega Pela Plantacao Escolhida
				String exibeTexto = listaDonosDasPlantacoes();
				String plantacaoSelecionada = viewCadastroPlantacao.solicitaPlantacaoDesejada(exibeTexto);
				validaPlantacao(plantacaoSelecionada);
				break;

			}
		} while (validaMenu != true);
	}

	public static void movimentarProducao(int opcoesMenu, Plantacao plantacao, int posicaoPlantacao) {

		switch (opcoesMenu) {

		case 0: // Adicionar Produção
			Producao producao = new Producao();
			producao.setDataVenda(geralView.solicitaDataDaVenda());
			producao.setCaixasColhidas(geralView.solicitaQtdCaixas());
			producao.setValorRecebido(geralView.solicitaValorRecebido());
			plantacao.setProducao(producao);
			break;

		case 1: // Atualizar Produção
			
			exibeTexto = listaProducao();
			int producaoAtualizar = geralView.selecionaProducaoAtualizar(exibeTexto);
			
			atualizarProducao(producaoAtualizar, posicaoPlantacao);
			
			break;

		case 2: // Remover Produção
			exibeTexto = listaProducao();
			int producaoRemover = geralView.selecionaProducaoRemover(exibeTexto);
			removerProducao(producaoRemover, producaoRemover);
			
			break;

		}
	}

	private static void removerProducao(int producaoRemover, int posicaoPlantacao) {
		listaPlantacao.remove(producaoRemover - 1);
	}

	private static void atualizarProducao(int producaoAtualizar, int posicaoPlantacao) {
		
		Plantacao plantacao = listaPlantacao.get(posicaoPlantacao);
		for(int i = 0 ; i < listaProducao.size(); i++) {
			if(i == producaoAtualizar - 1) {
				Producao producao = listaProducao.get(i);
				producao.setDataVenda(geralView.solicitaDataDaVenda());
				producao.setCaixasColhidas(geralView.solicitaQtdCaixas());
				producao.setValorRecebido(geralView.solicitaValorRecebido());
				plantacao.setProducao(producao);
			}
		}
	}

	private String listaDonosDasPlantacoes() {

		String txt = "Plantações Cadastradas\n\n";
		for (int i = 0; i < listaPlantacao.size(); i++) {
			if (i == 0) {
				Plantacao plantacao = listaPlantacao.get(i);
				txt += "Nome: " + plantacao.getDono();
			}
		}
		return txt;
	}

	private void validaPlantacao(String plantacaoSelecionada) {
		for (int i = 0; i < listaPlantacao.size(); i++) {
			Plantacao plantacao = listaPlantacao.get(i);
			
			if (plantacao.getDono().equals(plantacaoSelecionada)) {
				int posicaoPlantacao = i;
				int opcoesMenu = viewMenus.navegacaoPlantacoes();
				
				navegarPlantacaoAteQue(opcoesMenu, plantacao, posicaoPlantacao);
			}
		}
	}

	private static String listaProducao() {
		String txt = "Lista Producao \n\n";
		for (int i = 0; i < listaProducao.size(); i++) {

			Producao producao = listaProducao.get(i);
			txt += (i + 1);
			txt += "Qtd Colhida: " + producao.getCaixasColhidas() + "\n";
			txt += "Data Venda: " + producao.getDataVenda() + "\n";
			txt += "Valor Recebido: " + producao.getValorRecebido() + "\n\n";
		}

		return txt;
	}
	
	public void navegarPlantacaoAteQue(int opcoesMenu, Plantacao plantacao, int posicaoPlantacao) {
		boolean validaMenu = false;

		do {
			switch (opcoesMenu) {

			case 0: // Movimentar Produção
				Controladora.movimentarProducao(viewMenus.movimentarProducao(), plantacao, posicaoPlantacao);
				break;

			case 1: // Movimentar Insumos
				movimentarInsumos(viewMenus.movimentarInsumos(), plantacao);
				
				break;

			case 2: // Aplicar Venda
				String txt = aplicarVenda(viewMenus.SolicitaProducaoAplicarVenda());
				JOptionPane.showMessageDialog(null, txt); 
				break;
			}
		} while (validaMenu != true);
	}

	private String aplicarVenda(String solicitaProducaoAplicarVenda) {
		// TODO Auto-generated method stub
		return null;
	}

	private void movimentarInsumos(Object movimentarInsumos, Plantacao plantacao) {
		// TODO Auto-generated method stub
		
	}
}
