package Thread;

import javafx.application.Platform;
import modelAnimation.StartImageViewAnimation;
import modelAnimation.StartLabelAnimation;
import ui.MajimaGUI;

public class RunStartMethods extends Thread{

	private MajimaGUI guiController;
	private StartImageViewAnimation startMajimaAnimationController;
	private StartLabelAnimation startLabelAnimationController;
	
	public RunStartMethods(MajimaGUI guiController, StartImageViewAnimation startMajimaAnimationController,
			StartLabelAnimation startLabelAnimationController) {
		this.guiController = guiController;
		this.startMajimaAnimationController = startMajimaAnimationController;
		this.startLabelAnimationController = startLabelAnimationController;
	}
	
	public void run() {
		StartImageViewThread majimaThread = new StartImageViewThread(startMajimaAnimationController, guiController);
    	StartLabelThread startLabelThread = new StartLabelThread(startLabelAnimationController, guiController);
		majimaThread.start();
    	startLabelThread.start();
    	
    	Platform.runLater(new Thread() {
			public void run() {
				guiController.playKiryuChan();
			}
		});
    	
		try {
			majimaThread.join();
			startLabelThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	Platform.runLater(new Thread() {
			public void run() {
				guiController.setEnableStartButton();
			}
		});
	}
}
