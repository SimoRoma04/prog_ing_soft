package model;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Quiz {
	
	private String m_chapter = null;
	private String m_question = null;
	private boolean m_hasImage = false;
	private Image m_image = null;
	private ArrayList<Option> m_options = null;
	
	public Quiz(String chapter, String question, Boolean hasImage, String image, ArrayList<Option> options) {
		m_chapter = chapter;
		m_question = question;
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

	public String getChapter() {
		return m_chapter;
	}

	public String getQuestion() {
		return m_question;
	}

	public ArrayList<Option> getOptions() {
		return m_options;
	}

	public Image getImage() {
		return m_image;
	}


	

}
