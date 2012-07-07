public class ContaCorrente extends Conta {
	protected int variacao;
	protected int aniversario;
	
	public ContaCorrente (int numero, int agencia, int variacao){
		super(numero, agencia);
		this.variacao = variacao;
		
	}

	public void somaSaldo(float valor){
		saldo = saldo + valor;
	}

}