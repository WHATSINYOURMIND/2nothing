import java.io.*;
import java.net.*;
import java.util.*;

class pracTCPS{
    public static void main(String args[]) throws Exception{
        int n1,n2,sum;
        ServerSocket welcomeSocket=new ServerSocket(5678);
        while (true){
            Socket connectionsocket= welcomeSocket.accept();
            DataInputStream inFromClient=new DataInputStream(connectionsocket.getInputStream());
            n1=inFromClient.readInt();
            n2=inFromClient.readInt();
            System.out.println("Received the first number as: "+n1);
            System.out.println("Received the second number as: "+n2);
            sum=n1+n2;
            System.out.println("Sum calculated is "+sum);
            DataOutputStream outtoClient= new DataOutputStream(connectionsocket.getOutputStream());
            outtoClient.writeInt(sum);
        }
    }
}