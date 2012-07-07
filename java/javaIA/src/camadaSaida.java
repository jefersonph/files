

public class camadaSaida {
	public camadaSaida(int neuronio){
		config c = new config();
		double deltaX0;
		double deltaX1;
		double deltaX2;
		double deltaX3;
		double deltaX4;
		
		if(neuronio == 1){
			deltaX0 = c.gradiente1 * c.txAprendizado * c.X0;
			deltaX1 = c.gradiente1 * c.txAprendizado * c.X1;
			deltaX2 = c.gradiente1 * c.txAprendizado * c.X2;
			deltaX3 = c.gradiente1 * c.txAprendizado * c.X3;
			deltaX4 = c.gradiente1 * c.txAprendizado * c.X4;
			c.w10 = c.w10 + deltaX0;
			c.w11 = c.w11 + deltaX1;
			c.w12 = c.w12 + deltaX2;
			c.w13 = c.w13 + deltaX3;
			c.w14 = c.w14 + deltaX4;
			
		}
		else if(neuronio == 2){
			deltaX0 = c.gradiente2 * c.txAprendizado * c.X0;
			deltaX1 = c.gradiente2 * c.txAprendizado * c.X1;
			deltaX2 = c.gradiente2 * c.txAprendizado * c.X2;
			deltaX3 = c.gradiente2 * c.txAprendizado * c.X3;
			deltaX4 = c.gradiente2 * c.txAprendizado * c.X4;
			c.w20 = c.w20 + deltaX0;
			c.w21 = c.w21 + deltaX1;
			c.w22 = c.w22 + deltaX2;
			c.w23 = c.w23 + deltaX3;
			c.w24 = c.w24 + deltaX4;
			
		}
		else if(neuronio == 3){
			deltaX0 = c.gradiente3 * c.txAprendizado * c.X0;
			deltaX1 = c.gradiente3 * c.txAprendizado * c.X1;
			deltaX2 = c.gradiente3 * c.txAprendizado * c.X2;
			deltaX3 = c.gradiente3 * c.txAprendizado * c.X3;
			deltaX4 = c.gradiente3 * c.txAprendizado * c.X4;
			c.w30 = c.w30 + deltaX0;
			c.w31 = c.w31 + deltaX1;
			c.w32 = c.w32 + deltaX2;
			c.w33 = c.w33 + deltaX3;
			c.w34 = c.w34 + deltaX4;
		}
		else if(neuronio == 4){
			deltaX0 = c.gradiente4 * c.txAprendizado * c.y0;
			deltaX1 = c.gradiente4 * c.txAprendizado * c.y1;
			deltaX2 = c.gradiente4 * c.txAprendizado * c.y2;
			deltaX3 = c.gradiente4 * c.txAprendizado * c.y3;
			c.w40 = c.w40 + deltaX0;
			c.w41 = c.w41 + deltaX1;
			c.w42 = c.w42 + deltaX2;
			c.w43 = c.w43 + deltaX3;
		}
		else if(neuronio == 5){
			deltaX0 = c.gradiente5 * c.txAprendizado * c.y0;
			deltaX1 = c.gradiente5 * c.txAprendizado * c.y1;
			deltaX2 = c.gradiente5 * c.txAprendizado * c.y2;
			deltaX3 = c.gradiente5 * c.txAprendizado * c.y3;
			c.w50 = c.w50 + deltaX0;
			c.w51 = c.w51 + deltaX1;
			c.w52 = c.w52 + deltaX2;
			c.w53 = c.w53 + deltaX3;
		}
		
}
}