package model;

public class Insumos {
	String adubos[] = new String[2]; // {"Nome", "Quantidade em Litros"}
	String pesticidas[] = new String[2]; // {"Nome", "Quantidade em Litros"}
	
	public String[] getAdubos() {
		return adubos;
	}
	public void setAdubos(String[] adubos) {
		this.adubos = adubos;
	}
	public String[] getPesticidas() {
		return pesticidas;
	}
	public void setPesticidas(String[] pesticidas) {
		this.pesticidas = pesticidas;
	}
	
}
