import view.Home;
import view.TestController;

public class Main{

	public static void main(String[] args) {
		//new AnswerQuestion(new TestController("Piero"));
		new Home(new TestController("pierino"));
		//new AnswerQuestion(new TestController("ofnoefn"));
		System.out.println("Sto eseguedo il main");
	}
}