import java.io.*;
import java.net.*;
import java.util.*;

class pracTCPC{
    public static void main(String args[]) throws Exception{
        int s,n1,n2;
        Scanner inFromUser=new Scanner(System.in);
        System.out.println("Enter the first number: ");
        n1=inFromUser.nextInt();
        System.out.println("Enter the second number: ");
        n2=inFromUser.nextInt();
        Socket clientSocket=new Socket("localhost",5678);
        DataOutputStream outtoServer= new DataOutputStream(clientSocket.getOutputStream());
        outtoServer.writeInt(n1);
        outtoServer.writeInt(n2);
        DataInputStream inFromServer=new DataInputStream(clientSocket.getInputStream());
        s=inFromServer.readInt();
        System.out.println("Sum of "+n1+" and "+n2+" = " + s);
        clientSocket.close();
    }
}