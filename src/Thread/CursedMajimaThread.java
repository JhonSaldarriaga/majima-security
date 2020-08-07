package Thread;

import javafx.application.Platform;
import modelAnimation.CursedMajimaAnimation;
import ui.MajimaGUI;

public class CursedMajimaThread extends Thread{

	private CursedMajimaAnimation cursedController;
	private MajimaGUI guiController;
	
	public CursedMajimaThread(CursedMajimaAnimation cursedController, MajimaGUI guiController) {
		this.cursedController = cursedController;
		this.guiController = guiController;
	}
	
	public void run() {
		cursedController.startWork();
		while(cursedController.isWorking()) {
			update();
			
			try {
				CursedMajimaThread.sleep(CursedMajimaAnimation.MILIS_SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		if(cursedController.getWidthImageView() <= cursedController.MAX_IMAGEVIEW_WIDTH 
				&& cursedController.getHeightImageView() <= cursedController.MAX_IMAGEVIEW_HEIGHT 
				&& cursedController.getLayaoutX() >= cursedController.MIN_LAYAOUTX 
				&& cursedController.getLayaoutY() >= cursedController.MIN_LAYAOUTY) {
			
			if(cursedController.getWidthImageView() == cursedController.MAX_IMAGEVIEW_WIDTH 
				&& cursedController.getHeightImageView() == cursedController.MAX_IMAGEVIEW_HEIGHT 
				&& cursedController.getLayaoutX() == cursedController.MIN_LAYAOUTX 
				&& cursedController.getLayaoutY() == cursedController.MIN_LAYAOUTY) {
			
				cursedController.setLayaoutX(20);
				cursedController.setLayaoutY(20);
				updatePositionGUI();
				transition();
				cursedController.stopWork();
				
			}else {
				cursedController.update();
				updatePositionGUI();
			}
		}
	}
	
	private void updatePositionGUI() {
		Platform.runLater(new Thread() {
			public void run() {
				guiController.updateCursedMajimaAnimation();
			}
		});
	}
	
	public void transition() {
		
		int n = 1;
		
		while(n<CursedMajimaAnimation.IMAGES.length) {
			cursedController.setImage(CursedMajimaAnimation.IMAGES[n]);
			Platform.runLater(new Thread() {
				public void run() {
					guiController.updateImageCursedMajimaAnimation();
				}
			});
			
			try {
				CursedMajimaThread.sleep(CursedMajimaAnimation.MILIS_SPEED+25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			n++;
		}
	}
}
