import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    public static void main(String[]args) throws Exception{

        Socket sk = new Socket("123.0.0.1",2000);
        BufferedReader bf = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        PrintStream pr = new PrintStream(sk.getOutputStream());
        BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while (true){

            System.out.print("Client : ");
            s=bd.readLine();
            pr.println(s);
            if (s.equalsIgnoreCase("Goodbye")){
                System.out.println("The connection has been ended by Client");
                break;
            }

            s=bf.readLine();
            System.out.println("Server : "+s+"\n");


        }

        sk.close();
        bf.close();
        pr.close();
        bd.close();

    }
}
