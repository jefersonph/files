public abstract class Conta {
	protected int numero;
	protected int agencia;
	protected float saldo;

	public Conta (int numero,int agencia){
		this.numero = numero;
		this.agencia = agencia;

	}

	public float getSaldo () {
		return saldo;
	}

	public abstract void somaSaldo(float valor);
}