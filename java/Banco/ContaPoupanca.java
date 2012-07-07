public class ContaPoupanca extends Conta {
	protected float limite;

	public ContaPoupanca (int numero, int agencia) {
		super(numero, agencia);
	}

	public void somaSaldo(float valor){
		saldo = saldo + valor + this.limite;
	}
}