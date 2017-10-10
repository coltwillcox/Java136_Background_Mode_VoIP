import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CD_PC-43 on 09.10.2017.
 */

public class Boot {

    public static void main(String[] args) {
        ServerSocket ss;
        Socket s;
        DataOutputStream dos;

        try {
            ss = new ServerSocket(4444);
            System.out.println("Server started.");
            while (true) {
                try {
                    s = ss.accept();
                    System.out.println("Client connected.");
                    dos = new DataOutputStream(s.getOutputStream());

                    try {
                        int ch = 0;
                        while (true) {
                            System.out.println("Sending " + String.format("%03d", ch));
                            dos.writeUTF(String.format("%03d", ch));
                            dos.flush();
                            ch++;
                            Thread.sleep(500);
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e);
                    }

                } catch (IOException e) {
                    System.out.println("Accepted: 4444");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}