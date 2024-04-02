package controladora;

import visualizacao.*;

import javax.swing.JOptionPane;

import modelo.*;

public class Controladora {
	public void exibeMenu() {
		boolean valida = false;
		int opcaoMenu = 0;
		String txt = "";
			
		do {
			opcaoMenu = entradaSaida.apresentaMenu();
									
			if (opcaoMenu == 0) {
			 	int qtdCarros = entradaSaida.solicitaQtdFabricar();
			 	Fabrica.fabricarCarro(qtdCarros);
			 	valida = true;
			 							   
			} else if (opcaoMenu == 1) {
			 	txt = Fabrica.apresentaListaDeCarros();
			 	int venderCarro = entradaSaida.solicitaQualCarroVender(txt);
			 	Fabrica.venderCarro(venderCarro);
			 							   
			} else if (opcaoMenu == 2) {
			 	txt = Fabrica.apresentaListaDeCarros();
			 	JOptionPane.showMessageDialog(null, txt);
			 
			} else {
			 	entradaSaida.encerraPrograma();
			 	valida = false;
			}
			 
		} while (valida == true);
	}			
}				