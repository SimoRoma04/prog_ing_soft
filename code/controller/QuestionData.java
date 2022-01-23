package controller;

import model.Option;

public class QuestionData {
	
	private Option m_option;
	String m_color;
	
	public QuestionData(Option o, String c) {
		m_option = o;
		m_color = c;
	}
	
	public Option getOption() {
		return m_option;
	}

}
