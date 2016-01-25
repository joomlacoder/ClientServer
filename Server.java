import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Andrej on 25.01.2016.
 */
public class Server {
    ServerSocket serverSocket;
    Socket fromClient;
    BufferedReader in;
    PrintWriter out;
    String input, output;

    public static void main(String[] args) throws IOException {
        System.out.println("Создаем сервер");
        Server server = new Server();
        server.serverSocket = new ServerSocket(8080);
        System.out.println("Ожидаем клиента...");
        server.fromClient = server.serverSocket.accept();
        System.out.println("Добавлен клиента.");
        server.in = new BufferedReader(new InputStreamReader(server.fromClient.getInputStream()));
        server.out = new PrintWriter(server.fromClient.getOutputStream(), true);
        System.out.println("Ждем обращения...");
        while ((server.input = server.in.readLine()) != null){
            if(server.input.equalsIgnoreCase("exit")) break;
            server.out.println("S ::: " + server.input);
            System.out.println(server.input);
        }
        server.close();
    }

    private void close() throws IOException{
        this.out.close();
        this.in.close();
        this.fromClient.close();
        this.serverSocket.close();
    }
}
