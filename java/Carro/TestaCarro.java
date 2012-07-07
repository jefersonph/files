/**
 * 
 */

/**
 * @author a052002187
 *
 */
public class TestaCarro {
	public static void main(String[] args){
		Carro c1 = new Carro();
		System.out.println("Id do objeto c1 = " + c1);
		System.out.println(c1.mostrarMarca());
		System.out.println(c1.mostrarPlaca());
		//c1.ano = 2005;
		Carro c2 = new Carro(1,2);
		System.out.println("Id do objeto c2 = " + c2);
		c2 = c1; // cuidado
		System.out.println("Id do objeto c2 = " + c2);
		c1 = new Carro();
		System.out.println("Id do objeto c1 = " + c1);
		if(c1 instanceof Carro){
				System.out.println("C1 e uma instancia de carro");
		}
	}
}
