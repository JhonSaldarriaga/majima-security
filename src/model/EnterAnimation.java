package model;

import javafx.scene.image.Image;

public class EnterAnimation {

	public static final Image[] images = {new Image("images/enter_yakuza.png"), new Image("images/enter_yakuza2.png")};
	
	private Image image;
	private int imageSelected;
	private boolean work;
	
	public EnterAnimation () {
		image = images[0];
		imageSelected = 0;
		work = false;
	}
	
	public void changeImage(Image i, int iS) {
		image = i;
		imageSelected = iS;
	}
	
	public Image getImage() {
		return image;
	}
	
	public int getImageSelected() {
		return imageSelected;
	}

	public boolean isWork() {
		return work;
	}

	public void setWork(boolean work) {
		this.work = work;
	}
}
