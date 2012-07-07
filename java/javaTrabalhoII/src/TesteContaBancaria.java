//NOMES:
//JEFERSON PIZZOLATO HOMEM
//JOSE DIEGO FRAGA

public class TesteContaBancaria {

	public static void main(String[] args) {
    
	ContaBancaria c1 = new ContaBancaria(12, 100); 
	ContaBancaria c2 = new ContaBancaria(15, 100); 
	
	System.out.println("Saldo c1 Inicial : " + c1.ultimaAcao.getSaldo());
	c1.ultimaAcao.creditaValorConta(20); 
    System.out.println("Saldo c1 depois do credito de 20: " + c1.ultimaAcao.getSaldo()); 
    
    System.out.println("Saldo c2 Inicial : " + c2.ultimaAcao.getSaldo());
    c2.ultimaAcao.creditaValorConta(30); 
    System.out.println("Saldo c2 depois do credito de 30: " + c2.ultimaAcao.getSaldo());
    
    System.out.println("");
    
    System.out.println("Saldo c1 anterior a transferencia de 100 para c2: " + c1.ultimaAcao.getSaldo());
    c1.ultimaAcao.transfereValorConta(100, c2); 
    System.out.println("Saldo c1 apos a transferencia: " + c1.ultimaAcao.getSaldo()); 
    
    System.out.println("Saldo c2 anterior a transferencia de 150 para c1: " + c2.ultimaAcao.getSaldo());
    c2.ultimaAcao.transfereValorConta(150, c1); 
    System.out.println("Saldo c2 apos a transferencia: " + c2.ultimaAcao.getSaldo());
    
    System.out.println("");
    
    System.out.println("Saldo c1 antes de debitar 50: " + c1.ultimaAcao.getSaldo());
    c1.ultimaAcao.debitaValorConta(50); 
    System.out.println("Saldo c1 apos o debito: " + c1.ultimaAcao.getSaldo());
    
    System.out.println("Saldo c2 antes de debitar 50: " + c2.ultimaAcao.getSaldo());
    c2.ultimaAcao.debitaValorConta(50); 
    System.out.println("Saldo c2 apos o debito: " + c2.ultimaAcao.getSaldo());
	}
}
