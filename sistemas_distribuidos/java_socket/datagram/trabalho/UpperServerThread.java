import java.io.*;
import java.net.*;
import java.util.*;

public class UpperServerThread extends Thread {

  protected DatagramSocket socket = null;

  public UpperServerThread() throws IOException {
    this("UpperServerThread");
  }

  public UpperServerThread(String name) throws IOException {
    super(name);
    socket = new DatagramSocket(4809);
  }

  public void run() {
    while (true) {
          try {
            byte[] texto = new byte[256];
            // recebe datagrama
            DatagramPacket pacote = new DatagramPacket(texto, texto.length);
            socket.receive(pacote);

            // processa o que foi recebido
            String recebido = new String(pacote.getData(), 0, pacote.getLength());
            String mensagem = "";      
            String dados[] = recebido.split("\\+");
            Integer jogador = Integer.parseInt(dados[1]);

            Integer servidor =( int )( Math.random() * 3 );
            
            if(jogador == servidor)
            	mensagem = "empatou" + "+" + servidor;
            else if (jogador == 0 && servidor == 2)
            	mensagem = "ganhou" + "+" + servidor;
            else if (jogador == 2 && servidor == 1)
            	mensagem = "ganhou" + "+" + servidor;
            else if (jogador == 1 && servidor == 0)
            	mensagem = "ganhou" + "+" + servidor;
            else 
            	mensagem = "perdeu" + "+" + servidor;
            
             texto = mensagem.getBytes();

            
            // envia a resposta de volta ao cliente
            InetAddress endereco = pacote.getAddress();
            int porta = pacote.getPort();
            pacote = new DatagramPacket(texto, texto.length, endereco, porta);
            socket.send(pacote);
            if ( recebido.equals("FIM") )
               break;
          } catch (IOException e) {
            e.printStackTrace();
            break;
          }
    }
    socket.close();
    System.out.println("Servidor encerrado...");
  }

}
