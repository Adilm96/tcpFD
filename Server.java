import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[]args)throws Exception{

        ServerSocket ss = new ServerSocket(2000);
        Socket sk = ss.accept();
        BufferedReader bf = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        PrintStream pr = new PrintStream(sk.getOutputStream());
        BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Scanner sc = new Scanner(System.in);
        while (true) {

            s=bf.readLine();

            System.out.print("Client : "+s+"\n");
            System.out.print("Server : ");

            s=sc.nextLine();
            if (s.equalsIgnoreCase("goodbye"));{

                pr.println("GOODBYE");
                System.out.println("The connection ended by Server");
                break;
            }


        }

        ss.close();
        sk.close();
        bf.close();
        pr.close();
        bd.close();
    }
}
