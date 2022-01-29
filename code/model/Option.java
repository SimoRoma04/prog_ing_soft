package model;
public class Option {
	private String m_text;
	private boolean m_isRight;
	
	public Option(String text, Boolean isRight) {
		m_text = text;
		m_isRight = isRight;
	}
	
	public String getText() {
		return m_text;
	}

	public boolean getIsRight() {
		return m_isRight;
	}

	
	
}
