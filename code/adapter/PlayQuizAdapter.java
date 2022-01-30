package adapter;

import java.util.ArrayList;
import java.util.Collections;

import model.Chapter;
import model.Question;
import model.QuizManager;

public class PlayQuizAdapter implements AdapterInterface {
	private QuizManager m_quizManager;
	private Chapter m_chapter;
	private ArrayList<Integer> m_questionOrder = new ArrayList<Integer>();
	
	public PlayQuizAdapter(QuizManager quizManager) {
		m_quizManager = quizManager;
	}
	
	public void startChapter(String chapterName)
	{
		m_chapter = m_quizManager.getChapter(chapterName);
		if(m_chapter != null) 
		{
			m_questionOrder = getShuffledOrder(m_chapter.getQuestionList().size());
		}
		else
		{
			System.out.println("This chapter doesn't exist");
		}
	}
	
	public void startRandomChapter()
	{
		m_chapter = m_quizManager.getRandomChapter();
		
		if(m_chapter != null) 
		{
			m_questionOrder = getShuffledOrder(m_chapter.getQuestionList().size());
			System.out.println(m_chapter.getName());
		}
		else
		{
			System.out.println("There are no chapters");
		}
	}
	
	public String getChapterName() {
		if(m_chapter != null) 
		{
			return m_chapter.getName();
		}
		else
		{
			System.out.println("Chapter is null");
		}
		return "!!! CHAPTER IS NULL !!!";
	}
	
	public Question getNextQuestion()
	{
		Question question = getQuestion();
		
		if(m_questionOrder.size() > 0) m_questionOrder.remove(0);
		
		return question;
	}
	
	public Question getQuestion()
	{
		if(m_questionOrder.size() > 0) 
		{
			int index = m_questionOrder.get(0);
			return m_chapter.getQuestion(index);
		}
		else
		{
			System.out.println("Out of questions");
		}
		
		return null;
	}
	
	private ArrayList<Integer> getShuffledOrder(int size)
	{
		ArrayList<Integer> shuffledList = new ArrayList<Integer>();
		
		for(int i = 0; i < size; i++)
		{
			shuffledList.add(i);
		}
		
		Collections.shuffle(shuffledList);
		
		return shuffledList;
	}
	
	private void answer(String answerQuestion)
	{
		return;
	}
}
