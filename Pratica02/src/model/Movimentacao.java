package model;

import java.util.Date;

public class Movimentacao {
	private int tipo; // 1-Depósito   2-Saque
	private Date data;
	private double valor;
	private double saldo;
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public java.util.Date getData() {
		return data;
	}
	public void setData(Date i) {
		this.data = i;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}
