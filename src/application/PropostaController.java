package application;

import Resources.Persone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PropostaController  {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnProposta;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtIndirizzio;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNumVino;

    @FXML
    private TextField txtVino;

    @FXML
    void OnCancel(ActionEvent event) {

    }

    @FXML
    void OnProposta(ActionEvent event) {

    }
    
    void GetData(Persone p,int idvino,String nomeVino) {
    	txtNome.setText(p.getNome());
    	txtCognome.setText(p.getCognome());
    	txtIndirizzio.setText(p.getIndirizzio());
    	txtVino.setText(nomeVino);
    }
    

}
