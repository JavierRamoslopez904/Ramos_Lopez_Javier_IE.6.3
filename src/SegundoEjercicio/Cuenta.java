package SegundoEjercicio;

public class Cuenta {
	//Atributos
	private double dinero;
	private Banco banco;
	//Constructor
	public Cuenta(double din, Banco ban) {
		this.dinero = din;
		this.banco = ban;
	}
	//M�todos getters y setter
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	//M�todo toString
	@Override
	public String toString() {
		return "Cuenta [dinero=" + dinero +  "]";
	}
	
}
