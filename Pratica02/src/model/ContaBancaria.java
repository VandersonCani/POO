package model;

import java.sql.Date;
import java.util.ArrayList;

public class ContaBancaria {
	private String titularDaConta;
	private int tipo;
	private static double saldo;
	private static double deposito;
	private static double saque;
	public static Date data;
	private static ArrayList<Double> listaDepositos = new ArrayList<Double>();
	private static ArrayList<Double> listaSaques = new ArrayList<Double>();
	private static ArrayList<Double> totalMovimentacoes = new ArrayList<Double>();
	
	
	public String getTitularDaConta() {
		return titularDaConta;
	}
	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public static double getSaldo() {
		return saldo;
	}
	public static void setSaldo(double saldo) {
		ContaBancaria.saldo = saldo;
	}
	public static double getDeposito() {
		return deposito;
	}
	public String setDeposito(double valor) {
		ContaBancaria.deposito = valor;
		return titularDaConta;
	}
	public static double getSaque() {
		return saque;
	}
	public static void setSaque(double saque) {
		ContaBancaria.saque = saque;
	}
	public static Date getData() {
		return data;
	}
	public static void setData(Date data) {
		ContaBancaria.data = data;
	}
	public static ArrayList<Double> getListaDepositos() {
		return listaDepositos;
	}
	public static void setListaDepositos(ArrayList<Double> listaDepositos) {
		ContaBancaria.listaDepositos = listaDepositos;
	}
	public static ArrayList<Double> getListaSaques() {
		return listaSaques;
	}
	public static void setListaSaques(ArrayList<Double> listaSaques) {
		ContaBancaria.listaSaques = listaSaques;
	}
	public static ArrayList<Double> getTotalMovimentacoes() {
		return totalMovimentacoes;
	}
	public static void setTotalMovimentacoes(ArrayList<Double> totalMovimentacoes) {
		ContaBancaria.totalMovimentacoes = totalMovimentacoes;
	}
}
