import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void startServer(int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server gestart op poortnummer: " + port);

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected: " + clientSocket);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        Scanner scanner = new Scanner(System.in);

        new Thread(() -> {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Client: " + message);
                }
            } catch (IOException e) {
                System.out.println("Client disconnected.");
            }
        }).start();

        String serverMessage;
        while (true) {
            serverMessage = scanner.nextLine();
            out.println(serverMessage);
        }
    }
}
