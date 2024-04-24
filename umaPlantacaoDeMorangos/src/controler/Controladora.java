package controler;

import java.util.ArrayList;
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
				plantacao.setListaProducao(null);
				listaPlantacao.add(plantacao);
				break;

			case 1: // Navega Pela Plantacao Escolhida
				String exibeTexto = listaDonosDasPlantacoes();
				String plantacaoSelecionada = viewCadastroPlantacao.solicitaPlantacaoDesejada(exibeTexto);
				validaPlantacao(plantacaoSelecionada);
				break;

			case 2:
				validaMenu = true;
				encerraPrograma();
				break;

			}
		} while (validaMenu != true);
	}

	public static boolean movimentarProducao(int opcoesMenu, Plantacao plantacao, int posicaoPlantacao) {
		boolean validaMenu = false;
		switch (opcoesMenu) {

		case 0: // Adicionar Produção
			Producao producao = new Producao();
			producao.setDataVenda(geralView.solicitaDataDaVenda());
			producao.setCaixasColhidas(geralView.solicitaQtdCaixas());
			producao.setValorRecebido(geralView.solicitaValorRecebido());
			listaProducao.add(producao);
			plantacao.setListaProducao(listaProducao);

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

		case 3:
			exibeTexto = listaProducao();
			geralView.apresenta(exibeTexto);
			break;
			
		case 4:
			validaMenu = true;
			break;
			
		case 5:
			validaMenu = true;
			encerraPrograma();
			break;

		}
		return validaMenu;
	}

	private static void removerProducao(int producaoRemover, int posicaoPlantacao) {
	
		listaProducao.remove(producaoRemover - 1);
	}

	private static void atualizarProducao(int producaoAtualizar, int posicaoPlantacao) {

		Plantacao plantacao = listaPlantacao.get(posicaoPlantacao);
		for (int i = 0; i < listaProducao.size(); i++) {
			if (i == (producaoAtualizar - 1)) {
				Producao producao = listaProducao.get(i);

				producao.setDataVenda(geralView.solicitaDataDaVenda());
				producao.setCaixasColhidas(geralView.solicitaQtdCaixas());
				producao.setValorRecebido(geralView.solicitaValorRecebido());
				listaProducao.set(i, producao);
				plantacao.setListaProducao(listaProducao);
			}
		}
	}

	private String listaDonosDasPlantacoes() {

		String txt = "Plantações Cadastradas\n\n";
		for (int i = 0; i < listaPlantacao.size(); i++) {

			Plantacao plantacao = listaPlantacao.get(i);
			txt += "Nome: " + plantacao.getDono() + "\n";

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
		String txt = "\n\nLista Producao \n\n";

		for (int i = 0; i < listaProducao.size(); i++) {

			Producao producao = listaProducao.get(i);
			txt += (i + 1) + "º \n";
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
				validaMenu = Controladora.movimentarProducao(viewMenus.movimentarProducao(), plantacao, posicaoPlantacao);
				break;

			case 1:
				validaMenu = true;
				break;
			case 2:
				validaMenu = true;
				encerraPrograma();
				break;
			}
		} while (validaMenu != true);
	}

	private static void encerraPrograma() {
		geralView.encerraPrograma();
	}
}
