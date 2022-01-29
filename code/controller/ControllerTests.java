package controller;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import model.Course;
import model.Option;
import model.Question;

public class ControllerTests {

	@Test
	public void TestController() {
		
		
		Course course = new Course("Corso di Test");
		
		Option o = new Option("Risposta 1", true);
		
		
		ArrayList<Option> options = new ArrayList<Option>();
		options.add(o);
		
		Question q = new Question("Capitolo 1", "Quante sono le risposte?", false, "", options);
		course.addQuiz(q);
		
		
		Question r = new Question("Capitolo 1", "Qual è la domanda?", false, "", options);
		course.addQuiz(r);
		
		
		Controller controller = new Controller("Test", course);
		
		controller.isRight(0);
		
		assertEquals(controller.getQuestionText(), "Qual è la domanda?");
		assertEquals(controller.getQuestionData().get(0).m_color, Color.GRAY);
		
	}

}
