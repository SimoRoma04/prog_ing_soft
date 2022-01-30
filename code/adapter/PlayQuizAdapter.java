package adapter;

import java.util.ArrayList;
import java.util.Collections;

import model.Chapter;
import model.GuiManager;
import model.Option;
import model.PageTypes;
import model.Question;
import model.QuizManager;

public class PlayQuizAdapter implements AdapterInterface {
	private QuizManager m_quizManager;
	private GuiManager m_guiManager;
	private Chapter m_chapter;
	private ArrayList<Integer> m_questionOrder;
	private int m_rightAnswerCount;
	private Boolean m_hasAnswered;
	
	public PlayQuizAdapter(QuizManager quizManager, GuiManager guiManager) {
		m_quizManager = quizManager;
		m_guiManager = guiManager;
	}
	
	public void startChapter(String chapterName)
	{
		reset();
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
		reset();
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
	
	private void reset()
	{
		m_chapter = null;
		m_questionOrder = new ArrayList<Integer>();
		m_hasAnswered = false;
		m_rightAnswerCount = 0;
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
	
	public Question getQuestion()
	{
		//System.out.println("QuestionOrder: " + m_questionOrder.size() + " Questions: " + m_chapter.getQuestionList().size());
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
	
	public void answer(Option option)
	{
		if(!m_hasAnswered)
		{
			String rightOrWrong;
			if(option.getIsRight()) 
			{
				m_rightAnswerCount++;
				rightOrWrong = "RIGHT";
			}
			else
			{
				rightOrWrong = "WRONG";
			}
			//System.out.println("\"" + option.getText() + "\" WAS THE " + rightOrWrong + " OPTION");
			m_hasAnswered = true;
		}
		else
		{
			m_hasAnswered = false;
			moveToNextQuestion();
		}
		
		m_guiManager.refresh();
		
		return;
	}
	
	public void moveToNextQuestion()
	{
		if(m_questionOrder.size() > 1)
		{
			m_questionOrder.remove(0);
		}
		else
		{
			endChapter();
		}
		
		return;
	}
	
	private void endChapter()
	{
		m_guiManager.loadPage(PageTypes.P_QUIZ_END);
		return;
	}
	
	public boolean isOptionSelected()
	{
		return m_hasAnswered;
	}
	
	public int getRightAnswerCount()
	{
		return m_rightAnswerCount;
	}
	
	public int getTotalAnswerCount()
	{
		return m_chapter.getQuestionList().size();
	}
}
