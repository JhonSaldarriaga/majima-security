package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import model.Controller;
import modelAnimation.*;
import Thread.*;

public class MajimaGUI {

	//START
	
    @FXML
    private ImageView startLabelAnimation;

    @FXML
    private ImageView startMajimaAnimation;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button startButtonAnimation;
    
	//WELCOME

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

    //LOGIN
    @FXML
    private TextField textFieldLogin;

    @FXML
    private ImageView cursedLoginAnimation;

    @FXML
    private PasswordField passwordFieldLogin;
    
    @FXML
    private ImageView enterButtonLoginAnimation;
    
    //RELATIONS
    private EnterAnimation enterAnimationController;
    private CursedMajimaAnimation cursedAnimationController;
    private StartLabelAnimation startLabelAnimationController;
    private StartImageViewAnimation startMajimaAnimationController;
    private TransitionOpacityAnimation transition;
    
    private Controller accounts;
    
    //CONSTRUCTOR
    public MajimaGUI(EnterAnimation enterAnimationController, CursedMajimaAnimation cursedAnimationController,
			StartLabelAnimation startLabelAnimationController, StartImageViewAnimation startMajimaAnimationController,
			TransitionOpacityAnimation transition, Controller accounts) {
		this.enterAnimationController = enterAnimationController;
		this.cursedAnimationController = cursedAnimationController;
		this.startLabelAnimationController = startLabelAnimationController;
		this.startMajimaAnimationController = startMajimaAnimationController;
		this.transition = transition;
		this.accounts = accounts;
	}
    ////
    
    //-LOADS
    public void load(String route) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(route));
 		fxmlLoader.setController(this);
 		Parent parent = fxmlLoader.load();
 		mainPane.getChildren().setAll(parent);
 		
 		if(route.equals("Welcome.fxml"))
 			startEnterThread();
 	}
 	/////
 	
 	///-ANIMATION METHODS
 //->
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
//->    
    public void startCursedAnimation() {
    	CursedMajimaThread cursedThread = new CursedMajimaThread(cursedAnimationController, this);
    	cursedThread.start();
    }

    public void updateCursedMajimaAnimation() {
    	cursedMajimaAnimation.setFitHeight(cursedAnimationController.getHeightImageView());
    	cursedMajimaAnimation.setFitWidth(cursedAnimationController.getWidthImageView());
    	
    	cursedMajimaAnimation.setLayoutX(cursedAnimationController.getLayaoutX());
    	cursedMajimaAnimation.setLayoutY(cursedAnimationController.getLayaoutY());
    }
    
    public void updateImageCursedMajimaAnimation() {
    	cursedMajimaAnimation.setImage(cursedAnimationController.getImage());
    }
//->
    public void updateStartLabelAnimation() {
    	startLabelAnimation.setLayoutX(startLabelAnimationController.getLayaoutX());
    }
//->
    public void updateStartImageViewAnimation() {
    	startMajimaAnimation.setFitHeight(startMajimaAnimationController.getHeightImageView());
    	startMajimaAnimation.setFitWidth(startMajimaAnimationController.getWidthImageView());
    	
    	startMajimaAnimation.setLayoutX(startMajimaAnimationController.getLayaoutX());
    	startMajimaAnimation.setLayoutY(startMajimaAnimationController.getLayaoutY());
    }
//->
    public void startTransitionAnimation(String route) {
    	TransitionThread transitionThread = new TransitionThread(transition, this, route);
    	transitionThread.start();
    }
    
    public void updateOpacity() {
    	mainPane.setOpacity(transition.getCurrentValue());
    }
 //->
    
    /////
    
    //-START APPLICATION METHODS
    public void playKiryuChan() {
    	AudioClip sound = new AudioClip(this.getClass().getResource("kiryu_chan.wav").toString());
    	sound.setVolume(0.25);
    	sound.play();
    }
    
    public void setEnableStartButton() {
    	startButtonAnimation.setDisable(false);
    }
    /////
    
    //-START METHODS FXML
    @FXML
    void startProgram(ActionEvent event) throws IOException {
    	if(accounts.isPasswordEmpty()) {
    		startTransitionAnimation("Welcome.fxml");
    	}else
    		startTransitionAnimation("login.fxml");
    }
    /////
    
    //-WELCOME METHODS FXML
    @FXML
    void showPasswordButton(ActionEvent event) {

    }
    
	@FXML
    void clickAnimationEnter(MouseEvent event) {
		startCursedAnimation();
    }
    /////
	
	//-LOGIN METHODS FXML
    @FXML
    void showPasswordLogin(ActionEvent event) {

    }

    @FXML
    void enterLoginAnimation(ActionEvent event) {

    }
}
