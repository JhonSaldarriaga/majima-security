package modelAnimation;

import javafx.scene.image.Image;

public class EnterAnimation {

	public static final Image[] IMAGES = {new Image("images/enter_yakuza.png"), new Image("images/enter_yakuza2.png")};
	
	private Image image;
	private int imageSelected;
	private boolean work;
	
	public EnterAnimation () {
		image = IMAGES[0];
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
