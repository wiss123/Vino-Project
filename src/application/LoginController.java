package application;
	
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import Resources.*;

import java.io.IOException;
import java.sql.*;
import java.util.regex.Pattern;




public class LoginController extends Application {
	 Persone p = new Persone();
	 
	 
	
	 @FXML // fx:id="btnLogin"
	    private Button btnLogin; // Value injected by FXMLLoader

	    @FXML // fx:id="btnRegister"
	    private Button btnRegister; // Value injected by FXMLLoader

	    @FXML // fx:id="txtEmail"
	    private TextField txtEmail; // Value injected by FXMLLoader

	    @FXML // fx:id="txtPassword"
	    private PasswordField txtPassword; // Value injected by FXMLLoader
	
	    @FXML
	    private ChoiceBox<String> mychoicebox  ;
	     
	    private String[] utente = {"admin","Cliente"};
	
	public static void main(String[] args) {
		
		launch(args);
	}




	@Override
	public void start(Stage stage) throws Exception {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		   	Scene  scene = new Scene(root);
		   	stage.setScene(scene);
		   	stage.show();
		  
		   
		   	//Combobox.setItems(FXCollections.observableArrayList("client","Admin","Fornitore"));
		 	//Combobox.getItems().add("ss");
		} catch(Exception e) {
			e.printStackTrace();
		}
	 	
	
	}
	
	


	 void GetText() {
		
		 p.setEmail(txtEmail.getText());
		 p.setPassword(txtPassword.getText());
		
		
		 
	 }
	
	 
	 
	  private Stage stage;
	  private Scene scene;
	  private Parent root;
	  
	  void SelectData(String tableName,String Where,ActionEvent event) throws IOException  {
		  
		  DataClient dataclient = new DataClient();
		  
		 String R = dataclient.send("Login |" + tableName  +"|"+   Where + "|Nome|Cognome|Codice_fiscale|Phone|Indirizzio|IdPersone|isAdmin"
		 		+ "|Indirizzio|Phone");
		  
		 if (!R.isEmpty()) {
				System.out.println(R);
				String Rows[] =R.split(Pattern.quote(",")); //12
				p.setNome(Rows[0]);
				p.setCognome(Rows[1]);
				p.setCodicefiscale(Rows[2]);
				p.setPhone(Rows[3]);
				p.setIndirizzio(Rows[4]);
				p.setIdPersona(Integer.parseInt(Rows[5].strip()));
				p.setisAdmin(Rows[6].strip());
				
				String Pagina="";
				if (p.getisAdmin().contains("1")) {
					Pagina="UtenteMainPage.fxml";
				}
				FXMLLoader loader = new FXMLLoader(getClass().getResource(Pagina));
		           root = loader.load();
		          // MainPageController controller = loader.getController();
		         //  controller.getPersoneData(p);;
		           stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();    
				}
		 
		 
	/*	  if(dataclient.send("Login |" + tableName  +"|"+   Where + "| Email |Password").contains("true")) {
			
			   
		             
		  }
		*/             
		            
		         
		   
	 
		  }
	 
	
	public void actionLogin(ActionEvent event) throws IOException {
		
		
		GetText();
		String Where = "Email = " + p.getEmail() + " and Password = " + p.getPassword();
		SelectData("Persone",Where,event);
    
		
	 
    	
     
	}
	
	
	void setData() {
		
	}
	
	
    public void actionRegister(ActionEvent event) throws IOException {
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
		  root = loader.load();
		  
				  
		  stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
		  
         
          scene = new Scene(root);
          stage.setScene(scene);
          stage.show();      
 			 
    	
    }
	

    
    
    
}

	
	
	
 
