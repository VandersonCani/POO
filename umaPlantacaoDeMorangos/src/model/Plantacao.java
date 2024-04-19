package model;
import java.util.ArrayList;

import controler.Producao;
import view.geralView;
import view.viewMenus;

public class Plantacao {
	
	String endereco;
	String metrosQuadrados;
	String dono;
	String dataDeCadastro;
	Object Insumos;
	Object Producao;
	ArrayList<String> listaProducao = new ArrayList<>();
	
	
	public Object getInsumos() {
		return Insumos;
	}
	public void setInsumos(Object insumos) {
		Insumos = insumos;
	}
	public Object getProducao() {
		return Producao;
	}
	public void setProducao(Object producao) {
		Producao = producao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getMetrosQuadrados() {
		return metrosQuadrados;
	}
	public void setMetrosQuadrados(String metrosQuadrados) {
		this.metrosQuadrados = metrosQuadrados;
	}
	public String getDono() {
		return dono;
	}
	public void setDono(String dono) {
		this.dono = dono;
	}
	public String getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(String dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public void navegarPlantacaoAteQue(int opcoesMenu, Plantacao plantacao) {
		boolean validaMenu = false;

		do {
			switch (opcoesMenu) {

			case 0: // Movimentar Produção
				movimentarProducao(viewMenus.movimentarProducao(), plantacao);
				break;

			case 1: // Movimentar Insumos
				movimentarInsumos(viewMenus.movimentarInsumos(), plantacao);
				
				break;

			case 2: // Aplicar Venda
				String txt = aplicarVenda(viewMenus.SolicitaProducaoAplicarVenda());
				
				break;
			}
		} while (validaMenu != true);
	}

	private String aplicarVenda(String texto) {
		return texto;
	}
	
	private void movimentarInsumos(Object movimentarInsumos, Plantacao plantacao) {

	}
	
	private void movimentarProducao(int opcoesMenu, Plantacao plantacao) {
		
		switch (opcoesMenu) {

		case 0: // Adicionar Produção
			Producao producao = new Producao();
			producao.setDataVenda(geralView.solicitaDataDaVenda());
			producao.setCaixasColhidas(geralView.solicitaQtdCaixas());
			producao.setValorRecebido(geralView.solicitaValorRecebido());
			plantacao.setProducao(producao);
			break;

		case 1: // Atualizar Produção
			atualizarProducao(geralView.selecionaProducaoAtualizar(listaProducao(producao)));
			break;

		case 2: // Remover Produção
			
			break;
				  
		}
	}
	private String listaProducao(controler.Producao producao) {
		
		return null;
	}
	private void atualizarProducao(Object selecionaProducaoAtualizar) {
		// TODO Auto-generated method stub
		
	}	
	
}
