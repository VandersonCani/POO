package modelo;

import java.util.ArrayList;

import visualizacao.entradaSaida;

public class Fabrica {
	private static ArrayList<Carro> listaDeCarros = new ArrayList<Carro>();

	public static void fabricarCarro(int qtdAFabricar) {

		for (int i = 1; i <= qtdAFabricar; i++) {

			Carro carro = new Carro();
			carro.setModelo(entradaSaida.solicitarModelo());
			carro.setCor(entradaSaida.solicitarCor());
			entradaSaida.mostraCarro(carro);
			listaDeCarros.add(carro);
		}
	}

	public static String apresentaListaDeCarros() {
		int i = 0;
		String txt = "";
		for (Carro str : listaDeCarros) {

			
			txt += ("Carro " + (i + 1) + "    Modelo: " + str.getModelo() + " Cor: " + str.getCor() + "\n");
			i++;
		}
		return txt;
	}
	
	public static void venderCarro(int venderCarro) {
		
		listaDeCarros.remove(venderCarro - 1);
	}

	public static ArrayList<Carro> getListaDeCarros() {
		return listaDeCarros;
	}

	@SuppressWarnings("static-access")
	public void setListaDeCarros(ArrayList<Carro> listaDeCarros) {
		this.listaDeCarros = listaDeCarros;
	}


}
