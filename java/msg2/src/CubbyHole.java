public class CubbyHole {
private String contents;
private boolean available = false;
private int conNumber;

public synchronized String get(int conexao) {
    while (available == false || conexao == conNumber) {
        try {
            //wait for Producer to put value
            wait();
        } catch (InterruptedException e) { }
    }
    available = false;
    //notify Producer that value has been retrieved
    notifyAll();
    return contents;
}

public synchronized void put(String value, int conexao) {
    while (available == true) {
        try {
            //wait for Consumer to get value
            wait();
        } catch (InterruptedException e) { }
    }
    conNumber = conexao;
    contents = value;
    available = true;
    //notify Consumer that value has been set
    notifyAll();
    }
}
