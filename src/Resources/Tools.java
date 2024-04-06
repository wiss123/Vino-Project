package Resources;

 
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ServerSide.Connect;
import javafx.fxml.Initializable;
 


public class Tools implements Initializable {
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 Statement stat = null;
	 ResultSet resultset = null  ;
	 String dataquery []=null;
	 
	 PreparedStatement pst = null;
	 Connect con = new Connect();
	
	 
	 public boolean Update(String querryarray[]) {
		 try {
	    	  con.connect();
			 
			 System.out.println("\nUpdate " + querryarray[1] + " SET " + querryarray[2] );
			 
			 
		 	
				stat.executeUpdate("Update " + querryarray[1] + " SET " + querryarray[2]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("EROOOORS! "); 
	            System.err.println(e.getMessage()); 
	            return false;
			}
			 
			 
			 //"('[value-2]','[value-3]','[value-4]','[value-5]','[value-6]','[value-7]','[value-8]')");
			 return true;
		 
	 }
	 
	 
	 
      public boolean insert(String querryarray[]) {
    	  try {
    	  con.connect();
		 
		 System.out.println("INSERT INTO " + querryarray[1] + " " + querryarray[2] +" VALUES "+ querryarray[3]);
		 
		 
	 	
			stat.executeUpdate("INSERT INTO " + querryarray[1] + " " + querryarray[2] +" VALUES "+ querryarray[3]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("EROOOORS! "); 
            System.err.println(e.getMessage()); 
            return false;
		}
		 
		 
		 //"('[value-2]','[value-3]','[value-4]','[value-5]','[value-6]','[value-7]','[value-8]')");
		 return true;
	 }
	 
	 
	 public String select(String querryarray[]) {
		 con.connect();
		 
		 String R="";
		 
		 int arraylenght = querryarray.length;
		//String[] strAr1=new String[arraylenght];
		 ArrayList<String> strAr1 = new ArrayList<String>();
	    int indexarray=0;
		 
			try {
				
				 System.out.println("select * From " + querryarray[1] );
			    resultset = stat.executeQuery("select * From " + querryarray[1]);
		        
		         if (!resultset.isBeforeFirst() ) {    
					 
		        	 return "false";
					}else {
		         
		            while(resultset.next()){
		            	for(int i=2;i<arraylenght;i++) {
	                        	 strAr1.add( resultset.getString(querryarray[i].strip()));
	                        	 indexarray++;
	                        	 //strAr1.add("-");
		            		
		            }
		            	 if (resultset.isBeforeFirst() ) {
		            			strAr1.add("|");
		            	 }
		            
		            }
		            for(int i=0;i<strAr1.size();i++) {
		            	 
		            	System.out.print(strAr1.get(i)  );
		            }
						  
		        	return strAr1.toString();
                       
					}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			return "true";
             
			//strAr1
			 
			
	 }
	 
	 
	 
	 public String StrSelect(String querryarray[]) {
		 stat=con.connect();
		 int arraylenght = querryarray.length;
		 ArrayList<String> strAr1 = new ArrayList<String>();
		 int indexarray=0;
			try {
				
				 System.out.println(" boolean select * From " + querryarray[1] + " Where " +  querryarray[2] );
			    resultset = stat.executeQuery("select * From " + querryarray[1] + " Where " +  querryarray[2]);
		        
			    while(resultset.next()){
	            	for(int i=3;i<arraylenght;i++) {
                       	 strAr1.add( resultset.getString(querryarray[i].strip()));
                       	 indexarray++;
                       	 //strAr1.add("-");
	            		
	            }
	            	 if (resultset.isBeforeFirst() ) {
	            			strAr1.add("|");
	            	 }
	            
	            }
			    System.out.print("send Server: "+ strAr1.toString());
	            
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
			return strAr1.toString();
	 }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
	} 
}
