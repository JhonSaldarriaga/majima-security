package Thread;

import javafx.application.Platform;
import modelAnimation.TransitionOpacityAnimation;
import ui.MajimaGUI;

public class TransitionAnimationThread extends Thread{

	private TransitionOpacityAnimation transitionController;
	private MajimaGUI guiController;
	private boolean increase;
	
	public TransitionAnimationThread(TransitionOpacityAnimation transitionController, MajimaGUI guiController, boolean increase) {
		this.transitionController = transitionController;
		this.guiController = guiController;
		this.increase = increase;
	}
	
	public void run() {
		if(increase) {
			transitionController.setStartIncrease();
			updateGUI();
			transitionController.startWork();
			
			while(transitionController.isWorking()) {
				if(transitionController.getCurrentValue()<TransitionOpacityAnimation.MAX) {
					transitionController.increase();
					updateGUI();
					try {
						TransitionAnimationThread.sleep(TransitionOpacityAnimation.MILIS_SPEED);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					transitionController.stopWork();
				}
			}
		}else {
			transitionController.setStartDecrease();
			updateGUI();
			transitionController.startWork();
			
			while(transitionController.isWorking()) {
				if(transitionController.getCurrentValue()>TransitionOpacityAnimation.MIN) {
					transitionController.decrease();
					updateGUI();
					try {
						TransitionAnimationThread.sleep(TransitionOpacityAnimation.MILIS_SPEED);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					transitionController.stopWork();
				}
			}
		}
	}
	
	private void updateGUI() {
		Platform.runLater(new Thread() {
			public void run() {
				guiController.updateOpacity();
			}
		});
	}
}
