package controle;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import visualizacao.EntradaSaida;
import modelo.*;

public class Controladora {

	Casa casa = null;

	public void ExibeMenu() {
		int opcao;
		do {
			opcao = EntradaSaida.SolicitaOpcao();

			switch (opcao) {
			case 0:
				this.casa = new Casa();
				String descricao = EntradaSaida.solicitaDescricao("Casa", 0);
				String cor = EntradaSaida.solicitaCor();
				
				int qtdPortas = EntradaSaida.solicitaQtdAberturas("Portas");
				int qtdJanelas = EntradaSaida.solicitaQtdAberturas("Janelas");
				
				ArrayList<Aberturas> listaDePortas = new ArrayList<Aberturas>();
				
				for(int i = 0 ; i < qtdPortas; i++) {
					Porta porta = new Porta();
					porta.setDescricao(EntradaSaida.solicitaDescricao("Porta", (i + 1)));
					porta.setEstado(EntradaSaida.solicitaEstado("Porta"));
					listaDePortas.add(porta);
				}
				
				ArrayList<Aberturas> listaDeJanelas = new ArrayList<Aberturas>();
				
				for(int i = 0 ; i < qtdJanelas; i++) {
					Janela janela = new Janela();
					janela.setDescricao(EntradaSaida.solicitaDescricao("Janela", (i + 1)));
					janela.setEstado(EntradaSaida.solicitaEstado("Janela"));
					listaDeJanelas.add(janela);
				}
				this.casa.constroiCasa(descricao, cor, listaDePortas, listaDeJanelas);
				
				System.out.println("Descrição da casa: " + casa.getDescricao() + "\n");
				System.out.println("Cor da casa: " + casa.getCor() + "\n");
				
				for(Aberturas porta : casa.getListaDePortas()) {
					System.out.println("Descrição da Porta: " + porta.getDescricao() + "\n");
					System.out.println("Estado da Porta: " + porta.getEstado() + "\n");
				}
				
				for(Aberturas janela : casa.getListaDeJanelas()) {
					System.out.println("Descrição da Janela: " + janela.getDescricao() + "\n");
					System.out.println("Estado da Janela: " + janela.getEstado() + "\n");
				}
				
				break;

			case 1:
				String tipoAbertura = EntradaSaida.solicitaTipoAbertura();
				
				ArrayList<Aberturas> listaDeAberturas = new ArrayList<Aberturas>();
				
				if(tipoAbertura.equals("Porta")) {
					listaDeAberturas = this.casa.getListaDePortas();
				} else {
					listaDeAberturas = this.casa.getListaDeJanelas();
				}
				
				int posicao = EntradaSaida.solicitaAberturaMover(listaDeAberturas);
				int novoEstado = 0;
				
				if(posicao != -1) {
					novoEstado = EntradaSaida.solicitaEstado(tipoAbertura);
					Aberturas abertura = this.casa.retornaAbertura(posicao, tipoAbertura);
					this.casa.moverAbertura (abertura, novoEstado);
					this.casa.moverAbertura(abertura, novoEstado);
					System.out.println("Novo estado da " + tipoAbertura + ": " + abertura.getEstado());
				}else {
					EntradaSaida.exibeMsgAbertura();
				}
				
				break;

			case 2:
				JOptionPane.showMessageDialog(null, "Ver Informações da Casa");
				break;
			}

		} while (opcao != 3);

		EntradaSaida.exibeMsgEncerraPrograma();

	}
}
