package model;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Question {
	private String m_text = null;
	private boolean m_hasImage = false;
	private Image m_image = null;
	private ArrayList<Option> m_options = null;
	
	public Question(String question, Boolean hasImage, String image, ArrayList<Option> options) {
		m_text = question;
		m_hasImage = hasImage;
		
		if(hasImage)
			m_image = new Image(image, new ImageIcon(image));
		else
			m_image = new Image();
		
		m_options = options;
	}
	

	public boolean getHasImage() {
		return m_hasImage;
	}

	public String getText() {
		return m_text;
	}

	public ArrayList<Option> getOptions() {
		return m_options;
	}

	public Image getImage() {
		return m_image;
	}
	
	public void setImage(Image image) {
		m_image = image;
		return;
	}

}
