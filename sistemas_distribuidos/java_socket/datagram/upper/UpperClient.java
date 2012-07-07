import java.io.*;
import java.net.*;
import java.util.*;

public class UpperClient {

  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
       System.out.println("Uso: java UpperClient <maquina> <texto>");
       return;
    }
    // cria um socket datagrama
    DatagramSocket socket = new DatagramSocket();
    // envia um pacote
    byte[] texto = new byte[256];
    texto = args[1].getBytes();
    InetAddress endereco = InetAddress.getByName(args[0]);
    DatagramPacket pacote = new DatagramPacket(texto, texto.length, endereco, 4500);
    socket.send(pacote);
    // obtem a resposta
    pacote = new DatagramPacket(texto, texto.length);
    socket.receive(pacote);
    // mostra a resposta
    String resposta = new String(pacote.getData(), 0, pacote.getLength());
    System.out.println("Texto recebido do servidor: " + resposta);
    // fecha o socket
    socket.close();
  }

}
