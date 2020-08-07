package Thread;

import java.io.IOException;

import javafx.application.Platform;
import modelAnimation.TransitionOpacityAnimation;
import ui.MajimaGUI;

public class TransitionThread extends Thread{

	private TransitionOpacityAnimation transitionController;
	private MajimaGUI guiController;
	private String fxmlLoad;
	
	public TransitionThread(TransitionOpacityAnimation transitionController, MajimaGUI guiController, String fxmlLoad) {
		this.transitionController = transitionController;
		this.guiController = guiController;
		this.fxmlLoad = fxmlLoad;
	}
	
	public void run() {
		TransitionAnimationThread transitionThread = new TransitionAnimationThread(transitionController, guiController, false);
		transitionThread.start();
		try {
			transitionThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Platform.runLater(new Thread() {
			public void run() {
				try {
					guiController.load(fxmlLoad);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		TransitionAnimationThread transitionThread2 = new TransitionAnimationThread(transitionController, guiController, true);
		transitionThread2.start();
	}
}
