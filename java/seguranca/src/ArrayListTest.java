
import java.util.ArrayList;
import java.util.ListIterator;
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> n1 = new ArrayList<Integer>();
		ArrayList<Integer> n2 = new ArrayList<Integer>();
		primos p = new primos();
		for(int i=0; i<123456; i++){
		if (p.ehPrimo(i)){
			n1.add(i);
			n2.add(i);
		}
		}
		System.out.println("Começar for");
		int v1, v2, v3;
		for(int a=0; a <n1.size(); a++){
		 for(int b=0 ; b < n2.size(); b++){
			  //if(n1.get(a)* n2.get(b) == 559747381){
				 v1 = n1.get(a) * n2.get(b); 
				 System.out.println(n1.get(a)+ "*" + n2.get(b)+ "= " + v1);
			//}
		  }		
		}
	
		//for(int i=0;i<n1.size();i++){
		 //  System.out.println(n1.get(i));
		//}
	}
}
