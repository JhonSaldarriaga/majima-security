package Thread;

import javafx.application.Platform;

import modelAnimation.EnterAnimation;
import ui.MajimaGUI;

public class EnterThread extends Thread{

	private MajimaGUI controller;
	private EnterAnimation enterAnimationController;
	
	public EnterThread (MajimaGUI controller, EnterAnimation enterAnimationController) {
		this.controller = controller;
		this.enterAnimationController = enterAnimationController;
	}
	
	@Override
	public void run() {
		enterAnimationController.setWork(true);
		while(enterAnimationController.isWork()) {
			
			System.out.print("");//I don't know why i need this sentence of code to all work good ;-;
			
			if(controller.isEnterSelected()) {
				if(enterAnimationController.getImageSelected()==0) {
					
					enterAnimationController.changeImage(EnterAnimation.IMAGES[1], 1);
		
					Platform.runLater(new Thread() {
						public void run() {
							controller.updateEnterImage();
						}
					});
				}
			}else {
				if(enterAnimationController.getImageSelected()==1) {
					enterAnimationController.changeImage(EnterAnimation.IMAGES[0], 0);
					
					Platform.runLater(new Thread() {
						public void run() {
							controller.updateEnterImage();
						}
					});
				}
			}
		}
	}
}
