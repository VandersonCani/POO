package model;

import java.util.ArrayList;

import visualizacao.entradaSaida;

public class ContaBancaria {
	private String titularDaConta;
	private int tipo;
	private double saldo;
	private ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();
	private ArrayList<Movimentacao> listaDeDepositos = new ArrayList<Movimentacao>();
	private ArrayList<Movimentacao> listaDeSaques = new ArrayList<Movimentacao>();

	
	public ArrayList<Movimentacao> getListaDeDepositos() {
		return listaDeDepositos;
	}

	public void setListaDeDepositos(ArrayList<Movimentacao> listaDeDepositos) {
		this.listaDeDepositos = listaDeDepositos;
	}

	public ArrayList<Movimentacao> getListaDeSaques() {
		return listaDeSaques;
	}

	public void setListaDeSaques(ArrayList<Movimentacao> listaDeSaques) {
		this.listaDeSaques = listaDeSaques;
	}

	public ArrayList<Movimentacao> getListaDeMovimentacao() {
		return listaDeMovimentacao;
	}

	public void setListaDeMovimentacao(ArrayList<Movimentacao> listaDeMovimentacao) {
		this.listaDeMovimentacao = listaDeMovimentacao;
	}
	
	public String getTitularDaConta() {
		return titularDaConta;
	}

	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int i) {
		this.tipo = i;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void gerarExtrato() {

	}

	public void gerarExtratoDepositos() {

	}

	public void gerarExtratoSaques() {

	}

	public double depositar(double deposito) {
		return this.saldo = this.saldo + deposito;
	}

	public double saque(double saque) {
		if (saque > this.saldo) {
			entradaSaida.exibeErroSaldoInsuficiente(this.saldo);
		} else {
			return this.saldo = this.saldo - saque;
		}
		return this.saldo;
	}
}
