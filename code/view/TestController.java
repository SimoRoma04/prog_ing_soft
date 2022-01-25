package view;
import java.util.ArrayList;

public class TestController extends ControllerAbs {

	public TestController(String name) {
		super(name);
		
	}
	
	public int get3() {
		return 3;
	}
	
	public ArrayList<String> getAnswer(){
		
		 ArrayList<String> domande = new ArrayList<String>();
		 domande.add("testo domanda1");
		 domande.add("testo domanda2");
		 domande.add("123456789012345678901234567890123456789012345678901234567890123456789");
		 domande.add("testo domanda4");
		return domande;
		
	}

}
