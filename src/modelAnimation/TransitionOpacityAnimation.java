package modelAnimation;

public class TransitionOpacityAnimation {

	public static final double MAX = 1.0;
	public static final double MIN = 0.0;
	public static final double INCREASE_VALUE = 0.01;
	public static final int MILIS_SPEED = 5;
	
	private double currentValue;
	private boolean work;
	
	public TransitionOpacityAnimation() {
		currentValue = MIN;
		work = false;
	}
	
	public void increase() {
		currentValue += INCREASE_VALUE;
	}
	
	public void decrease() {
		currentValue -= INCREASE_VALUE;
	}
	
	public void setStartIncrease() {
		currentValue = MIN;
	}
	
	public void setStartDecrease() {
		currentValue = MAX;
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
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
