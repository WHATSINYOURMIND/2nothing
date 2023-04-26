import java.io.*;
import java.net.*;

public class myserver_udp {
    public static void main(String args[]) {
        try {
            System.out.println("Waiting for connection...\n");
            DatagramSocket ss = new DatagramSocket(8000);
            byte[] receiveDataBytes = new byte[1024];

            // Receive data from client
            DatagramPacket receivePacket = new DatagramPacket(receiveDataBytes, receiveDataBytes.length);
            ss.receive(receivePacket);
            String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
            String[] nums = receivedData.split(",");
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[1]);

            System.out.println("Connection established\n");

            // Calculate sum
            float sum = num1 + num2;
            String result = Float.toString(sum);

            // Send result to client
            byte[] sendDataBytes = result.getBytes();
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(sendDataBytes, sendDataBytes.length, clientAddress,
                    clientPort);
            ss.send(sendPacket);
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
