package application;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SplashController
{
	@FXML
    private ImageView logo;

    @FXML
    private Button entra;

    @FXML
    private Button registrati;

    private Main main;
    
    public void setMain(Main m)
    {
    	main = m;
    }
    @FXML
    void entra(ActionEvent event) throws IOException
    {
   // 	apriFinestra("Login.fxml", "Login");
    	main.avviaLogin();
    }

    @FXML
    void registrati(ActionEvent event) throws IOException
    {
    //	apriFinestra("Signin.fxml","Iscriviti");
    	main.avviaSignin();
    }

    public void setLogo()
    {
    	Image img = new Image("risorse" + File.separator + "logo.png");
    	logo.setImage(img);
    	logo.setPreserveRatio(true);
    	double scaleX = logo.getScene().getWidth()/img.getWidth();
    	double scaleY = logo.getScene().getHeight()/img.getHeight();
    	logo.setFitWidth(logo.getFitWidth()*scaleX);
    	logo.setFitHeight(logo.getFitHeight()*scaleY);
    }
    
    public void apriFinestra(String fxml, String titolo) throws IOException
    {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
		AnchorPane root = (AnchorPane)loader.load();
		Scene scena = new Scene(root);
		Stage stage = new Stage();		
		stage.setScene(scena);
		stage.setTitle(titolo);
		stage.setResizable(false);
		stage.show();
    }
}
