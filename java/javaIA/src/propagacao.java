
public class propagacao {

	public propagacao(int neuronio){
		config c = new config();
		
	if(neuronio == 1){
		c.v1 = c.X0*c.w10 + c.X1*c.w11 + c.X2*c.w12 + c.X3*c.w13 + c.X4*c.w14;
		c.y1 = c.v1 * c.v1; // fazer derivada do Q
	}
	else if(neuronio == 2){
		c.v2 = c.X0*c.w20 + c.X1*c.w21 + c.X2*c.w22 + c.X3*c.w23 + c.X4*c.w24;
		c.y2 = c.v2 * c.v2; // fazer derivada do Q
	}
	else if(neuronio == 3){
		c.v3 = c.X0*c.w30 + c.X1*c.w31 + c.X2*c.w32 + c.X3*c.w33 + c.X4*c.w34;
		c.y3 = c.v3 * c.v3; // fazer derivada do Q
	}
	else if(neuronio == 4){
		c.v4 = c.X0*c.w40 + c.X1*c.w41 + c.X2*c.w42 + c.X3*c.w43;
		c.y5 = c.v5 * c.v5; // fazer derivada do Q
	}
	else if(neuronio == 5){
		c.v5 = c.X0*c.w50 + c.X1*c.w51 + c.X2*c.w52 + c.X3*c.w53;
		c.y5 = c.v5 * c.v5; // fazer derivada do Q
	}
			
		
	}


}
