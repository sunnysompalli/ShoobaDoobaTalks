import java.net.*;
import java.util.*;
import java.io.*;
public class ShoobaServer{

    private static int PORT = 39405;

    private static HashSet<String> names = new HashSet<String>();

    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();

    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
	System.out.println("the default port is set to " + PORT + " if you would like to change this port, print yes or no followed by the port you would like");
	if (reader.next().equals("yes")){
	    int tempport =reader.nextInt();
		try {
	    ServerSocket sucket = new ServerSocket( tempport);
            sucket.close();
            PORT = tempport;
            System.out.println("port: " + PORT + " is your new port!");
        }
        catch(Exception e) {
            System.out.println("This port isn't available, the default will be used");
	            }
	    }
	else {
	    System.out.println("The default port will be used");
	}
	
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }



    private static class Handler extends Thread {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;


        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {

                in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    out.println("SUBMITNAME");
                    name = in.readLine();
                    if (name == null) {
                        return;
                    }
                    synchronized (names) {
                        if (!names.contains(name)) {
                            names.add(name);
                            break;
                        }
                    }
                }

                out.println("NAMEACCEPTED");
                writers.add(out);

                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + ": " + input);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (name != null) {
                    names.remove(name);
                }
                if (out != null) {
                    writers.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
