package Thread;

import javafx.application.Platform;
import modelAnimation.DropdownMenuAnimation;
import ui.MajimaGUI;

public class DropdownMenuThread extends Thread{

	private MajimaGUI guiController;
	private DropdownMenuAnimation animationController;
	
	public DropdownMenuThread(MajimaGUI guiController, DropdownMenuAnimation animationController) {
		this.guiController = guiController;
		this.animationController = animationController;
	}
	
	public void run() {
		if(animationController.getCurrentPosition()==DropdownMenuAnimation.SHOW_LAYAOUTX) {
			animationController.startWork();
			while(animationController.isWorking()) {
				decrease();
			}
		}else if(animationController.getCurrentPosition()==DropdownMenuAnimation.HIDE_LAYAOUTX) {
			animationController.startWork();
			while(animationController.isWorking()) {
				increase();
			}
		}
	}
	
	private void increase() {
		if(animationController.getCurrentPosition()<DropdownMenuAnimation.SHOW_LAYAOUTX) {
			animationController.increase();
			
			Platform.runLater(new Thread() {
				public void run() {
					guiController.updatePositionMenu();
				}
			});
			
			try {
				DropdownMenuThread.sleep(DropdownMenuAnimation.MILIS_SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else
			animationController.stopWork();
	}
	
	private void decrease() {
		if(animationController.getCurrentPosition()>DropdownMenuAnimation.HIDE_LAYAOUTX) {
			animationController.decrease();
			
			Platform.runLater(new Thread() {
				public void run() {
					guiController.updatePositionMenu();
				}
			});
			
			try {
				DropdownMenuThread.sleep(DropdownMenuAnimation.MILIS_SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else
			animationController.stopWork();
	}
}
