package controladora;

import visualizacao.*;

import javax.swing.JOptionPane;

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
			 							   
			} else if (nmrValidacao == 2) {
			 	txt = Fabrica.apresentaListaDeCarros();
			 	JOptionPane.showMessageDialog(null, txt);
			 		
			} else {
			 	entradaSaida.encerraPrograma();
			 	valida = false;
			}
			 
		} while (valida == true);
	}
}