package Thread;

import javafx.application.Platform;
import modelAnimation.StartImageViewAnimation;
import ui.StartGUI;

public class StartImageViewThread extends Thread{
	
	private StartImageViewAnimation startImageViewController;
	private StartGUI guiController;
	
	public StartImageViewThread(StartImageViewAnimation startImageViewController, StartGUI guiController) {
		this.startImageViewController = startImageViewController;
		this.guiController = guiController;
	}
	
	public void run() {
		startImageViewController.startWork();
		while(startImageViewController.isWorking()) {
			update();
			try {
				StartImageViewThread.sleep(StartImageViewAnimation.MILIS_SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		if(startImageViewController.getWidthImageView() <= startImageViewController.MAX_IMAGEVIEW_WIDTH 
				&& startImageViewController.getHeightImageView() <= startImageViewController.MAX_IMAGEVIEW_HEIGHT 
				&& startImageViewController.getLayaoutX() >= startImageViewController.MIN_LAYAOUTX 
				&& startImageViewController.getLayaoutY() >= startImageViewController.MIN_LAYAOUTY) {
			
			if(startImageViewController.getWidthImageView() >= startImageViewController.MAX_IMAGEVIEW_WIDTH 
				&& startImageViewController.getHeightImageView() >= startImageViewController.MAX_IMAGEVIEW_HEIGHT 
				&& startImageViewController.getLayaoutX() <= startImageViewController.MIN_LAYAOUTX 
				&& startImageViewController.getLayaoutY() <= startImageViewController.MIN_LAYAOUTY) {
			
				startImageViewController.stopWork();
				
			}else {
				startImageViewController.update();
				updatePositionGUI();
			}
		}
	}
	
	private void updatePositionGUI() {
		Platform.runLater(new Thread() {
			public void run() {
				guiController.updateStartImageViewAnimation();
			}
		});
	}
}
