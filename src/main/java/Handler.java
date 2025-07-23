import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Handler extends Thread{
    private Socket socket;
    Handler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while((line = reader.readLine()) != null){
                if(line.equals("_END_")) break;
                System.out.println(line);
            }
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println("Received your greeting");
            writer.println("Thanks");
            writer.println("_END_");
            writer.close();
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
