package ui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Controller;
import javafx.event.EventHandler;

public class Main extends Application{

	private MajimaGUI gui;
	private Controller accounts;
	
	public static void main(String[] args) {
		launch(args);
	}

	public Main() throws ClassNotFoundException {
		accounts = new Controller();
		gui = new MajimaGUI(accounts);
	}

	public void start(Stage primaryStage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Start.fxml"));
		fxmlLoader.setController(gui);
		Parent parent = fxmlLoader.load();

		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.setHeight(700);
		primaryStage.setWidth(700);
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("images/majima's icon.png"));
		primaryStage.setTitle("Majima's Security");
		primaryStage.show();
		
		/**EventHandler<WindowEvent> e = new EventHandler<WindowEvent>() {
			public void handle(WindowEvent e) {
				crypter.save();
			}
		};
		primaryStage.setOnCloseRequest(e);
		*/
	}
}
