import java.net.*;
import java.io.*;
import java.util.*;

class pracUDPS {
    public static void main(String args[]) throws Exception {
        String infromClient;
        String modified;
        DatagramSocket serverSocket = new DatagramSocket(3456);
        byte[] receiveData =new byte[1024];
        byte[] sendData=new byte[1024];
        while(true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
            serverSocket.receive(receivePacket);
            infromClient = new String(receivePacket.getData());
            System.out.println("Received from server: "+infromClient);
            modified= infromClient.toUpperCase();
            System.out.println("Sending "+modified+" to client");
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            sendData = modified.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}