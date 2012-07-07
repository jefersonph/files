//NOMES:
//JEFERSON PIZZOLATO HOMEM
//JOSE DIEGO FRAGA

public class ContaBancaria {
	private int numero;
	private double saldo;
	Acao ultimaAcao = new Acao();
	
	public ContaBancaria(int num, double sal){
		numero = num;
		saldo = sal;
		
	}

	class Acao{
		private String ultimaAcao; 
		private int valor;

		public void creditaValorConta(int v1){
			ContaBancaria.this.saldo = ContaBancaria.this.saldo + v1;
		}
		public void debitaValorConta(int v1){
			ContaBancaria.this.saldo =  ContaBancaria.this.saldo - v1;
		}
		public void transfereValorConta(int valor, ContaBancaria c1){
			ContaBancaria.this.saldo = ContaBancaria.this.saldo - valor;
			c1.saldo = c1.saldo + valor;

		}
		public int getSaldo() {
			return (int) ContaBancaria.this.saldo;
		}
		public void setValor(int valor) {
			this.valor = valor;
		}
		public String getUltimaAcao() {
			return ultimaAcao;
		}
		public void setUltimaAcao(String ultimaAcao) {
			this.ultimaAcao = ultimaAcao;
		}
	}

}
