package controller;

import model.Option;

public class QuestionData {
	
	private Option option;
	private String color;
	
	public QuestionData(Option o, String c) {
		option = o;
		color = c;
	}
	
	public Option getOption() {
		return option;
	}
	
	public String getColor() {
		return color;
	}

}
