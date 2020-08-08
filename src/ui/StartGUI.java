package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import model.Controller;
import modelAnimation.StartImageViewAnimation;
import modelAnimation.StartLabelAnimation;

public class StartGUI {
	
	public static final String URL_FXML = "start.fxml";
	
	//FXML ATTRIBUTES
    @FXML
    private ImageView startLabelAnimation;

    @FXML
    private ImageView startMajimaAnimation;
    
    @FXML
    private Button startButtonAnimation;
    
    //RELATIONS WITH ANIMATIONS
    private StartLabelAnimation startLabelAnimationController;
    private StartImageViewAnimation startMajimaAnimationController;
    
    //RELATION WITH MODEL
    private Controller accounts;
    private MajimaGUI controller;
    
    //CONSTRUCTOR
    public StartGUI(Controller accounts, MajimaGUI controller,
    		StartLabelAnimation startLabelAnimationController, StartImageViewAnimation startMajimaAnimationController) {
		this.accounts = accounts;
		this.controller = controller;
    	this.startLabelAnimationController = startLabelAnimationController;
    	this.startMajimaAnimationController = startMajimaAnimationController;
	}
    
    //-START METHODS FXML
    @FXML
    void startProgram(ActionEvent event) throws IOException {
    	if(accounts.isPasswordEmpty()) {
    		controller.createdTransitionAnimation(WelcomeGUI.URL_FXML).start();
    	}else
    		controller.createdTransitionAnimation(LoginGUI.URL_FXML).start();
    }
    
 	//ANIMATION METHODS
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
    
    public void playKiryuChan() {
    	AudioClip sound = new AudioClip(this.getClass().getResource("kiryu_chan.wav").toString());
    	sound.setVolume(0.25);
    	sound.play();
    }
    
    public void setEnableStartButton() {
    	startButtonAnimation.setDisable(false);
    }
}
