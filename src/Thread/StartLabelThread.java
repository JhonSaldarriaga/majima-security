package Thread;

import javafx.application.Platform;
import modelAnimation.StartLabelAnimation;
import ui.StartGUI;

public class StartLabelThread extends Thread{

	private StartLabelAnimation startLabelController;
	private StartGUI guiController;
	
	public StartLabelThread(StartLabelAnimation startLabelController, StartGUI guiController) {
		this.startLabelController = startLabelController;
		this.guiController = guiController;
	}
	
	public void run() {
		startLabelController.startWork();
		while(startLabelController.isWorking()) {
			if(startLabelController.getLayaoutX()>=StartLabelAnimation.FINISH_LAYAOUTX) {
				startLabelController.stopWork();
			}else {
				startLabelController.increase();
				Platform.runLater(new Thread() {
					public void run() {
						guiController.updateStartLabelAnimation();
					}
				});
				
				try {
					StartLabelThread.sleep(StartLabelAnimation.MILIS_SPEED);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
