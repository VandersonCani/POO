package controladora;

import visualizacao.*;
import modelo.*;

public class Controladora {
	public void exibeMenu() {
		boolean valida = false;
		int nmrValidacao = 0;
		String txt = "";
		do {
			nmrValidacao = entradaSaida.apresentaMenu();
		
			if (nmrValidacao == 0) {
				int qtdCarros = entradaSaida.solicitaQtdFabricar();
				Fabrica.fabricarCarro(qtdCarros);
				valida = true;
				
			} else if (nmrValidacao == 1) {
				txt = Fabrica.apresentaListaDeCarros();
				int venderCarro = entradaSaida.solicitaQualCarroVender(txt);
				Fabrica.venderCarro(venderCarro);
				valida = true;
			} else {
				entradaSaida.encerraPrograma();
				valida = false;
			}

		} while (valida == true);
	}
}
