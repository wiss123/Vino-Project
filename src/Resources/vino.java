package Resources;

import java.time.LocalDate;
import java.util.Date;
import javafx.beans.property.*;

public class vino {
   private final SimpleStringProperty Nome ;
   private IntegerProperty IdVino  = new SimpleIntegerProperty() ;
   private StringProperty Produttore  = new SimpleStringProperty() ;
   private StringProperty Provenienza = new SimpleStringProperty() ;
   private StringProperty Note= new SimpleStringProperty(); 
   private StringProperty Vitignis = new SimpleStringProperty(); 
//   private DateProperty  Anno = new SimpleDateProperty();;
   private IntegerProperty Prezzo = new SimpleIntegerProperty();
   private StringProperty Anno  = new SimpleStringProperty(); ;
   private IntegerProperty Disponibile = new SimpleIntegerProperty();
   
   public vino() {
	this.Nome = new SimpleStringProperty();
	   
   }
   
   public vino( String Nome,String Produttore,String Provenienza,String Anno,String Note,String Vitignis,int Prezzo,int Idvino,int Disponibile) {
		this.Nome= new SimpleStringProperty(Nome);
		this.Produttore.set(Produttore);
		this.Provenienza.set(Provenienza);
		this.Note.set(Note);
		this.Prezzo.set(Prezzo);
		this.Anno.set(Anno);
		this.Vitignis.set(Vitignis);
		this.IdVino.set(Idvino);
		this.Disponibile.set(Disponibile);
   }
   
 
   
   public Integer getDisponibile() {
	   return Disponibile.get();
   }
   
   public Integer getIdVino() {
	   return IdVino.get();
   }
 
   
   public String getName() {
       return Nome.get();
   }
 
   public String getProduttore() {
	   return Produttore.get();
   }
   public String getProvenienza() {
	   return Provenienza.get();
   }
   public String getNote() {
	   return Note.get();
   }
   public String getVitigni() {
	   return Vitignis.get();
   }
   public String getAnno() {
	   return Anno.get();
   }
   public Integer getPrezzo() {
	   return Prezzo.get();
   }
   
   
   public void setDisponibile(Integer Disponibile) {
	   this.setIdVino(Disponibile);
   }
   
   public void setIdVino(Integer Idvino) {
	   this.setIdVino(Idvino);
   }
   
   public void setName(String Name) {
	   this.setName(Name);
	   
   }
   public void setPrezzo(String Prezzo) {
	   this.setPrezzo(Prezzo);
   }
   public void setAnno(String Anno) {
	   this.setAnno(Anno);
   }
   public void setVitignis(String Vitignis) {
	   this.setVitignis(Vitignis);
   }
   public void setNote(String Note) {
	   this.setNote(Note);
   }
   public void setProvenienza(String Provenienza) {
	   this.setProvenienza(Provenienza);
   }
   public void setProduttore(String Produttore) {
	   this.setProduttore(Produttore);
   }
   
   
   

   public IntegerProperty DisponibileProperty() {
       return Disponibile;
   }
   
   
   
   public IntegerProperty IdVinoProperty() {
       return IdVino;
   }
   
   
   public StringProperty nameProperty() {
       return Nome;
   }
   

   public StringProperty ProduttoreProperty() {
       return Produttore;
   }
   
   public StringProperty ProvenienzaProperty() {
       return Provenienza;
   }
   
   public StringProperty NoteProperty() {
       return Note;
   }
   
   public StringProperty VitignisProperty() {
       return Vitignis;
   }
   
   public IntegerProperty PrezzoProperty() {
       return Prezzo;
   }
   
   public StringProperty AnnoProperty() {
       return Anno;
   }

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   


}

