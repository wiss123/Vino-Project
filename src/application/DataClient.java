package application;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * The class {@code DataClient} defines a client that sends a string
 * to a server and receives its answer.
 *
**/

public class DataClient
{
  private static final int SPORT = 4441;
  private static final String SHOST = "localhost";

  /**
   * Runs the client code.
   *
  **/
  public String send(String query)
  { 
	  String Resultas="";  
    try
    {
    	String strAr1;
      Socket client = new Socket(SHOST, SPORT);
      System.out.println("send query To Server : \n");
      
      
      BufferedReader   is = new BufferedReader(new InputStreamReader(client.getInputStream()));
      DataOutputStream os = new DataOutputStream(client.getOutputStream());
     // String Parole = scan.nextLine();
      os.writeBytes(query +"\n");
       Resultas = is.readLine();
      System.out.println("Client received:  \n" );
      
       client.close();
     
   }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return Resultas;
  }

  /**
   * Starts the demo.
   *
   * @param args  the method does not requires arguments.
   *
  **/
  public static void main(final String[] args)
  {
   // new DataClient().send(String query);
  }
}
