package model;

public class ChapterStatistics {
	private int m_rightAnswerCount;
	private int m_totalAnswerCount;
	private String m_name;
	
	public ChapterStatistics(String name, int rightAnswerCount, int totalAnswerCount) {
		m_name = name;
		m_rightAnswerCount = rightAnswerCount;
		m_totalAnswerCount = totalAnswerCount;
	}
	
	public String getName()
	{
		return m_name;
	}
	
	public int getRightAnswerCount()
	{
		return m_rightAnswerCount;
	}
	
	public int getTotalAnswerCount()
	{
		return m_totalAnswerCount;
	}
	
	public int getWrongAnswerCount()
	{
		return m_totalAnswerCount - m_rightAnswerCount;
	}
}
