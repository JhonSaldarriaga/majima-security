package modelAnimation;

public class DropdownMenuAnimation {

	public static final int HIDE_LAYAOUTX = -300;
	public static final int SHOW_LAYAOUTX = 0;
	public static final int MILIS_SPEED = 10;
	
	private final int INCREASE_VALUE = 5;
	
	private int currentPosition;
	private boolean work;
	
	public DropdownMenuAnimation() {
		currentPosition = HIDE_LAYAOUTX;
		work = false;
	}
	
	public void increase() {
		currentPosition += INCREASE_VALUE;
	}
	
	public void decrease() {
		currentPosition -= INCREASE_VALUE;
	}
	
	public int getCurrentPosition() {
		return currentPosition;
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
