package controle;

import java.util.ArrayList;

public class ContaBancaria {
	private String titularDaConta;
	private int tipo;
	private double saldo;
	private ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();

	public String getTitularDaConta() {
		return titularDaConta;
	}

	public void setTitularDaConta(String string) {
		// this.titularDaConta = titularDaConta;
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

	public ArrayList<Movimentacao> getListaDeMovimentacao() {
		return listaDeMovimentacao;
	}

	public void setListaDeMovimentacao(ArrayList<Movimentacao> listaDeMovimentacao) {
		this.listaDeMovimentacao = listaDeMovimentacao;
	}

	public void sacar() {

	}

	public void gerarSaldo() {

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
		return this.saldo = this.saldo - saque;
	}
}
