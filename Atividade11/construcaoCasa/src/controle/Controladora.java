package controle;

import java.util.ArrayList;
import visualizacao.EntradaSaida;
import modelo.*;

public class Controladora {

	Casa casa = null;

	public void ExibeMenu() {
		int opcao;
		do {
			opcao = EntradaSaida.solicitaOpcao();

			switch (opcao) {

			case 0:
				int qtd = 0;
				int qtdPortas = 0;
				int qtdJanelas = 0;

				this.casa = new Casa();
				String descricao = EntradaSaida.solicitaDescricao("Casa", 0);
				String cor = EntradaSaida.solicitaCor();

				while (qtd <= 0) {
					qtdPortas = EntradaSaida.solicitaQtdAberturas("Portas");
					qtd = qtdPortas;
				}
				qtd = 0;
				while (qtd <= 0) {
					qtdJanelas = EntradaSaida.solicitaQtdAberturas("Janelas");
					qtd = qtdPortas;
				}
				qtd = 0;
				
				ArrayList<Aberturas> listaDePortas = new ArrayList<Aberturas>();

				for (int i = 0; i < qtdPortas; i++) {
					Porta porta = new Porta();
					porta.setDescricao(EntradaSaida.solicitaDescricao("Porta", (i + 1)));
					porta.setEstado(EntradaSaida.solicitaEstado("Porta"));
					listaDePortas.add(porta);
				}

				ArrayList<Aberturas> listaDeJanelas = new ArrayList<Aberturas>();

				for (int i = 0; i < qtdJanelas; i++) {
					Janela janela = new Janela();
					janela.setDescricao(EntradaSaida.solicitaDescricao("Janela", (i + 1)));
					janela.setEstado(EntradaSaida.solicitaEstado("Janela"));
					
					listaDeJanelas.add(janela);
				}
				this.casa.constroiCasa(descricao, cor, listaDePortas, listaDeJanelas);

				System.out.println("Descrição da casa: " + casa.getDescricao() + "\n");
				System.out.println("Cor da casa: " + casa.getCor() + "\n");

				for (Aberturas porta : casa.getListaDePortas()) {
					System.out.println("Descrição da Porta: " + porta.getDescricao() + "\n");
					System.out.println("Estado da Porta: " + porta.getEstado() + "\n");
				}

				for (Aberturas janela : casa.getListaDeJanelas()) {
					System.out.println("Descrição da Janela: " + janela.getDescricao() + "\n");
					System.out.println("Estado da Janela: " + janela.getEstado() + "\n");
				}

				break;

			case 1:
				if (this.casa != null) {

					String tipoAbertura = EntradaSaida.solicitaTipoAbertura();

					ArrayList<Aberturas> listaDeAberturas = new ArrayList<Aberturas>();

					if (tipoAbertura.equals("Porta")) {
						listaDeAberturas = this.casa.getListaDePortas();
					} else {
						listaDeAberturas = this.casa.getListaDeJanelas();
					}

					int posicao = EntradaSaida.solicitaAberturaMover(listaDeAberturas);
					int novoEstado = 0;

					if (posicao != -1) {
						novoEstado = EntradaSaida.solicitaEstado(tipoAbertura);
						Aberturas abertura = this.casa.retornaAbertura(posicao, tipoAbertura);
						this.casa.moverAbertura(abertura, novoEstado);
						this.casa.moverAbertura(abertura, novoEstado);
						System.out.println("Novo estado da " + tipoAbertura + ": " + abertura.getEstado());
					} else {
						EntradaSaida.exibeMsgAbertura();
					}
				} else {
					System.out.println("Nenhuma Casa foi Criada, Costrua primeiro para poder movimentar.");
				}
				break;

			case 2:

				if (this.casa != null) {
					String informacoes = this.casa.geraInfoCasa();
					EntradaSaida.exibeInfoCasa(informacoes);
				} else {
					System.out.println("Nenhuma Casa foi Criada, Costrua primeiro para poder mostrar as informações.");
				}
				break;
			}

		} while (opcao != 3);

		EntradaSaida.exibeMsgEncerraPrograma();

	}
}
