package model;

public class Plantacao {
	
	String endereco;
	String metrosQuadrados;
	String dono;
	String dataDeCadastro;
	Object Insumos;
	Object Producao;
	
	
	
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

	
	
}
