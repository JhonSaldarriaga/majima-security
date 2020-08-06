package ui;

import java.io.IOException;

import Thread.EnterThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Controller;
import model.EnterAnimation;

public class MajimaGUI {

	//WELCOME
    @FXML
    private AnchorPane mainPane;

    @FXML
    private ImageView cursedMajimaAnimation;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private PasswordField passwordFieldAgain;

    @FXML
    private TextField passwordTextFieldAgain;

    @FXML
    private ImageView enterButtonAnimation;

    //RELATIONS
    private EnterAnimation enterAnimationController;
    private Controller accounts;
    
    //CONSTRUCTOR
    public MajimaGUI(Controller accounts) {
    	enterAnimationController = new EnterAnimation();
    	this.accounts = accounts;
	}
    
    //WELCOME METHODS

    @FXML
    void showPasswordButton(ActionEvent event) {

    }
    
    @FXML
    void clickAnimationEnter(MouseEvent event) {
    	
    }
    /////
    
    // ---// LOADS
 	private void load(String route) throws IOException {
 		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(route));
 		fxmlLoader.setController(this);
 		Parent parent = fxmlLoader.load();
 		mainPane.getChildren().setAll(parent);
 	}
 	/////
 	
    public void startEnterThread() {
    	EnterThread enterThread = new EnterThread(this, enterAnimationController);
    	enterThread.start();
    }
    
    public boolean isEnterSelected() {
    	if(enterButtonAnimation.isPressed())
    		return true;
    	else
    		return false;
    }
    
    public void updateEnterImage() {
    	enterButtonAnimation.setImage(enterAnimationController.getImage());
    }
    
    //START
    @FXML
    void startProgram(ActionEvent event) throws IOException {
    	if(accounts.isPasswordEmpty()) {
    		load("Welcome.fxml");
    		startEnterThread();
    	}else
    		load("MajimaGUI.fxml");
    }
}
