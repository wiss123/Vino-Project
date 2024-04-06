package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Resources.Persone;
public class RegisterController {
	 private Stage stage;
	  private Scene scene;
	  private Parent root;
	
	Persone p = new Persone();
	
	
	   @FXML
	    private Button btnExit;

	    @FXML
	    private Button btnSave;

	    @FXML
	    private TextField txtCognome;

	    @FXML
	    private TextField txtEmail;

	    @FXML
	    private TextField txtIndirzzio;

	    @FXML
	    private TextField txtNome;

	    @FXML
	    private TextField txtPassword;

	    @FXML
	    private TextField txtPhone;

	    @FXML
	    private TextField txtcodicefiscale;

	    @FXML
	    void Exit(ActionEvent event) throws IOException {
	    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
			  root = loader.load();
			  
					  
			  stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
			  
	         
	          scene = new Scene(root);
	          stage.setScene(scene);
	          stage.show();
	    	
	    }

	    @FXML
	    void Save(ActionEvent event) {
	    	getText();
	    	String Where = "(Nome, Cognome, Codice_fiscale, Email, Phone, Indirizzio, Password) | ("
	    			+ p.getNome() + "," + p.getCognome() + "," + p.getCodicefiscale() + "," + p.getEmail() + ","
	    			+ p.getPhone() + ","+ p.getIndirizzio() + "," + p.getPassword() + ")" ;
	    			 
	    	 
	    	
	    	SelectData("Persone",Where);
	    }

	    public void getText() {
	    	p.setNome(txtNome.getText());
	    	p.setCognome(txtCognome.getText());
	    	p.setEmail(txtEmail.getText());
	    	p.setPassword(txtPassword.getText());
	    	p.setIndirizzio(txtIndirzzio.getText());
	    	p.setCodicefiscale(txtcodicefiscale.getText());
	    	p.setPhone(txtPhone.getText());
	    }
	    
	    void SelectData(String tableName,String Where)   {
			  
			  DataClient dataclient = new DataClient();
			 
			  
			 if(dataclient.send("Insert |" + tableName  +"|"+   Where ).contains("true")) {
				
				  System.out.println("waaaaaaaaaaaaaaw "); 
			         
			  }
			            
			            
			         
			   
		 
			  }
	    
	    
	}
