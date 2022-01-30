package adapter;

import java.util.ArrayList;
import java.util.Arrays;

import model.Question;
import model.QuizManager;

public class QuizAdapter implements AdapterInterface {
	
	private QuizManager m_quizManager;
	private String m_currentChapter;
	private int m_currentQuestion;
	
	public QuizAdapter(QuizManager q) {
		m_quizManager = q;
		m_currentChapter = m_quizManager.getChapterNameList().get(0);
		m_currentQuestion = 0;
	}
	
	public Question getQuestion() {
		return m_quizManager.getChapter(m_currentChapter).getQuestionList().get(m_currentQuestion);
	}
	
	public ArrayList<String> getChapterList() {
		return m_quizManager.getChapterNameList();
	};
		
}
