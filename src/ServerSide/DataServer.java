package ServerSide;
 

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
 
import java.util.regex.Pattern;
 
import Resources.Tools;


/**
 *
 * The class {@code DataServer} defines a server that waits
 * for a string and then sends an answer.
 *
**/



public class DataServer
{
	 
	 Tools tools = new Tools();
	// Connect con = new Connect();
 
  private static final int SPORT = 4441;
  
  /**
   * Runs the server code.
 * @throws SQLException 
   *
  **/
  public void reply() 
  {
	  //con.connect();
    try
    {
    	 
         while(true) {
      System.out.println("Waiting a client ... ");
      
   //   Scanner scan= new Scanner(System.in);
      ServerSocket server = new ServerSocket(SPORT);
      Socket client = server.accept();
      
    
      BufferedReader   is = new BufferedReader( new InputStreamReader(client.getInputStream()));
      DataOutputStream os = new DataOutputStream(client.getOutputStream());
      
      String Query =  is.readLine();
      
      String Queryarray[] =Query.split(Pattern.quote("|"));
     
     
      
    	    
    		   if(Queryarray[0].contains("Select")) {
    			  
    			  os.writeBytes(tools.select(Queryarray) + "");
    			  
    	   }
    		   else if(Queryarray[0].contains("Insert")) {
    			  
    			 
    		   os.writeBytes(tools.insert(Queryarray) + " ");
    	   }
    		   else if(Queryarray[0].contains("Login")) {
    		   os.writeBytes(tools.StrSelect(Queryarray) + "");
    	   }
    		   else if(Queryarray[0].contains("Update")) {
        		   os.writeBytes(tools.Update(Queryarray) + "");
        	   }
    		   
       
    	  
      client.close();
      server.close();
     
    }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
	   
  }
  
  /**
   * Starts the demo.
   *
   * @param args  the method does not requires arguments.
 * @throws SQLException 
   *
  **
  */
  public static void main(final String[] args)  
  {
    new DataServer().reply();
  
   
  }
  
  
  
}
