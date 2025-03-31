import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void startClient(int port) throws Exception {
        Socket socket = new Socket("localhost", port);
        System.out.println("Verbonden met server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        Scanner scanner = new Scanner(System.in);

        new Thread(() -> {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Server: " + message);
                }
            } catch (IOException e) {
                System.out.println("Server disconnected.");
            }
        }).start();

        String clientMessage;
        while (true) {
            clientMessage = scanner.nextLine();
            out.println(clientMessage);
        }
    }


}
