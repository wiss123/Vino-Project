package Resources;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
 
 

public class OrderDetails {
	 private SimpleIntegerProperty idOrder = new SimpleIntegerProperty();
     private SimpleIntegerProperty idCliente = new SimpleIntegerProperty();
     private  SimpleIntegerProperty idVino = new SimpleIntegerProperty();
     private SimpleIntegerProperty Quanitita = new SimpleIntegerProperty();
     private SimpleIntegerProperty Total = new SimpleIntegerProperty();
     private final SimpleIntegerProperty Price = new SimpleIntegerProperty();
     private final StringProperty NomeProduct = new SimpleStringProperty();
    
     
     public OrderDetails() {}

     public OrderDetails(int idOrder,int idCliente,int idVino,int Quanitita,int Price,String NomeProduct,int Total) {
    	 this.idOrder.set(idOrder);
    	 this.idCliente.set(idCliente);
    	 this.idVino.set(idVino);
    	 this.Quanitita.set(Quanitita);
    	 this.Price.set(Price);
    	 this.NomeProduct.set(NomeProduct);
    	 this.Total.set(Total);
     }
     
     public String NomeProduct() {
         return NomeProduct.get();
     }
     public void setNomeProduct(String NomeProduct) {
  	   this.setNomeProduct(NomeProduct);
  	   
     }
     public StringProperty NomeProductProperty() {
         return NomeProduct;
     }
     
     
     
     public Integer getPrice() {
         return Price.get();
     }
     public void setPrice(Integer Price) {
  	   this.setPrice(Price);
  	   
     }
     public IntegerProperty PriceProperty() {
         return Price;
     }
     
     
     
     public Integer getTotal() {
         return Total.get();
     }
     public void setTotal(Integer Total) {
  	  // this.setTotal(Total);
    	 this.Total= new SimpleIntegerProperty(Total);
     }
     public IntegerProperty TotalProperty() {
         return Total;
     }
     
     
     public Integer idCliente() {
         return idCliente.get();
     }
     public void setidCliente(Integer idCliente) {
  	  // this.setidCliente(idCliente);
    	 this.idCliente= new SimpleIntegerProperty(idCliente);
     }
     public IntegerProperty idClienteProperty() {
         return idCliente;
     }
     
     
     
     public Integer idVino() {
         return idVino.get();
     }
     public void setidVino(String idVino) {
  	   this.setidVino(idVino);
  	   
     }
     public IntegerProperty idVinoProperty() {
         return idVino;
     }
     
     
     

     public Integer Quanitita() {
         return Quanitita.get();
     }
     public void setQuanitita(Integer Quanitita) {
  	 //  this.setQuanitita(Quanitita);
  	   this.Quanitita= new SimpleIntegerProperty(Quanitita);
     }
     public IntegerProperty QuanititaProperty() {
         return Quanitita;
     }
     
     
     
     public Integer idOrder() {
         return idOrder.get();
     }
     public void setidOrder(Integer idOrder) {
    	 this.idOrder= new SimpleIntegerProperty(idOrder);
    	 
  	   
     }
     public IntegerProperty idOrderProperty() {
         return idOrder;
     }
     
     
}
