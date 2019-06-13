package application;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomeController {

    @FXML
    private ListView<?> listaGeneri;

    @FXML
    private ListView<?> listaAnni;

    @FXML
    private ImageView logo;

    @FXML
    private TextField barraRicerca;

    @FXML
    private Button cerca;

    @FXML
    private ImageView imgProfilo;

    @FXML
    private MenuBar menu;

    @FXML
    private MenuItem impostazioni;

    @FXML
    private MenuItem esci;

    @FXML
    private ScrollPane anteprime;

    @FXML
    private ScrollPane piuRecenti;

    private Main main;
    
    public void setMain(Main m)
    {
    	main = m;
    }

    @FXML
    void apriImpostazioni(ActionEvent event)
    {

    }

    @FXML
    void esci(ActionEvent event) throws IOException
    {
    	main.avviaPaginaIniziale();
    }

    @FXML
    void tastoCerca(ActionEvent event) {

    }
        
    public void setLogo()
    {
    	Image img = new Image("risorse" + File.separator + "logo.png");
    	logo.setImage(img);
    }
    
    public void setImmagineProfilo()
    {
    	Image img = new Image("risorse" + File.separator + "avatar.png");
    	imgProfilo.setImage(img);
    }

}