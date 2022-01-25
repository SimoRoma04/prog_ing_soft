package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Course;
import model.Option;
import model.Quiz;

public class ControllerTests {

	@Test
	public void TestController() {
		
		
		Course course = new Course("Corso di Test");
		
		Option o = new Option();
		o.setText("Risposta 1");
		o.setIsRight(true);
		
		ArrayList<Option> options = new ArrayList<Option>();
		options.add(o);
		
		Quiz q = new Quiz();
		q.setName("Domanda di prova");
		q.setQuestion("Qual è la domanda?");
		q.setOptions(options);
		course.addQuiz(q);
		
		/* AGGIUNGENDO QUESTO, ESEGUE MA RIMANE COMUNQUE SBAGLIATO (ALTRIMENTI NON ESEGUE NEMMENO)
		Quiz r = new Quiz();
		r.setName("Domanda di prova");
		r.setQuestion("Qual è la domanda?");
		r.setOptions(options);
		course.addQuiz(r);
		*/
		
		Controller controller = new Controller("Test", course);
		
		controller.isRight(0);
		
		// Falliscono perché non carica la domanda successiva (out of bounds)
		assertEquals(controller.getQuestionText(), "Qual è la domanda?");
		assertEquals(controller.getQuestionData().get(0).m_color, "green");
		
	}

}
