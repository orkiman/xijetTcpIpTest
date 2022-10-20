import java.io.*;
import java.net.Socket;

public class TcpIpTester {
    public static void main(String[] args) throws IOException, InterruptedException {
        String hostname = "127.0.0.1";
        int port = 2222;
//        Thread.sleep(2000);
        while(true) {
            try (Socket socket = new Socket(hostname, port)) {
                        Thread.sleep(2000);
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                String massage = "file=addresses";
                massage = (char) 2 + massage + (char) 3;
//                System.out.println(massage);
                writer.print(massage);
                writer.flush();

                Thread.sleep(4444);
                massage = "17000001";
                massage = (char) 2 + massage + (char) 3;
//                System.out.println(massage);
                writer.print(massage);
                writer.flush();

                InputStream input = socket.getInputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                int b;

                while ((b = reader.read()) !=-1) {
                    System.out.print((char)b);
                }
                System.out.println(5);
                System.out.println();

            }

        }
    }
}
