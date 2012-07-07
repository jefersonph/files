
public class gradiente {
	public gradiente(int neuronio){
		config c = new config();
		if(neuronio == 1){
			c.gradiente1 = c.v1 * c.erro1; // fazer derivada do Q
		}
		else if(neuronio == 2){
			c.gradiente2 = c.v2 * c.erro2; // fazer derivada do Q
		}
		else if(neuronio == 3){
			c.gradiente3 = c.v3 * c.erro3; // fazer derivada do Q
		}
		else if(neuronio == 4){
			c.gradiente4 = c.v4 * c.erro4; // fazer derivada do Q
		}
		else if(neuronio == 5){
			c.gradiente5 = c.v5 * c.erro5; // fazer derivada do Q
		}
		
}
}