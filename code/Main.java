import java.util.ArrayList;

import model.GuiManager;
import model.QuizManager;

public class Main{
	private static GuiManager m_guiManager;
	private static QuizManager m_quizManager;

	public static void main(String[] args) {
		//new AnswerQuestion(new TestController("Piero"));
		//new Home(new TestController("pierino"));
		//new AnswerQuestion(new TestController("ofnoefn"));
		m_guiManager = new GuiManager();
		m_quizManager = new QuizManager();
		
		m_quizManager.loadFile("./docs/domande.tsv");
		ArrayList<String> chapterTitles = m_quizManager.getChapterNameList();
		
		System.out.println("Sto eseguedo il main");
	}
}