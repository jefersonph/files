import java.util.*;

public class teste {
	
	public static void main(String[] args){
		int op;
		String j[] = new String[10];
		int v;
		
		for (int i=1; i < 10; i++){
			j[i] = new String(Integer.toString(i));
		}
		j[2] = new String("X");
		j[5] = new String("X");
		j[8] = new String("X");
		for(int i=1; i < 10 ; i++){
			System.out.println(j[i]);
		}

		new teste(j, v=8);
	}
	
	public teste(String jogo[], int vez){

		if (jogo[1].compareTo(jogo[2]) == 0 && jogo[2].compareTo(jogo[3]) == 0)
		{  
				if (vez%2==0)
						System.out.println("\nX - Vencedor!");
				else
						System.out.println("\nO - Vencedor!");
		}
		if (jogo[4].compareTo(jogo[5]) == 0 && jogo[5].compareTo(jogo[6]) == 0)
		{
				if (vez%2==0)
						System.out.println("\nX - Vencedor!");
				else
						System.out.println("\nO - Vencedor!");
		}
		if (jogo[7].compareTo(jogo[8]) == 0 && jogo[8].compareTo(jogo[9]) == 0)
		{
				if (vez%2==0)
						System.out.println("\nX - Vencedor!");
				else
						System.out.println("\nO - Vencedor!");
		}
		if (jogo[3].compareTo(jogo[5]) == 0 && jogo[5].compareTo(jogo[7]) == 0)
		{
				if (vez%2==0)
						System.out.println("\nX - Vencedor!");
				else
						System.out.println("\nO - Vencedor!");
		}
		if (jogo[1].compareTo(jogo[5]) == 0 && jogo[5].compareTo(jogo[9]) == 0)
		{
				if (vez%2==0)
						System.out.println("\nX - Vencedor!");
				else
						System.out.println("\nO - Vencedor!");
		}
		if (jogo[1].compareTo(jogo[4]) == 0 && jogo[4].compareTo(jogo[7]) == 0)
		{
				if (vez%2==0)
						System.out.println("\nX - Vencedor!");
				else
						System.out.println("\nO - Vencedor!");
		}
		if (jogo[2].compareTo(jogo[5]) == 0 && jogo[5].compareTo(jogo[8]) == 0)
		{
				if (vez%2==0)
						System.out.println("\nX - Vencedor!");
				else
						System.out.println("\nO - Vencedor!");
		}
		if (jogo[3].compareTo(jogo[6]) == 0 && jogo[6].compareTo(jogo[9]) == 0)
		{
				if (vez%2==0)
						System.out.println("\nX - Vencedor!");
				else
						System.out.println("\nO - Vencedor!");
		}
	}
	public int joga (int vez)
	{
		 char letra;
		 if (vez%2==0)
		 {
		  letra='O';
		  return (letra);
		 }
		 else
		 {
		  letra='X';
		  return (letra);
		 }
	}
}
