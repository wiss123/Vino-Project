package Resources;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persone {
	 private SimpleIntegerProperty IdPersona = new SimpleIntegerProperty();
	 
   private SimpleStringProperty Email = new SimpleStringProperty();
   private SimpleStringProperty Password = new SimpleStringProperty();
   private SimpleStringProperty Nome = new SimpleStringProperty();
   private SimpleStringProperty Cognome = new SimpleStringProperty();
   private SimpleStringProperty phone = new SimpleStringProperty();
   private SimpleStringProperty Indirizzio = new SimpleStringProperty();
   private SimpleStringProperty Codicefiscale = new SimpleStringProperty();
   private SimpleStringProperty isAdmin  = new SimpleStringProperty();
   
   public Persone() {}
   
   public Persone(int ID,String Name,String Cognome,String Email,String Password,String Indirizzio,String CodiceFiscale,String Phone,String isAdmin){
	   this.IdPersona.set(ID);
	   this.Nome.set(Name);
	   this.Cognome.set(Cognome);
	   this.Email.set(Email);
	   this.Password.set(Password);
	   this.Codicefiscale.set(CodiceFiscale);
	   this.phone.set(Phone);
	   this.isAdmin.set(isAdmin);
   }
   
   
   
   public int getIdPersona() {
		return IdPersona.get();
	}
	public void setIdPersona(int IdPersona) {
		this.IdPersona = new SimpleIntegerProperty(IdPersona);
	}

	public IntegerProperty IdPersonaProperty() {
	    return IdPersona;
	}

	 
   
 

public String getPassword() {
	return Password.get();
}
public void setPassword(String password) {
	this.Password.set(password);
}

public StringProperty PasswordProperty() {
    return Password;
}

public String getNome() {
	return Nome.get();
}
public void setNome(String nome) {
	this.Nome.set(nome);
}
public StringProperty nomeProperty() {
    return Nome;
}

public String getCognome() {
	return Cognome.get();
}
public void setCognome(String cognome) {
	this.Cognome.set(cognome);
}
public StringProperty CognomePropert1() {
    return Cognome;
}


public String getEmail() {
	return Email.get();
}
public void setEmail(String email) {
	this.Email.set(email);
}
public StringProperty emailProperty() {
    return Email;
}

public void setisAdmin(String isAdmin) {
	this.isAdmin.set(isAdmin);
}
public String getisAdmin() {
	return isAdmin.get();
}

public String getPhone() {
	return phone.get();
}
public void setPhone(String phone) {
	this.phone.set(phone);
}
public StringProperty phoneProperty() {
    return phone;
}



public String getIndirizzio() {
	return Indirizzio.get();
}
public void setIndirizzio(String indirizzio) {
	this.Indirizzio.set(indirizzio);;
}
public StringProperty IndirizzioProperty() {
    return Indirizzio;
}


public String getCodicefiscale() {
	return Codicefiscale.get();
}
public void setCodicefiscale(String codicefiscale) {
	this.Codicefiscale.set(codicefiscale);
}
public StringProperty CodicefiscaleProperty() {
    return Codicefiscale;
}




}
