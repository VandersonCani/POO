package model;

import java.util.ArrayList;
import java.util.Date;

import visualizacao.entradaSaida;

public class ContaBancaria {
	private static String titularDaConta;
	private Date data;
	private static int tipoCo = 0;
	static String tipoConta = "";
	private double saldo;
	private static String tipomov;
	private static ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<>();
	private static ArrayList<Movimentacao> listaDeDepositos = new ArrayList<>();
	private static ArrayList<Movimentacao> listaDeSaques = new ArrayList<>();

	public ArrayList<Movimentacao> getListaDeDepositos() {
		return listaDeDepositos;
	}

	public void setListaDeDepositos(ArrayList<Movimentacao> listaDeDepositos) {
		ContaBancaria.listaDeDepositos = listaDeDepositos;
	}

	public ArrayList<Movimentacao> getListaDeSaques() {
		return listaDeSaques;
	}

	public void setListaDeSaques(ArrayList<Movimentacao> listaDeSaques) {
		ContaBancaria.listaDeSaques = listaDeSaques;
	}

	public ArrayList<Movimentacao> getListaDeMovimentacao() {
		return listaDeMovimentacao;
	}

	public void setListaDeMovimentacao(ArrayList<Movimentacao> listaDeMovimentacao) {
		ContaBancaria.listaDeMovimentacao = listaDeMovimentacao;
	}

	public static String getTitularDaConta() {
		return titularDaConta;
	}

	public void setTitularDaConta(String titularDaConta) {
		ContaBancaria.titularDaConta = titularDaConta;
	}

	public int getTipoConta() {
		return tipoCo;
	}

	
	public void setTipoCo(int i) {
		ContaBancaria.tipoCo = i;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double depositar(double deposito) {
		Movimentacao movimentacao = new Movimentacao();

		movimentacao.setTipo(1); // #0
		movimentacao.setData(data); // #1
		movimentacao.setValor(deposito); // #2
		this.saldo = this.saldo + deposito;
		movimentacao.setSaldo(this.saldo); // #3
		listaDeDepositos.add(movimentacao);
		listaDeMovimentacao.add(movimentacao);
		return this.saldo;
	}

	public double saque(double saque) {
		if (saque > this.saldo) {
			entradaSaida.exibeErroSaldoInsuficiente(this.saldo);
		} else {
			Movimentacao movimentacao = new Movimentacao();

			movimentacao.setTipo(2); // #0
			movimentacao.setData(data); // #1
			movimentacao.setValor(saque); // #2
			this.saldo = this.saldo - saque;
			movimentacao.setSaldo(this.saldo); // #3
			listaDeSaques.add(movimentacao);
			listaDeMovimentacao.add(movimentacao);
			return this.saldo;
		}
		return this.saldo;
	}

	public static String exibirExtratoCompleto() {
	
		if (tipoCo == 1) {
			tipoConta = "Conta Corrente \n";
		} else {
			tipoConta = "Conta Poupança \n";
		}

		String informacoes = "Nome: " + titularDaConta + " \nTipo de Conta: " + tipoConta + " \n";

		for (int i = 0; i < listaDeMovimentacao.size(); i++) {
			Movimentacao m = listaDeMovimentacao.get(i);

			if (m.getTipo() == 1) {
				tipomov = "Depósito \n";
				String alteraInfo = "Valor do Depósito: " + m.getValor() + "\nSaldo: " + m.getSaldo() + " \n";
				informacoes += tipomov + alteraInfo;
			} else if (m.getTipo() == 2) {
				tipomov = "Saque \n";
				String alteraInfo = "Valor do Saque: " + m.getValor() + "\nSaldo: " + m.getSaldo() + " \n";
				informacoes += tipomov + alteraInfo;
			}
		}
		return informacoes;
	}

	public static String exibirExtratoDeDepositos() {

		if (tipoCo == 1) {
			tipoConta = "Conta Corrente \n";
		} else {
			tipoConta = "Conta Poupança \n";
		}

		String informacoes = "Nome: " + titularDaConta + " \nTipo de Conta: " + tipoConta + " \n";

		for (int i = 0; i < listaDeDepositos.size(); i++) {
			Movimentacao m = listaDeDepositos.get(i);

			if (m.getTipo() == 1) {
				tipomov = "Depósito \n";
				String alteraInfo = "Valor do Depósito: " + m.getValor() + "\nSaldo: " + m.getSaldo() + " \n";
				informacoes += tipomov + alteraInfo;
			} else if (m.getTipo() == 2) {
				tipomov = "Saque \n";
				String alteraInfo = "Valor do Saque: " + m.getValor() + "\nSaldo: " + m.getSaldo() + " \n";
				informacoes += tipomov + alteraInfo;
			}
		}
		return informacoes;
	}

	public static String exibirExtratoDeSaques() {

		if (tipoCo == 1) {
			tipoConta = "Conta Corrente \n";
		} else {
			tipoConta = "Conta Poupança \n";
		}

		String informacoes = "Nome: " + titularDaConta + " \nTipo de Conta: " + tipoConta + " \n";

		for (int i = 0; i < listaDeSaques.size(); i++) {
			Movimentacao m = listaDeSaques.get(i);

			if (m.getTipo() == 1) {
				tipomov = "Depósito \n";
				String alteraInfo = "Valor do Depósito: " + m.getValor() + "\nSaldo: " + m.getSaldo() + " \n";
				informacoes += tipomov + alteraInfo;
			} else if (m.getTipo() == 2) {
				tipomov = "Saque \n";
				String alteraInfo = "Valor do Saque: " + m.getValor() + "\nSaldo: " + m.getSaldo() + " \n";
				informacoes += tipomov + alteraInfo;
			}
		}
		return informacoes;
	}
}
