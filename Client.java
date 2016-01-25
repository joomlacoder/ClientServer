import java.io.*;
import java.net.Socket;

/**
 * Created by Andrej on 25.01.2016.
 */public class Client {
    Socket fromServer;
    BufferedReader in;
    PrintWriter out;
    String user, server;

    public static void main(String[] args) throws IOException{
        Client client = new Client();
        System.out.println("Создаем клиента...");
        client.fromServer = new Socket("172.0.0.1", 8080);
        System.out.println("Соединяемся... ");
        client.in = new BufferedReader(new InputStreamReader(client.fromServer.getInputStream()));
        client.out = new PrintWriter(client.fromServer.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while ((client.user = reader.readLine()) != null){
            client.out.print(client.user);
            client.server = client.in.readLine();
            System.out.println(client.server);
            if(client.user.equalsIgnoreCase("exet"))break;
        }

        client.fromServer.close();
        client.in.close();
        client.out.close();
        reader.close();
    }

}
