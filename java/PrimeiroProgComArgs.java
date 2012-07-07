/*
1.5) Exemplo de chamada de um programa com argumentos externos. Modificar o programa acima conforme o exemplo abaixo e executar passando seu nome como argumento
JDK: na linha de comando digitar java <nome> SeuNome 
*/

class PrimeiroProgComArgs{
    public static void main (String[] args) {
       // Não esquecer o argumento!
       System.out.println("Meus cumprimentos " + args[0] + " " +  args[1] + " voce conseguiu!" );
    }
}