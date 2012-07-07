
class TiposBasicos2 {
	static void saidaln(String s){
            System.out.println(s + "\n");
	}
	public static void main(String ar[]) {
                //O valor de PI (Math.PI)
        	saidaln("valor de PI = " + Math.PI);
		//Um valor randômico (Math.random())
		saidaln("valor randômico = " +  Math.random());
                //Um valor randômico entre 1 e 5: usar o resto da divisão por 6
		saidaln("valor randômico 1-5 = " +  ((Math.random()*10)%6));
                //O maior entre dois valores (Math.max(...))
		saidaln("maior valor = " +  Math.max(334.5, 334.9));
	}
}
