package adapter;

import java.util.ArrayList;
import java.util.Arrays;

import model.Question;

public class QuizAdapter implements AdapterInterface {
	
	public QuizAdapter() {
		
	}
	
	public Question getQuestion() {
		return null;
	}
	
	public ArrayList<String> getChapterList()
	{
		ArrayList<String> chapterList = new ArrayList<String>();
		
		String[] data = {
				"CAP1: ingegneria acrobatica",
				"CAP2: ignoransa",
				"CAP3: come non fare un progetto",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa",
				"CAP2: ignoransa"
		};
		
		chapterList.addAll(Arrays.asList(data));
		
		return chapterList;
	}
}
