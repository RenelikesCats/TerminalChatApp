public class TerminalChat {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Gebruikswijze: java TerminalChat <server|client> <port>\nVoorbeeld: java TerminalChat server 5000");
            System.exit(1);
        }

        String mode = args[0];
        int port = Integer.parseInt(args[1]);

        if (mode.equalsIgnoreCase("server")) {
            Server.startServer(port);
            return;
        }
        if (mode.equalsIgnoreCase("client")) {
            Client.startClient(port);
            return;
        }
        System.err.println("Input error. Gebruik 'server' of 'client'.");
        System.exit(1);
    }
}




