package ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Controller;
import modelAnimation.*;
import Thread.*;

public class MajimaGUI {
	
	//menuVBOX.setStyle("-fx-background-color: #000000");
	
	public static final String URL_FXML = "main.fxml";
	
	//MAIN
	@FXML
    private AnchorPane principalPane;
	
    @FXML
    private VBox menuVBOX;

    @FXML
    private AnchorPane mainPane;
    
    //RELATIONS WITH ANIMATION CONTROLLERS
    private CursedMajimaAnimation cursedAnimationController;
    private StartLabelAnimation startLabelAnimationController;
    private StartImageViewAnimation startMajimaAnimationController;
    private TransitionOpacityAnimation transition;
    private DropdownMenuAnimation menuAnimation;
    private DropdownMenuGUI dropdownMenuGUI;
    
    //RELATION WITH GUI CONTROLLERS
    private StartGUI startGUI;
    private WelcomeGUI welcomeGUI;
    private LoginGUI loginGUI;
    
    //RELATION WITH MODEL
    private Controller accounts;
    
    //CONSTRUCTOR
    public MajimaGUI(Controller accounts) {
    	this.accounts = accounts;
		startLabelAnimationController = new StartLabelAnimation();
		startMajimaAnimationController = new StartImageViewAnimation();
		cursedAnimationController = new CursedMajimaAnimation();
		
		transition = new TransitionOpacityAnimation();
		menuAnimation = new DropdownMenuAnimation();
		startGUI = new StartGUI(accounts, this, startLabelAnimationController, startMajimaAnimationController);
		welcomeGUI = new WelcomeGUI(accounts, this, cursedAnimationController);
		loginGUI = new LoginGUI(accounts, this, cursedAnimationController);
		dropdownMenuGUI = new DropdownMenuGUI();
	}
    
    //INITIALIZE
    void initializeVBOX() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DropdownMenuGUI.URL_FXML));
    	fxmlLoader.setController(dropdownMenuGUI);
    	Parent parent = fxmlLoader.load();
    	menuVBOX.getChildren().setAll(parent);
    }
    
    //-LOADS
    public void load(String route) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(route));
    	if(route.equals(StartGUI.URL_FXML)) {
    		fxmlLoader.setController(startGUI);
    	}else if(route.equals(WelcomeGUI.URL_FXML)){
    		fxmlLoader.setController(welcomeGUI);
    	}else if(route.equals(LoginGUI.URL_FXML)) {
    		fxmlLoader.setController(loginGUI);
    	}
    	
 		Parent parent = fxmlLoader.load();
 		mainPane.getChildren().setAll(parent);
 	}
 	/////
 	
//->
    public TransitionThread createdTransitionAnimation(String route) {
    	TransitionThread transitionThread = new TransitionThread(transition, this, route);
    	return transitionThread;
    }
    
    public void updateOpacity() {
    	mainPane.setOpacity(transition.getCurrentValue());
    }
 //->
    public void initializeStartAnimation() throws IOException {
    	initializeVBOX();
    	load(StartGUI.URL_FXML);
    	RunStartMethods startThread = new RunStartMethods(startGUI, startMajimaAnimationController, startLabelAnimationController);
    	startThread.start();
    }
    /////
    
    public DropdownMenuThread createdMenuAnimation() {
    	DropdownMenuThread menuThread = new DropdownMenuThread(this, menuAnimation);
    	return menuThread;
    }
    
    public void updatePositionMenu() {
    	menuVBOX.setLayoutX(menuAnimation.getCurrentPosition());
    }
    
    @FXML
    void openDropdownMenu(MouseEvent event) {
    	System.out.println("click");
    	System.out.println(menuVBOX.getLayoutX());
    	createdMenuAnimation().start();
    }
}
