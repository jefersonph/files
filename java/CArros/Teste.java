import java.util.Vector;
public class Teste {

	public static void main(String[] args) {
		Vector<carro> carros = new Vector<carro>();
		
		for(int i=1; i < 10; i++){
			carros.add(new carro("Carro"+i, "ABC000"+i));
		}
		
		int i = 0;
		//for(int i=0; i < carros.size(); i++){
		  ((carro) carros.get(i)).mostrarCarro();
			//c.mostrarCarro();
		//System.out.println(carros);
	}
	}

//}
