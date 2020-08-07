package modelAnimation;

public class StartImageViewAnimation {
	
	public static final int MILIS_SPEED = 10;
	
	public final int MAX_IMAGEVIEW_WIDTH = 215;
	public final int MIN_IMAGEVIEW_WIDTH = 10;
	public final int MAX_IMAGEVIEW_HEIGHT = 215;
	public final int MIN_IMAGEVIEW_HEIGHT = 10;
	public final int CHANGE_SIZE_VALUE_IMAGEVIEW = 5;
	
	public final int MAX_LAYAOUTX = 348;
	public final int MIN_LAYAOUTX = 225;
	public final int MAX_LAYAOUTY = 373;
	public final int MIN_LAYAOUTY = 250;
	public final int CHANGE_SIZE_VALUE_LAYAOUTX = 3;
	public final int CHANGE_SIZE_VALUE_LAYAOUTY = 3;
	
	private int widthImageView;
	private int heightImageView;
	private int layaoutX;
	private int layaoutY;
	
	private boolean work;

	public StartImageViewAnimation() {
		
		widthImageView = MIN_IMAGEVIEW_WIDTH;
		heightImageView = MIN_IMAGEVIEW_HEIGHT;
		layaoutX = MAX_LAYAOUTX;
		layaoutY = MAX_LAYAOUTY;
		
		work = false;
	}

	public void update() {
		widthImageView += CHANGE_SIZE_VALUE_IMAGEVIEW;
		heightImageView += CHANGE_SIZE_VALUE_IMAGEVIEW;
		layaoutX -= CHANGE_SIZE_VALUE_LAYAOUTX;
		layaoutY -= CHANGE_SIZE_VALUE_LAYAOUTY;
	}
	
	/**
	public void reset() {
		widthImageView = MIN_IMAGEVIEW_WIDTH;
		heightImageView = MIN_IMAGEVIEW_HEIGHT;
		layaoutX = MAX_LAYAOUTX;
		layaoutY = MAX_LAYAOUTY;
		image = IMAGES[];
	}
	*/

	public int getWidthImageView() {
		return widthImageView;
	}

	public int getHeightImageView() {
		return heightImageView;
	}

	public int getLayaoutX() {
		return layaoutX;
	}

	public int getLayaoutY() {
		return layaoutY;
	}

	public void setWidthImageView(int widthImageView) {
		this.widthImageView = widthImageView;
	}

	public void setHeightImageView(int heightImageView) {
		this.heightImageView = heightImageView;
	}

	public void setLayaoutX(int layaoutX) {
		this.layaoutX = layaoutX;
	}

	public void setLayaoutY(int layaoutY) {
		this.layaoutY = layaoutY;
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
