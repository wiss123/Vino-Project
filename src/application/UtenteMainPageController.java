package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import Resources.OrderDetails;
import Resources.Persone;
import Resources.vino;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class UtenteMainPageController implements Initializable {

    @FXML
    private TableColumn<?, ?> ColAnno1;

    @FXML
    private TableColumn<?, ?> ColAnno11;

    @FXML
    private TableColumn<?, ?> ColAnno111;

    @FXML
    private TableColumn<?, ?> ColAnno112;

    @FXML
    private TableColumn<Persone, String>ColCodiceFiscale;

    @FXML
    private TableColumn<Persone, String> ColCognome;

    @FXML
    private TableColumn<?, ?> ColDisponibile1;

    @FXML
    private TableColumn<?, ?> ColDisponibile11;

    @FXML
    private TableColumn<?, ?> ColDisponibile111;

    @FXML
    private TableColumn<?, ?> ColDisponibile112;

    @FXML
    private TableColumn<Persone, String> ColEmail;

    @FXML
    private TableColumn<Persone, String>ColName;

    @FXML
    private TableColumn<?, ?> ColName1;

    @FXML
    private TableColumn<?, ?> ColName11;

    @FXML
    private TableColumn<?, ?> ColName111;

    @FXML
    private TableColumn<?, ?> ColName112;

    @FXML
    private TableColumn<?, ?> ColNote1;

    @FXML
    private TableColumn<?, ?> ColNote11;

    @FXML
    private TableColumn<?, ?> ColNote111;

    @FXML
    private TableColumn<?, ?> ColNote112;

    @FXML
    private TableColumn<Persone, String> ColPassword;

    @FXML
    private TableColumn<Persone, String> ColPhone;

    @FXML
    private TableColumn<Persone, String>  colIndirizzio;

    @FXML
    private TableColumn<?, ?> ColPrezzo11;

    @FXML
    private TableColumn<?, ?> ColPrezzo111;

    @FXML
    private TableColumn<?, ?> ColPrezzo112;

    @FXML
    private TableColumn<?, ?> ColProduttore1;

    @FXML
    private TableColumn<?, ?> ColProduttore11;

    @FXML
    private TableColumn<?, ?> ColProduttore111;

    @FXML
    private TableColumn<?, ?> ColProduttore112;

    @FXML
    private TableColumn<?, ?> ColProvenienza1;

    @FXML
    private TableColumn<?, ?> ColProvenienza11;

    @FXML
    private TableColumn<?, ?> ColProvenienza111;

    @FXML
    private TableColumn<?, ?> ColProvenienza112;

    @FXML
    private TableColumn<?, ?> ColVitgini1;

    @FXML
    private TableColumn<?, ?> ColVitgini11;

    @FXML
    private TableColumn<?, ?> ColVitgini111;

    @FXML
    private TableColumn<?, ?> ColVitgini112;

    @FXML
    private TableView<?> VinoTable11;

    @FXML
    private TableView<?> VinoTable111;

    @FXML
    private TableView<?> VinoTable112;

    @FXML
    private TableView<Persone> TableviewUser;

    @FXML
    private TableView<vino> TableviewVino;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;
    
    @FXML
    private TextField txtNomSearch;
    
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCodiceFiscale;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;


    @FXML
    private TextField txtPhone;


    ObservableList<Persone> PersoneList =  FXCollections.observableArrayList();
    FilteredList<Persone> searchPersonelist =  new FilteredList<>(PersoneList, b -> true);
     
    @FXML
	  void getSelectedPersone(MouseEvent e) {
    	 
    	ObservableList<Persone> PersoneLists = TableviewUser.getSelectionModel().getSelectedItems();
			if (PersoneList.get(0).getIdPersona()<-1) {
				System.out.println("Error\n");
			} 
			 
			
			txtNome.setText(PersoneLists.get(0).getNome());
			txtEmail.setText(PersoneLists.get(0).getEmail());
			txtCognome.setText(PersoneLists.get(0).getCognome());
			txtCodiceFiscale.setText(PersoneLists.get(0).getCodicefiscale());
			txtPassword.setText(PersoneLists.get(0).getPassword());
			txtPhone.setText(PersoneLists.get(0).getPhone());
			
			
			
			 
	  }
	  
    @FXML
    void OnClear(ActionEvent event) throws IOException {
    	 
    	
    	
    	txtNome.clear();
		txtEmail.clear();
		txtCognome.clear();
		txtCodiceFiscale.clear();
		txtPassword.clear();
		txtPhone.clear();
    }
    
    @FXML
    void OnAdd(ActionEvent event) {
    	DataClient dataclient = new DataClient();
    	String Where = "(Nome, Cognome, Codice_fiscale, Email, Phone, Indirizzio, Password) | ('"
    			+ txtNome.getText().strip() + "','" + txtCognome.getText().strip() + "','" + txtCodiceFiscale.getText().strip() + "','" + txtEmail.getText().strip() + "','"
    			+ txtPhone.getText().strip() + "','"+txtPhone.getText().strip() + "','" +txtPassword.getText().strip() + "')" ;
    	System.out.println(Where);
 		 
    	
    	 
    	PersoneList.add(new Persone( 10, txtNome.getText(),txtCognome.getText(),txtCodiceFiscale.getText(),txtEmail.getText(),txtPhone.getText(),txtPhone.getText(),txtPassword.getText(),"1"));
    }
     
    
    @FXML
    void OnUpdate(ActionEvent event) throws IOException {
    	
    	String UpdateQuery="Nome='"+ txtNome.getText().strip() +"',Cognome='"+txtCognome.getText().strip()+"',Codice_fiscale='"+txtCodiceFiscale.getText().strip()+"'"
    			+ ",Email='"+ txtEmail.getText().strip() +"',Phone='"+ txtPhone.getText().strip() +"',Indirizzio= 'Parma',Password= '"+txtPassword.getText().strip()+"'"
    					+ " Where IdPersone='" +PersoneList.get(0).getIdPersona()+"'";
    	//System.out.println(UpdateQuery);
    	 DataClient dataclient = new DataClient();
		 
 		String R =   dataclient.send("Update |persone|"+   UpdateQuery );
 		
 		PersoneList.get(0).setNome(txtNome.getText());
 		PersoneList.get(0).setCodicefiscale(txtCodiceFiscale.getText());
 		PersoneList.get(0).setEmail(txtEmail.getText());
 		PersoneList.get(0).setPassword(txtPassword.getText());
 		PersoneList.get(0).setPhone(txtPhone.getText());
 		PersoneList.get(0).setCognome(txtCognome.getText());
 		//System.out.println("New Update: " +R.toString());
 		//TableviewUser.refresh();
 		//PersoneList.clear();
 		 
    	//SelectData("persone",queryPersone);
 		 
    }

    @FXML
    void OnDelete(ActionEvent event) {
    
    	ObservableList <Persone> alldataa,singledata;
    	alldataa=TableviewUser.getItems();
    	singledata = TableviewUser.getSelectionModel().getSelectedItems(); 
    	singledata.forEach(alldataa::remove);
    }
    
    @FXML
    void OnAddVino(ActionEvent event) {
    	
    }

   

    @FXML
    void OnDeleteVino(ActionEvent event) {

    }

    

    @FXML
    void OnUpdateVino(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			try {
				SelectData("persone",queryPersone);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		loadData();
	}
	
	String queryVino="NomeVino|Produttore|Provenienza|Anno|Note|Vitgini|Prezzo|Idvino|Disponibile 	";
	
 
		private void loadData() {
			// TODO Auto-generated method stub
			 
			
			
			
			//ColPrezzo.setCellValueFactory(new PropertyValueFactory<vino,Integer>("Prezzo"));
			ColPassword.setCellValueFactory(c -> c.getValue().PasswordProperty());
			ColPhone.setCellValueFactory(c -> c.getValue().phoneProperty());
			//ColAnno.setCellValueFactory(c -> c.getValue().AnnoProperty());
			ColName.setCellValueFactory(c -> c.getValue().nomeProperty());
			 ColCognome.setCellValueFactory(c -> c.getValue().CognomePropert1());
			ColEmail.setCellValueFactory(c -> c.getValue().emailProperty());
			ColCodiceFiscale.setCellValueFactory(c -> c.getValue().CodicefiscaleProperty());
			//colIndirizzio.setCellValueFactory(c -> c.getValue().IndirizzioProperty());
			 
			
		 
	 

	    	 txtNomSearch.textProperty().addListener((observale,oldvalue,newvalue) ->{
	    		 searchPersonelist.setPredicate(persone ->{
	    			 if(newvalue == null || newvalue.isEmpty() || newvalue.isBlank()) {
	    				 return true;
	    			 }
	    			 
	    			 String lowerCasefilter = newvalue.toLowerCase();
	    			 
	    			 
	    		 
	    			 if (persone.getNome().toLowerCase().indexOf(lowerCasefilter) > -1) {
	    				   return true;}
	    			 
	    			 else {
	    				 
	    				 return false;}
	    			 
	    			
					
	    		 });
	    		 
	    	 });
	    	 
	    	 SortedList<Persone> PersoneSortList = new SortedList<>(searchPersonelist);
	    	 PersoneSortList.comparatorProperty().bind(TableviewUser.comparatorProperty());
	    	 TableviewUser.setItems(PersoneSortList);
	    	  
	}
	
		
		
		
		

	 
		
		
		String queryPersone="IdPersone|Nome|Cognome|Codice_fiscale|Email|Phone|Indirizzio|Password|isAdmin 	";
		  void SelectData(String tableName,String Where) throws IOException  {
		    	
			  DataClient dataclient = new DataClient();
			 
			String R =   dataclient.send("Select |" + tableName  +"|"+   Where );
			   
			R=R.substring(1); 
			R=R.substring(0,R.length()-1); 
		 
			if (!R.isEmpty()) {
				
				System.out.println(R);
				String Rows[] =R.split(Pattern.quote(",")); //12
			  
				
			System.out.println("Rows length: "+Rows.length);
		    int column=9;
			int index=0;
			 
		
			while(index<Rows.length) {
				
				while(index<column) {
					int IdPersone=Integer.parseInt(Rows[index++].strip());
					String Nome=Rows[index++];
					String Cognome=Rows[index++];
					String Codice_fiscale=Rows[index++];
					String Email=Rows[index++];
					String Phone=Rows[index++];
					String Indirizzio=Rows[index++];
					String Password=Rows[index++];
					String isAdmin=Rows[index++];
					
					PersoneList.add( 	new Persone( IdPersone,Nome,Cognome,Email,Password,Indirizzio,Codice_fiscale,Phone,isAdmin));
							//Integer.parseInt(Nom4.strip())));	
				
				}
	 		
				column +=9;
			}
		 						 
			}else {System.out.println("Error\n");}
		   
			  }
		
		
		  
		  
		  
	
	  
}
