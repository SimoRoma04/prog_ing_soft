package adapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import model.ChapterStatistics;
import model.StatisticsManager;

public class StatisticsAdapter implements AdapterInterface {
	StatisticsManager m_statisticsManager;
	
	public StatisticsAdapter(StatisticsManager statisticsManager) {
		m_statisticsManager = statisticsManager;
	}
	
	public ArrayList<String> getChapterList()
	{
		return new ArrayList<String>(m_statisticsManager.getStats().keySet());	
	}
	
	public ArrayList<Integer> getRightAnswerList()
	{
		ArrayList<Integer> rightAnswers = new ArrayList<Integer>();
		
		LinkedHashMap<String, ChapterStatistics> map = m_statisticsManager.getStats();

		ArrayList<String> keys = new ArrayList<String>(map.keySet());
		
		for(int i = 0; i < keys.size(); i++)
		{
			rightAnswers.add(map.get(keys.get(i)).getRightAnswerCount());
		}
		return rightAnswers;
	}
	
	public ArrayList<Integer> getWrongAnswerList()
	{
		ArrayList<Integer> rightAnswers = new ArrayList<Integer>();
		
		LinkedHashMap<String, ChapterStatistics> map = m_statisticsManager.getStats();

		ArrayList<String> keys = new ArrayList<String>(map.keySet());
		
		for(int i = 0; i < keys.size(); i++)
		{
			rightAnswers.add(map.get(keys.get(i)).getWrongAnswerCount());
		}
		return rightAnswers;
	}
	
	public ArrayList<Integer> getTotalAnswerList()
	{
		ArrayList<Integer> rightAnswers = new ArrayList<Integer>();
		
		LinkedHashMap<String, ChapterStatistics> map = m_statisticsManager.getStats();

		ArrayList<String> keys = new ArrayList<String>(map.keySet());
		
		for(int i = 0; i < keys.size(); i++)
		{
			rightAnswers.add(map.get(keys.get(i)).getTotalAnswerCount());
		}
		return rightAnswers;
	}
}
