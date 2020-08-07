package modelAnimation;

import javafx.scene.image.Image;

public class CursedMajimaAnimation {

	public static final Image[] IMAGES = {new Image("images/copjima_hand.png"), 
			new Image("images/transicion_1.png"),new Image("images/transicion_2.png"),
			new Image("images/cursed_majima.png")};
	
	public static final int MILIS_SPEED = 50;
	
	public final int MAX_IMAGEVIEW_WIDTH = 270;
	public final int MIN_IMAGEVIEW_WIDTH = 110;
	public final int MAX_IMAGEVIEW_HEIGHT = 260;
	public final int MIN_IMAGEVIEW_HEIGHT = 100;
	public final int CHANGE_SIZE_VALUE_IMAGEVIEW = 10;
	
	public final int MAX_LAYAOUTX = 95;
	public final int MIN_LAYAOUTX = 15;
	public final int MAX_LAYAOUTY = 112;
	public final int MIN_LAYAOUTY = 48;
	public final int CHANGE_SIZE_VALUE_LAYAOUTX = 5;
	public final int CHANGE_SIZE_VALUE_LAYAOUTY = 4;
	
	private Image image;
	private int widthImageView;
	private int heightImageView;
	private int layaoutX;
	private int layaoutY;
	
	private boolean work;

	public CursedMajimaAnimation() {
		image = IMAGES[0];
		
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
	
	public Image getImage() {
		return image;
	}

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
	
	public void setImage(Image image) {
		this.image = image;
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
