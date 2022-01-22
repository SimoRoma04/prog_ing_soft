package model;
import javax.swing.ImageIcon;

public class Image {
	private String name;
	private ImageIcon image;
	
	public Image(String name, ImageIcon image){
		this.name=name;
		this.image = image;
	}

	public String getName() {
		return name;
	}
	
	public ImageIcon getImage() {
		return image;
	}
	
}
