
import model.GuiManager;

import java.util.ArrayList;
import model.QuizManager;
import model.StatisticsManager;


public class Main{
	private static GuiManager m_guiManager;
	private static QuizManager m_quizManager;
	private static StatisticsManager m_statisticsManager;

	public static void main(String[] args) {
		m_quizManager = new QuizManager();
		m_quizManager.loadFile("./docs/domande.tsv");
		
		m_statisticsManager = new StatisticsManager();
		
		m_guiManager = new GuiManager(m_quizManager, m_statisticsManager);

		System.out.println("Sto eseguedo il main");
		
	}
}