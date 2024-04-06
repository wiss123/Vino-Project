package application;

import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import Resources.OrderDetails;
import Resources.Persone;
import Resources.vino;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import java.text.DateFormat;
public class MainPageController implements Initializable {

 

    @FXML
    private TableColumn<vino, String> ColName;

    @FXML
    private TableColumn<vino, String> ColAnno;
    
    @FXML
    private TableColumn<vino, String> colNomeAc;
    

    @FXML
    private TableColumn<vino, String> ColNote;
    
    @FXML
    private TableColumn<OrderDetails, String> colNomeAqc;
    @FXML
    private TableColumn<OrderDetails, Integer> colQuantitaAqc;
    @FXML
    private TableColumn<OrderDetails, Integer> ColPrice;
    
    
    @FXML
    private TableColumn<OrderDetails,Integer> ColTotalAcq;
    

    @FXML
    private TableColumn<vino, Integer> ColPrezzo;

    @FXML
    private TableColumn<vino, String> ColProduttore;

    @FXML
    private TableColumn<vino, String> ColProvenienza;
    @FXML
    private TableColumn<vino, String> ColVitgini;

  
    @FXML
    private TableView<OrderDetails> TableAcq;
    
    @FXML
    private TableColumn<OrderDetails,Integer> ColPriceAqc;
    
   
    

    @FXML
    private TableView<vino> VinoTable;

    @FXML
    private Button btnAcquistare;

    @FXML
    private Button btnLeft;

    

    @FXML
    private Button btnright;

    @FXML
    private DatePicker txtDateSearch;

    @FXML
    private TextField txtNomSearch;
    
    
    
   // List<vino> data = 1996/12/25;
    Date dt = new Date(); 
    
    	 
    String query="NomeVino|Produttore|Provenienza|Anno|Note|Vitgini|Prezzo|Idvino|Disponibile 	";
   
    
    ObservableList<vino> VinoList =  FXCollections.observableArrayList();
    ObservableList<OrderDetails> VinoSelected =FXCollections.observableArrayList();
             vino v = new vino();
             OrderDetails orderdetails =  new OrderDetails();
           
   		  private Scene scene;
   		  private Parent root;
   		  
   		  
   		  Persone persone  ;
             
             
             
             
             
             
             
    void SelectData(String tableName,String Where) throws IOException  {
    	
		  DataClient dataclient = new DataClient();
		 
		String R =   dataclient.send("Select |" + tableName  +"|"+   Where );
		   
		R=R.substring(1); 
		R=R.substring(0,R.length()-1); 
	//	R=R.substring(-1);
		if (!R.isEmpty()) {
			System.out.println(R);
			String Rows[] =R.split(Pattern.quote(",")); //12
		    // String newLine[] = R.split(Pattern.quote("|")); //2
			
		System.out.println("Rows length: "+Rows.length);
	    int column=9;
		int index=0;
		//System.out.println(Rows[0]);
	//	Rows[0]=Rows[1].substring(0); 
	
		while(index<Rows.length) {
			
			while(index<column) {
				String Nome=Rows[index++];
				String N=Rows[index++];
				String No=Rows[index++];
				String No12=Rows[index++];
				String No3=Rows[index++];
				String No332=Rows[index++];
				int Nom4=Integer.parseInt(Rows[index++].strip());
				int id =Integer.parseInt(Rows[index++].strip());
				int Disponibile = Integer.parseInt(Rows[index++].strip());
				VinoList.add( 	new vino( Nome,N,No,No12,No3,No332,Nom4,id,Disponibile));
						//Integer.parseInt(Nom4.strip())));	
			
			}
 		
			column +=9;
		}
		
		
		 
			
		 
		    
				 
		 
				
				
			
								 
		}else {System.out.println("Error\n");}
		/* String R[] = dataclient.send("Select |" + tableName  +"|"+   Where ).;
		  if (!R.isEmpty()) {
			System.out.println(R);
			   
		           
		  }
		  */           
		            
		         
		   
	 
		  }
    
    
    
    
    @Override
    public void initialize(URL url,ResourceBundle rsb) {
    	try {
    		
    		SelectData("vino",query);
    		
    		 
    		loadData();
		} catch (Exception e) {
			Logger.getLogger(vino.class.getName()).log(Level.SEVERE,null,e);
		}
    
    	
    }




	private void loadData() {
		// TODO Auto-generated method stub
		 
		//ColPrezzo.setCellValueFactory(new PropertyValueFactory<vino,Integer>("Prezzo"));
		ColPrezzo.setCellValueFactory(c -> c.getValue().PrezzoProperty().asObject());
		ColName.setCellValueFactory(c -> c.getValue().nameProperty());
		//ColAnno.setCellValueFactory(c -> c.getValue().AnnoProperty());
		ColNote.setCellValueFactory(c -> c.getValue().NoteProperty());
		 ColAnno.setCellValueFactory(c -> c.getValue().AnnoProperty());
		ColProduttore.setCellValueFactory(c -> c.getValue().ProduttoreProperty());
		ColProvenienza.setCellValueFactory(c -> c.getValue().ProvenienzaProperty());
		ColVitgini.setCellValueFactory(c -> c.getValue().VitignisProperty());
		 
		
		
		ColTotalAcq.setCellValueFactory(c -> c.getValue().TotalProperty().asObject());
		ColPriceAqc.setCellValueFactory(c -> c.getValue().PriceProperty().asObject());
		colNomeAqc.setCellValueFactory(c -> c.getValue().NomeProductProperty());
		colQuantitaAqc.setCellValueFactory(c -> c.getValue().QuanititaProperty().asObject());
		TableAcq.setEditable(true);
		colQuantitaAqc.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		 
		
		
		
		 FilteredList<vino> searchlist =  new FilteredList<>(VinoList, b -> true);

    	 txtNomSearch.textProperty().addListener((observale,oldvalue,newvalue) ->{
    		 searchlist.setPredicate(vino ->{
    			 if(newvalue == null || newvalue.isEmpty() || newvalue.isBlank()) {
    				 return true;
    			 }
    			 
    			 String lowerCasefilter = newvalue.toLowerCase();
    			 
    			 
    		 
    			 if (vino.getName().toLowerCase().indexOf(lowerCasefilter) > -1) {
    				   return true;}
    			 
    			 else {
    				 
    				 return false;}
    			 
    			
				
    		 });
    		 
    	 });
    	 
    	 SortedList<vino> sortlist = new SortedList<>(searchlist);
    	 sortlist.comparatorProperty().bind(VinoTable.comparatorProperty());
    	 VinoTable.setItems(sortlist);
    	 TableAcq.setItems(VinoSelected);
		//VinoTable.setItems(VinoList);
	 
		 
	//	VinoTable.getColumns().addAll(ColName);
 
	}
    
   
    
	    @FXML
	    void DeleteVino(ActionEvent event) {
	    	ObservableList <OrderDetails> alldataa,singledata;
	    	alldataa=TableAcq.getItems();
	    	singledata = TableAcq.getSelectionModel().getSelectedItems(); 
	    	singledata.forEach(alldataa::remove);
	    	 
	    	 
	    }

	    @FXML
	    void selectVino(ActionEvent event) {
	    	 
	    	VinoList = VinoTable.getSelectionModel().getSelectedItems();
	    	 
	    	
	    	boolean found=false;
	    	 //System.out.println(VinoList.get(0).getName()  + " - ");
	    	
	   
	    	if(Bindings.isEmpty(TableAcq.getItems()).get()) {
	    		 VinoSelected.add(new OrderDetails(1,1,VinoList.get(0).getIdVino(),1,VinoList.get(0).getPrezzo(),VinoList.get(0).getName(),VinoList.get(0).getPrezzo()));
	    		 
	     }else {
	    	 for(OrderDetails item: TableAcq.getItems()) {
              
	    		 if (item.NomeProduct().contains( VinoList.get(0).getName())) {
	    			 
	    			 found=true;break; // Item Esiste
	    		 }  
	    		   }
	    	  if (found==false) {
	    		   
	    		  VinoSelected.add(new OrderDetails(1,1,VinoList.get(0).getIdVino(),1,VinoList.get(0).getPrezzo(),VinoList.get(0).getName(),VinoList.get(0).getPrezzo())); 
	    	  }else {
	    		  Alert alert = new Alert(AlertType.WARNING, "Il Vino è gia esiste!");
	    		  alert.showAndWait();
	    	  }
	    }
	    }
	    @FXML
	    void OnEditChange(TableColumn.CellEditEvent<OrderDetails, Integer> p) {
	    	VinoList = VinoTable.getSelectionModel().getSelectedItems();
	    	orderdetails =  TableAcq.getSelectionModel().getSelectedItem();
	    	// TableAcq.setSelectionModel(null);
	        int OldQt = VinoList.get(0).getDisponibile();
	    	int newQT = p .getNewValue();
	    	int total = orderdetails.getPrice() * newQT;
	    	if (OldQt< newQT) {
	    		 Alert alert = new Alert(AlertType.WARNING, "Max: " + OldQt);
	    		  alert.showAndWait();
	    		  orderdetails.setQuanitita(1);	  // reset La Quantita 
	    	}
	    		  else
	    		  {
	    			  orderdetails.setQuanitita(p.getNewValue());
	                  orderdetails.setTotal(total); 
	                 
	    		  }
	    	
	    	 TableAcq.refresh();
                
                 
                
               
         
                 
	    }
	   
		  void getPersoneData(Persone p) {
			  persone = p; 	 
		  }
		  
    
	    @FXML
	    void Ordine(ActionEvent event) {
	     
	    	try {
	    		 if (VinoList.isEmpty()) {
	    			  Alert alert = new Alert(AlertType.WARNING, "Choose Wine First!");
	        		  alert.showAndWait();
	    		 }else {
				  FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderDetails.fxml"));
		           root = loader.load();
		           OrderDetailsController controller = loader.getController();
		           controller.getVinoSelected(TableAcq);
		           controller.getText(persone);
		           Stage stage = new Stage();
		          // stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
		           stage.initStyle(StageStyle.DECORATED);
		         //  stage.alwaysOnTopProperty();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();      
	    		 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			
	    }
	 @FXML
    void OnProposta(ActionEvent event) throws IOException {	
		 VinoList = VinoTable.getSelectionModel().getSelectedItems();
		 if (VinoList.isEmpty()) {
			  Alert alert = new Alert(AlertType.WARNING, "Choose Wine First!");
    		  alert.showAndWait();
		 }
		 else {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("Proposta.fxml")); 
		 root = loader.load();
		 PropostaController controller = loader.getController();
		 controller.GetData(persone,VinoList.get(0).getIdVino(),VinoList.get(0).getName());
        
		   Stage stage = new Stage();
		   scene = new Scene(root);
           stage.setScene(scene);
           stage.show();      
	    }}
}
