package model;

import java.util.ArrayList;

public class Chapter {
	private ArrayList<Question> m_questionList = new ArrayList<Question>();
	private String m_name = null;
	
	public Chapter(String name) {
		m_name = name;
	}
	
	public Chapter(String name, ArrayList<Question> questionList) {
		this(name);
		m_questionList = questionList;
	}
	
	public void add(Question question) {
		m_questionList.add(question);
		return;
	}
	
	public void add(ArrayList<Question> questionList) {
		m_questionList.addAll(questionList);
		return;
	}
	
	public ArrayList<Question> getQuestionList() {
		return m_questionList;
	}
	
	public String getName()
	{
		return m_name;
	}
}
