package model;

import java.util.LinkedHashMap;

public class StatisticsManager {
	LinkedHashMap<String, ChapterStatistics> m_statsMap = new LinkedHashMap<String, ChapterStatistics>();

	public StatisticsManager() {
		
	}
	
	public void addResult(String chapterName, int rightAnswerCount, int totalAnswerCount)
	{
		if(m_statsMap.containsKey(chapterName))
		{
			m_statsMap.remove(chapterName);
		}
		m_statsMap.put(chapterName, new ChapterStatistics(chapterName, rightAnswerCount, totalAnswerCount));
	}
	
	public LinkedHashMap<String, ChapterStatistics> getStats()
	{
		return m_statsMap;
	}
}
