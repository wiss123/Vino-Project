package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Resources.OrderDetails;
import Resources.Persone;
import Resources.vino;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.Node;

public class OrderDetailsController implements Initializable {

   
	 @FXML
	    private TextField txtSconto;

	    @FXML
	    private TextField txtTotal;
	 
    @FXML
    private TableColumn<OrderDetails, String> colNomeAqc;
    @FXML
    private TableColumn<OrderDetails, Integer> colQuantitaAqc;
    @FXML
    private TableColumn<OrderDetails, Integer> colPriceAqc;
    
    
    @FXML
    private TableColumn<OrderDetails,Integer> ColTotalAcq;
    
    
    
    

    @FXML
    private Button btnAcquistare;

    @FXML
    private Button btnCancel;

    @FXML
    private TableView<OrderDetails> tableCarello;

    @FXML
    private TextField txtNomeCarta;

    @FXML
    private TextField txtNumerCarta;

    @FXML
    private TextField txtSomeTotal;

    @FXML
    private TextField txt_Indirizzio;

    @FXML
    private DatePicker txtdataConsegna;
    
    private Stage stage;
	  private Scene scene;
	  private Parent root;
	  
	  DatePicker Date;
	 
	  
	  ObservableList<OrderDetails> VinoSelected =FXCollections.observableArrayList();
	  
	  Persone persone = new Persone();
	  
	  void getText(Persone p) {
		  persone = p;
		 
		  txt_Indirizzio.setText( persone.getIndirizzio() );
		 
		  
		  
		  LocalDate date = LocalDate.now();
		  
				  txtdataConsegna.setValue(date.plusDays(10));
		 // txtdataConsegna.setAccessibleText(null);
	  }
	  
	  
	  @Override
	    public void initialize(URL url,ResourceBundle rsb) {
	    	try {
	    		
	    		
	    		
	    		
	    		
	    		loaddata();
			} catch (Exception e) {
				Logger.getLogger(vino.class.getName()).log(Level.SEVERE,null,e);
			}
	    
	    	
	    }

	  void loaddata() {
			
			ColTotalAcq.setCellValueFactory(c -> c.getValue().TotalProperty().asObject());
			colPriceAqc.setCellValueFactory(c -> c.getValue().PriceProperty().asObject());
			colNomeAqc.setCellValueFactory(c -> c.getValue().NomeProductProperty());
			colQuantitaAqc.setCellValueFactory(c -> c.getValue().QuanititaProperty().asObject());
			 
			tableCarello.setItems(VinoSelected);
	  }
	  
	  
	  
	  

    @FXML
    void Acquistare(ActionEvent event) {
    	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
    	  LocalDateTime now = LocalDateTime.now();   
    	 
    	
    	 DataClient dataclient = new DataClient();
    	 
    	 String Where = "(IdOrdine, IdPersone,Date)  | (" +VinoSelected.get(0).idOrder() + "," + persone.getIdPersona()   +",'" +  dtf.format(now) + "' )";
	     
    	 System.out.println("IS: "+ dataclient.send("Insert |" + "ordinedetails"  +"|"+   Where ).contains("true"));
    	 
    	 if(dataclient.send("Insert |" + "ordinedetails"  +"|"+   Where ).contains("true")) {
    		 
    		 for(OrderDetails item: tableCarello.getItems()) {
    	    	 String	 Wheres = "(IdOrdine, IdVino,Quantita)  | (" +VinoSelected.get(0).idOrder() +"," + item.idVino() +","+ item.Quanitita()  +    ")";
    	    	 if(dataclient.send("Insert |" + "ordine"  +"|"+   Wheres ).contains("true")) {
    	    	
    	    			 
    	    			
    	    		
    	   		    
    	   		  
    	   				  
    	   		 
    	        		 
    	        		 
    	        	 }
    				

    			
    				  }
    	 }
    	 
    	 Alert alert = new Alert(AlertType.CONFIRMATION, "Saved: ");
  		  alert.showAndWait();
  		try {
  			stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
  		  
  	        
  	         
  	         stage.close(); 
  	    
   		  
 	        
	         
	        
  		     FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
				root = loader.load();
				 stage =(Stage) ((Node)event.getSource()).getScene().getWindow();   
	             scene = new Scene(root);
	             stage.setScene(scene);
	             stage.show();    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 
    }

    

      


 
	 
	
	
	  public void getVinoSelected(TableView<OrderDetails> GetVino) {
		  int Sconto =0;
		  int totalprice=0;
		  for(OrderDetails item: GetVino.getItems()) {
			  VinoSelected.add(new OrderDetails(1,persone.getIdPersona(),item.idVino(),item.Quanitita(),item.getPrice(),item.NomeProduct(),item.getTotal())); 
			  totalprice+=item.getTotal();
			 if (item.Quanitita()>6) {Sconto+=2;}
			 else if(item.Quanitita()>12) {Sconto+=3;}
		  }
		  txtSomeTotal.setText((totalprice) + " EURO ");
		 // txtSconto.setText("");
		  
		  //txtTotal.setText(String.valueOf((totalprice*100)/Sconto));
	  }
	  
	  
	  
    @FXML
    void Back(ActionEvent event) throws IOException {
    	  
		 
    	 
		  
				  
		  stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
		  
        
         
         stage.close();      
    

}
    }
