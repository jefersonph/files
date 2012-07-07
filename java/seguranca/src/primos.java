
public class primos {
    public static boolean ehPrimo(long nr) {
        if (nr < 2)
            return false;
        for (long i = 2; i <= (nr / 2); i++) {
            if (nr % i == 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        long x;
        for(x=1000; x<12345; x++  ){
        if (ehPrimo(x)) // se for primo
            System.out.println(x + " é primo");
        }
    }
}