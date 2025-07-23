import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        System.out.println("server started....");
        while (true){
            System.out.println("waiting for connections...");
            Socket socket = serverSocket.accept();
            System.out.printf("Received a connection from %s ",socket.getInetAddress().getHostAddress());
            System.out.println();
            Handler handler = new Handler(socket);
            handler.start();

        }
    }
}
