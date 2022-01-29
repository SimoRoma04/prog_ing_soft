import adapter.GuiManagerAdapter;
import model.GuiManager;
import view.AnswerQuestion;
import view.Home;
import view.TestController;

public class Main{
	private static GuiManager m_guiManager;

	public static void main(String[] args) {
		//new AnswerQuestion(new TestController("Piero"));
		//new Home(new TestController("pierino"));
		new AnswerQuestion(new TestController("ofnoefn"));
		//m_guiManager = new GuiManager();
		System.out.println("Sto eseguedo il main");
		
	//	new AnswerQuestion(new TestController("giacomino"));
	}
}