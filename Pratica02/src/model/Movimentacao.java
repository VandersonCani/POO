package model;

import java.sql.Date;

public class Movimentacao {
	private int tipo[] = {1,2}; // 1- saque    2-Depósito
	private Date data;
	
	public int[] getTipo() {
		return tipo;
	}
	public void setTipo(int[] tipo) {
		this.tipo = tipo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
}
