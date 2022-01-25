package controller;

import java.awt.Color;

import model.Option;

public class QuestionData {
	
	private Option m_option;
	Color m_color;
	
	public QuestionData(Option o, Color c) {
		m_option = o;
		m_color = c;
	}
	
	public Option getOption() {
		return m_option;
	}
	
	public Color getColor() {
		return m_color;
	}

}
