package ui;

import Thread.CursedMajimaThread;
import Thread.WaitingThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Controller;
import modelAnimation.CursedMajimaAnimation;

public class LoginGUI {

	private final Image[] IMAGES = {new Image("images/enter_yakuza.png"), new Image("images/enter_yakuza2.png"),
			new Image("images/show.png"), new Image("images/hide.png")};
	
	public static final String URL_FXML = "login.fxml";
	
	//FXML ATTRIBUTES
    @FXML
    private TextField passwordShowField;

    @FXML
    private ImageView imageViewShowPassword;

    @FXML
    private ImageView cursedMajimaAnimation;

    @FXML
    private PasswordField passwordHideField;

    @FXML
    private ImageView enterButtonAnimation;

    //RELATIONS WITH ANIMATIONS
    private CursedMajimaAnimation cursedAnimationController;
    
    //RELATION WITH MODEL
    private Controller accounts;
    private MajimaGUI controller;
    
    //CONSTRUCTOR
    public LoginGUI(Controller accounts, MajimaGUI controller, CursedMajimaAnimation cursedAnimationController) {
		this.accounts = accounts;
		this.controller = controller;
    	this.cursedAnimationController = cursedAnimationController;
	} 
    
    //ANIMATION METHODS
    public CursedMajimaThread createCursedAnimation() {
    	CursedMajimaThread cursedThread = new CursedMajimaThread(cursedAnimationController, this);
    	return cursedThread;
    }
    
    public void updateImageCursedMajimaAnimation() {
    	cursedMajimaAnimation.setImage(cursedAnimationController.getImage());
    }
    
    public void updateCursedMajimaAnimation() {
    	cursedMajimaAnimation.setFitHeight(cursedAnimationController.getHeightImageView());
    	cursedMajimaAnimation.setFitWidth(cursedAnimationController.getWidthImageView());
    	cursedMajimaAnimation.setLayoutX(cursedAnimationController.getLayaoutX());
    	cursedMajimaAnimation.setLayoutY(cursedAnimationController.getLayaoutY());
    }
    
    //FXML METHODS
    @FXML
    void showPasswordButton(ActionEvent event) {
    	if(passwordHideField.isDisable()) {
    		imageViewShowPassword.setImage(IMAGES[2]);
    		passwordHideField.setText(passwordShowField.getText());
    		passwordHideField.setDisable(false);
    		passwordShowField.setDisable(true);
    		passwordShowField.setVisible(false);
    		passwordHideField.setVisible(true);
    	}else {
    		imageViewShowPassword.setImage(IMAGES[3]);
    		passwordShowField.setText(passwordHideField.getText());
    		passwordShowField.setDisable(false);
    		passwordHideField.setDisable(true);
    		passwordShowField.setVisible(true);
    		passwordHideField.setVisible(false);
    	}
    }

    @FXML
    void pressedAnimationEnter(MouseEvent event) {
		enterButtonAnimation.setImage(IMAGES[1]);
		WaitingThread thread = new WaitingThread(createCursedAnimation(), controller.createdTransitionAnimation(""));
		thread.start();
    }

    @FXML
    void releasedAnimationEnter(MouseEvent event) {
    	enterButtonAnimation.setImage(IMAGES[0]);
    }
}
