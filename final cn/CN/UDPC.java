import java.util.*;
import java.io.*;
import java.net.*;

class pracUDPC {
    public static void main(String args[]) throws Exception{
        String s,m;
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        Scanner infromuser= new Scanner(System.in);
        System.out.println("Enter the string: ");
        s=infromuser.nextLine();
        byte[] sendData=new byte[1024];
        byte[] receiveData=new byte[1024];
        sendData=s.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,3456);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        m=new String (receivePacket.getData());
        System.out.println("Sentence in uppercase is: "+m);
        clientSocket.close();
    }
}