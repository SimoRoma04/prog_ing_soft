package model;

import java.util.ArrayList;
import java.util.HashMap;

import parser.CsvParser;

public class QuizManager {
	HashMap<String, Chapter> m_chapterMap = new HashMap<String, Chapter>();
	
	public QuizManager() {
		
	}
	
	public void loadFile(String path) {
		HashMap<String, Chapter> chapterList = CsvParser.parseCsv(path);
		
		for(Chapter c : chapterList.values())
		{
			if(m_chapterMap.containsKey(c.getName()))
			{
				m_chapterMap.get(c.getName()).add(c.getQuestionList());
			}
			else
			{
				m_chapterMap.put(c.getName(), c);
			}
		}
	}
	
	public Chapter getChapter(String name) {
		Chapter chapter = null;
		
		return chapter;
	}
	
	public ArrayList<String> getChapterNameList()
	{
		ArrayList<String> nameList = new ArrayList<String>();
		for(String st : m_chapterMap.keySet())
		{
			nameList.add(st);
		}
		return nameList;
	}
}
