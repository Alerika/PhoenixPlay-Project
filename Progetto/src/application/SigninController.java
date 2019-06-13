package application;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.regex.Pattern;
import client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class SigninController
{
	@FXML
    private Text mail;

    @FXML
    private Text user;

    @FXML
    private Text passw;
    
    @FXML
    private TextField nome;
    
    @FXML
    private TextField cognome;

    @FXML
    private DatePicker data;

    @FXML
    private TextField email;

    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;

    @FXML
    private Button conferma;

    @FXML
    private Button annulla;

    @FXML
    private Label notPass;
    
    @FXML
    private Label notUser;
    
    @FXML
    private Label notMail;
    
    private Main main;
    
    public void setMain(Main m)
    {
    	main = m;
    }
    
    @FXML
    public void annullaIscrizione(ActionEvent event) throws IOException //chiude il form di iscrizione
    {
    	main.avviaPaginaIniziale();
    }

    @SuppressWarnings("unlikely-arg-type")
	@FXML //conferma la registrazione
	public void confermaDati(ActionEvent event) throws UnknownHostException, SQLException, IOException 
	{
    	Client c = new Client();
    	boolean userLibero = usernameLibero();//c.usernameLibero(username.getText());
    	boolean mailValida = mailValida();//Pattern.matches("^[a-zA-Z0-9.!#$%&'+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)$", email.getText());
        boolean passValida = passwordValida();//(password.getText().length() > 8);
      
        if(userLibero && mailValida && passValida)
        {
        		if ( nome.getText().trim().isEmpty()  || cognome.getText().trim().isEmpty()|| username.getText().trim().isEmpty())
        			notUser.setText("CAMPI ERRATI O NON INSERITI!");
        	
        		else 
        		{
        			c.registrazione(nome.getText(), cognome.getText(), data.getPromptText(), mail.getText(), username.getText(), password.getText());
        			main.avviaLogin();
        		}
        	
        }
       
        if(!userLibero)
        {
        	user.setFill(Color.RED);
        	notUser.setText("Username gia' in uso");
        }
        if(!mailValida)
        {
        	mail.setFill(Color.RED);
        	notMail.setText("Email non valida, inserirne una valida!");
        	
        }
        if(!passValida)
        {
        	passw.setFill(Color.RED);
        	notPass.setText("Password non valida, inserire almeno 8 caratteri!");
        }
        
    }

    public boolean mailValida() //controlla se l'email � valida
    {
    	return Pattern.matches("^[a-zA-Z0-9.!#$%&'+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)$", email.getText());	
    }
    
   public boolean passwordValida() //controlla la lunghezza della password
   {
	   String pass = password.getText();
	   notPass.setText("");
	   if(pass.length() < 8)
	   {
		   passw.setFill(Color.RED);
		   notPass.setText("Almeno 8 caratteri!");
		   
		   return false;
	   }
	   else notPass.setText("");
	   return true;
   }
   
 //controlla che lo username non sia gi� in uso
   public boolean usernameLibero() throws SQLException, UnknownHostException, IOException
   {
    	Client c = new Client();
    	notUser.setText("");
    	if(!c.usernameLibero(username.getText()))
    	{
    		mail.setFill(Color.RED);
    		notUser.setText("Username gia' in uso");
    		return false;
    	}
    	return true;
   }
}
