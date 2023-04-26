import java.net.*;
import java.io.*; 
public class myclient
{
    public static void main(String[] args)
    {
    try 
    {
        System.out.println("client started\n"); 
        Socket soc=new Socket("localhost",8000);

        //stream will be used to read and write(send) data 
        //take user input and userinput is a buffered reader object
        /*BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter a string:"); 
        String str=userinput.readLine();

        //printwriter object is used to send string to server 
        PrintWriter out=new PrintWriter(soc.getOutputStream(),true);
        out.println(str);

        //receive data from server
        BufferedReader userout=new BufferedReader(new InputStreamReader(soc.getInputStream())); 
        System.out.println(userout.readLine()); */

        //read number from user 
        /*BufferedReader userinput=new BufferedReader(new InputStreamReader(System.in)); 
        System.out.println("enter a number:");
        int num1=Integer.parseInt(userinput.readLine()); 
        PrintWriter out=new PrintWriter(soc.getOutputStream(),true); 
        out.println(num1);
        BufferedReader op=new BufferedReader(new InputStreamReader(soc.getInputStream()));
        System.out.println(op.readLine());*/

        //add two numbers 
        BufferedReader userinput=new BufferedReader(new InputStreamReader(System.in)); 
        System.out.println("enter number 1:");
        int num1=Integer.parseInt(userinput.readLine()); 
        BufferedReader userinput2=new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out = new PrintWriter(soc.getOutputStream(),true);
        out.println(num1);
        System.out.println("enter number 2:");
        int num2=Integer.parseInt(userinput2.readLine());
        PrintWriter out2=new PrintWriter(soc.getOutputStream(),true);
        out2.println(num2); 
        BufferedReader op=new BufferedReader(new InputStreamReader(soc.getInputStream())); 
        System.out.println(op.readLine());
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
}
}