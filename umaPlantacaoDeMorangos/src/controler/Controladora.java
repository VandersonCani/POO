package controler;

import java.util.ArrayList;
import model.Plantacao;
import view.geralView;
import view.viewCadastroPlantacao;
import view.viewMenus;

public class Controladora {
	ArrayList<Plantacao> listaPlantacao = new ArrayList<>();
	ArrayList<String> nomes = new ArrayList<>();

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
				String plantacaoSelecionada = viewCadastroPlantacao.solicitaPlantacaoDesejada(geralView.apresenta(exibeTexto));
				validaPlantacao(plantacaoSelecionada);
				break;

			}
		} while (validaMenu != true);
	}
	
	private String listaDonosDasPlantacoes() {

		String txt = "Plantações Cadastradas\n\n";
		for (int i = 0; i < listaPlantacao.size(); i++) {
			if (i == 0) {
				Plantacao plantacao = listaPlantacao.get(i);
				plantacao.getDono();
				txt += "Nome: ";
			}
		}
		return txt;
	}

	private void validaPlantacao(String plantacaoSelecionada) {
		for (int i = 0; i < listaPlantacao.size(); i++) {
			Plantacao plantacao = listaPlantacao.get(i);
			if (plantacao.getDono() == plantacaoSelecionada) {
				int opcoesMenu = viewMenus.navegacaoPlantacoes();
				plantacao.navegarPlantacaoAteQue(opcoesMenu, plantacao);
			}
		}
	}
}
