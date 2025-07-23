import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",3000);
            System.out.println("sending a request..");
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println("Hello how are you?");
            writer.println("Greetings from me");
            writer.println("_END_");
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null){
                if(line.equals("_END_")) break;
                System.out.println(line);
            }
            socket.close();
            System.out.println("connection closed");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
