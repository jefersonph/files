class Test {
static int s;

public static void main(String [] args) {
Test p = new Test();
p.start();
System.out.println(s);
}

void start() {
int x = 7;
s++;
x = twice(x);
System.out.print(x + " ");
}

int twice(int x) {
x = x*2;
s = x;
return x;
}
}
