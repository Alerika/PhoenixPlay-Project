package application;
	
import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application
{
	Stage stage;
	Scene scenaIniziale;
	Scene scenaHome;
	Scene scenaLogin;
	Scene scenaSignin;
	Pane root;
	FXMLLoader loader;
	
	@Override
	public void start(Stage primaryStage)
	{
		stage = primaryStage;
		try
		{
			avviaPaginaIniziale();
			avviaHome();
			avviaLogin();
			avviaSignin();

			primaryStage.setScene(scenaIniziale);
			Screen screen = Screen.getPrimary();
			Rectangle2D bounds = screen.getVisualBounds();
			primaryStage.setX(bounds.getMinX());
			primaryStage.setY(bounds.getMinY());
			primaryStage.setWidth(bounds.getWidth());
			primaryStage.setHeight(bounds.getHeight());
			primaryStage.setMaximized(true);
			primaryStage.show();
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	public void setBackground(Pane root)
	{
		Image img = new Image("risorse" + File.separator + "sfondo.png");
		BackgroundSize size = new BackgroundSize(root.getWidth(), root.getHeight(), true, true, true, true);
		BackgroundImage backg = new BackgroundImage(img, null, null, null, size);
		Background sfondo = new Background(backg);
		root.setBackground(sfondo);
	}
	
	public void avviaPaginaIniziale() throws IOException
	{
		stage.setScene(scenaIniziale);
		loader = new FXMLLoader(getClass().getResource("Splash.fxml"));
		root = loader.load();
		scenaIniziale = new Scene(root);
		stage.setTitle("PhoeniXPlay");
		setBackground(root);
		SplashController splash = loader.getController();
		splash.setLogo();
		splash.setMain(this);
	}
	
	public void avviaHome() throws IOException
	{
		stage.setScene(scenaHome);
		loader = new FXMLLoader(getClass().getResource("Home.fxml"));
		root = loader.load();
		scenaHome = new Scene(root);
		stage.setTitle("PhoeniXPlay - Home");
		HomeController home = loader.getController();
		home.setLogo();
		home.setImmagineProfilo();
		home.setMain(this);
	}
	
	public void avviaLogin() throws IOException
	{
		stage.setScene(scenaLogin);
		loader = new FXMLLoader(getClass().getResource("Login.fxml"));
		root = loader.load();
		scenaLogin = new Scene(root);
		stage.setTitle("PhoeniXPlay - Login");
		setBackground(root);
		LoginController login = loader.getController();
		login.setMain(this);
	}
	
	public void avviaSignin() throws IOException
	{
		stage.setScene(scenaSignin);
		loader = new FXMLLoader(getClass().getResource("Signin.fxml"));
		root = loader.load();
		scenaSignin = new Scene(root);
		stage.setTitle("PhoeniXPlay - Signin");
		setBackground(root);
		SigninController signin = loader.getController();
		signin.setMain(this);
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}