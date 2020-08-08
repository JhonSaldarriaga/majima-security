package Thread;

import javafx.application.Platform;
import modelAnimation.CursedMajimaAnimation;
import ui.LoginGUI;
import ui.WelcomeGUI;

public class CursedMajimaThread extends Thread{

	private CursedMajimaAnimation cursedController;
	private WelcomeGUI welcomeController;
	private LoginGUI loginController;
	
	public CursedMajimaThread(CursedMajimaAnimation cursedController, WelcomeGUI welcomeController) {
		this.cursedController = cursedController;
		this.welcomeController = welcomeController;
		loginController = null;
	}
	
	public CursedMajimaThread(CursedMajimaAnimation cursedController,  LoginGUI loginController) {
		this.cursedController = cursedController;
		this.loginController = loginController;
		welcomeController = null;
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
				if(welcomeController==null)
					loginController.updateCursedMajimaAnimation();
					
				else if(loginController==null)
					welcomeController.updateCursedMajimaAnimation();
			}
		});
	}
	
	public void transition() {
		
		int n = 1;
		
		while(n<CursedMajimaAnimation.IMAGES.length) {
			cursedController.setImage(CursedMajimaAnimation.IMAGES[n]);
			Platform.runLater(new Thread() {
				public void run() {
					if(welcomeController!=null)
						welcomeController.updateImageCursedMajimaAnimation();
					else if(loginController!=null)
						loginController.updateImageCursedMajimaAnimation();
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
