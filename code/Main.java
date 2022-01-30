
import model.GuiManager;

import java.util.ArrayList;
import model.QuizManager;


public class Main{
	private static GuiManager m_guiManager;
	private static QuizManager m_quizManager;

	public static void main(String[] args) {
	
		//new AnswerQuestion(new TestController("ofnoefn"));
		
		
		m_quizManager = new QuizManager();
		m_quizManager.loadFile("./docs/domande.tsv");
		
		m_guiManager = new GuiManager(m_quizManager);
		
		ArrayList<String> chapterTitles = m_quizManager.getChapterNameList();

		System.out.println("Sto eseguedo il main");
		
	}
}