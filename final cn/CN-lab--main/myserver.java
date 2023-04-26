import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.io.*; 
public class myserver
{
    public static void main(String args[])
    {
    try 
    {
            System.out.println("Waiting for connection...\n"); 
            //object for server socket is created
            ServerSocket ss=new ServerSocket(8000); 
            //block until request is received
            Socket soc=ss.accept(); 
            System.out.println("connection established\n");

            //read input stream sent bu user 
            /*BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream())); 
            String str=in.readLine(); 
            //send captured string to user again 
            PrintWriter out = new PrintWriter(soc.getOutputStream(),true); 
            out.println("server says:"+str);*/ 

            /*BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream())); 
            int num1=Integer.parseInt(in.readLine());
            PrintWriter out=new PrintWriter(soc.getOutputStream(),true);
            out.println("Factorial of number is:"+fact_cal(num1));*/

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream())); 
            int num1=Integer.parseInt(in.readLine());
            PrintWriter out=new PrintWriter(soc.getOutputStream(),true); 
            BufferedReader in2=new BufferedReader(new InputStreamReader(soc.getInputStream()));
            int num2=Integer.parseInt(in2.readLine());
            PrintWriter out2=new PrintWriter(soc.getOutputStream(),true);
            float sum=num1+num2;
            out.println(sum); 
            out.flush(); 
    } 
    catch (Exception e) 
    {
       e.printStackTrace();
    }
}
/*static int fact_cal(int num1)
    {
        int fact=1; 
        for(int i=1;i<=num1;i++)
        {
            fact=fact*i; 
        }
        return fact; 
    }*/
}