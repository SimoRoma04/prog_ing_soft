package parser;

import java.util.ArrayList;

public class SavedDataFormat {
	private String m_chapterName;
	private ArrayList<Integer> m_scores;
	
	public SavedDataFormat(String chapterName, ArrayList<Integer> scores) {
		m_chapterName = chapterName;
		m_scores = scores;
	}
	
	public int getMaxScore() {
		int max = 0;
		for(int i: m_scores) if(i > max) max = i;
		return max;
	}
	
	public String getChapterName() {
		return m_chapterName;
	}
	
}
