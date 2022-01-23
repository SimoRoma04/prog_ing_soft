package controller;

import java.util.ArrayList;

import model.Course;
import model.Option;

public class Controller extends ControllerAbs {
	
	private Course m_course;
	private int m_currentQuestion;
	
	private ArrayList<QuestionData> m_questionData;
	
	public Controller(String name, Course course) {
		super(name);
		m_currentQuestion = 0;
		
		m_course = course;
		
		loadQuestions();
	}
	
	private void loadQuestions() {
		ArrayList<QuestionData> temp = new ArrayList<QuestionData>();
		
		// Problema: non funziona se la lista è vuota
		for(Option o: m_course.getQuizList().get(m_currentQuestion).getOptions()) {
			temp.add(new QuestionData(o, "grey"));
		}
		
		m_questionData = temp;
	}
	
	
}
