package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController
{
	@FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML 
    private Button login;

    @FXML
    private Button annulla;
    
    private Main main;
    
    public void setMain(Main m)
    {
    	main = m;
    }
    
    @FXML
    void annulla(ActionEvent event) throws IOException//chiude il form di login
    {
    	main.avviaPaginaIniziale();
    }

    @FXML
    void login(ActionEvent event) throws IOException//cambia la scena principale se il controllo di username e password va a buon fine
    {
    	main.avviaHome();
    }

    @FXML
    void password(ActionEvent event)//controlla la correttezza della password immessa
    {

    }

    @FXML
    void username(ActionEvent event)//controlla se l'utente è registrato
    {

    }
}