

public class erro {
	public erro(int neuronio){
		
		config c = new config();
		
		if(neuronio == 1){
			c.erro1 = c.d1 - c.y1;
		}
		else if(neuronio == 2){
			c.erro2 = c.d2 - c.y2;
		}
		else if(neuronio == 3){
			c.erro3 = c.d3 - c.y3;
		}
		else if(neuronio == 4){
			c.erro4 = c.d4 - c.y4;
		}
		else if(neuronio == 5){
			c.erro5 = c.d5 - c.y5;
		}
		
	}
}