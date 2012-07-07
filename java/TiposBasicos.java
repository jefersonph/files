/*
2.1) Compilar e executar o programa a seguir, observando os resultados:
*/

class TiposBasicos {
	static void saidaln(String s){
	   System.out.println(s + "\n");
	}
	public static void main(String ar[]) {
		boolean b1=false;
        	saidaln("boolean=" + true +" "+ b1 );
		// inteiro
		int  a = 0;
		int  b, c, d = 3, i;     
		saidaln("d= " + d );
		// atribuicoes
		b = c = d;
 		saidaln("b= c = d ->" + b);
		// expressoes
		b = 3 * 5 % 3;
		saidaln("b=3 * 5 % 3 ->" + b);
		// atualizacoes
		a += b -= 5;
		saidaln("a+= b -= 5 ->" + a);
		saidaln("a + 1 = " + ++a);
	    	// real
		float r1=5.3f;
		saidaln("real: " +  r1);
		int x = (a + b)*(c - d);
	}
		
}

