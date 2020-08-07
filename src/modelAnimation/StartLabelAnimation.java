package modelAnimation;

public class StartLabelAnimation {

	public static final int START_LAYAOUTX = -500;
	public static final int FINISH_LAYAOUTX = 99;
	public static final int LAYAOUTY = 69;
	public static final int MILIS_SPEED = 5;
	public static final int INCREASE_VALUE = 10;
	
	private int layaoutX;
	private int layaoutY;
	
	private boolean work;
	
	public StartLabelAnimation() {
		layaoutX = START_LAYAOUTX;
		layaoutY = LAYAOUTY;
		work = false;
	}
	
	public void increase() {
		layaoutX += INCREASE_VALUE;
	}

	public int getLayaoutX() {
		return layaoutX;
	}

	public int getLayaoutY() {
		return layaoutY;
	}
	
	public boolean isWorking() {
		return work;
	}
	
	public void startWork() {
		work = true;
	}
	
	public void stopWork() {
		work = false;
	}
}
