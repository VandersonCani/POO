package model;

public class Plantacao {
	
	String endereco;
	String dono;
	String metrosQuadrados;
	String dataDeCadastro;
	Object Producao;
	
	
	public String getDono() {
		return dono;
	}
	public void setDono(String dono) {
		this.dono = dono;
	}
	public Object getProducao() {
		return Producao;
	}
	public void setListaProducao(Object producao) {
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
	public String getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(String dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	
	
}
