/*
 * 1) Fazer uma aplicação formada por dois processos (cliente e servidor), usando sockets por datagramas, 
 * para uma partida simples de Jan Ken Pon, disputada contra o servidor. O servidor deverá receber uma 
 * cadeia de caracteres formada por código da jogada (0 para tesoura; 1 para pedra; e 2 para papel), 
 * seguido de “:” e do nome do jogador (obtido a partir da linha de comando). E receberá como resposta 
 * uma cadeia de caracteres com 256 bytes no seguinte formato: 
 * “<nome> jogou <jogada> contra <jogada do servidor> e <'ganhou' | 'empatou' | 'perdeu'>.”. 
 * A jogada do servidor deverá ser sorteada aleatoriamente.
 * 
 * Pedra ganha da tesoura (amassando-a ou quebrando-a).  
 * Tesoura ganha do papel (cortando-o).
 * Papel ganha da pedra (embrulhando-a).
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class UpperClient {

  public static void main(String[] args) throws IOException {
	String maquina = "localhost";
	
    Scanner tec = new Scanner(System.in);
    
    System.out.println("Nome:");
    String nome = tec.nextLine();
    
    System.out.println("Jogada:");
    String jogada = tec.nextLine();

    String aux = nome + "+" + jogada;
    
    // cria um socket datagrama
    DatagramSocket socket = new DatagramSocket();
    // envia um pacote
    byte[] texto = new byte[256];
    texto = aux.getBytes();
    InetAddress endereco = InetAddress.getByName(maquina);
    DatagramPacket pacote = new DatagramPacket(texto, texto.length, endereco, 4809);
    socket.send(pacote);
    
    // obtem a resposta
    pacote = new DatagramPacket(texto, texto.length);
    socket.receive(pacote);
       
    // processa a resposta
    String resposta = new String(pacote.getData(), 0, pacote.getLength());
    String dados2[] = resposta.split("\\+");
    Integer servidor = Integer.parseInt(dados2[1]);
    
    System.out.println("\n" + nome + " jogou " + jogada + " contra " + servidor + " do servidor e " + dados2[0]);
    
    // fecha o socket
    socket.close();
  }

}
