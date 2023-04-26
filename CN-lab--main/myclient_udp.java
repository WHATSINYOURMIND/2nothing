import java.io.*;
import java.net.*;

public class myclient_udp {
    public static void main(String[] args) {
        try {
            System.out.println("client started\n");
            DatagramSocket soc = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 8000;

            // Add two numbers
            BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter number 1:");
            int num1 = Integer.parseInt(userinput.readLine());
            System.out.println("Enter number 2:");
            int num2 = Integer.parseInt(userinput.readLine());

            // Convert numbers to bytes
            String sendData = num1 + "," + num2;
            byte[] sendDataBytes = sendData.getBytes();

            // Send data to server
            DatagramPacket sendPacket = new DatagramPacket(sendDataBytes, sendDataBytes.length, serverAddress,
                    serverPort);
            soc.send(sendPacket);

            // Receive result from server
            byte[] receiveDataBytes = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveDataBytes, receiveDataBytes.length);
            soc.receive(receivePacket);
            String result = new String(receivePacket.getData(), 0, receivePacket.getLength());

            System.out.println("Result: " + result);
            soc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
