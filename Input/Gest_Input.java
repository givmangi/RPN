package Input;
import java.io.*;
public class Gest_Input
{
    public String read()
    {
       InputStreamReader inp=new InputStreamReader(System.in);
       BufferedReader stdin=new BufferedReader(inp);
       String y="";
       try
       {
           y=stdin.readLine();
       }
       catch(Exception yyy)
       {
       }
       return y;
    }  
}