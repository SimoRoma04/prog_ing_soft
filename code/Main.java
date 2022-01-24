
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.Controller;
import model.Course;
import model.Option;
import model.Quiz;

import javax.swing.JFrame;

public class Main{

	public static void main(String[] args) {
		
		
		Course ingegneriaPieristica = new Course("Ingegneria del Piero");
		
		Option o = new Option();
		o.setText("Risposta 1");
		o.setIsRight(true);
		
		ArrayList<Option> options = new ArrayList<Option>();
		options.add(o);
		
		Quiz q = new Quiz();
		q.setName("Domanda di prova");
		q.setQuestion("Qual è la domanda?");
		q.setOptions(options);
	
		Quiz r = new Quiz();
		r.setName("Domanda di prova");
		r.setQuestion("Qual è la domanda?");
		r.setOptions(options);
		
		
		ingegneriaPieristica.addQuiz(q);
		ingegneriaPieristica.addQuiz(r);
		
		Controller piero = new Controller(ingegneriaPieristica.getName(), ingegneriaPieristica);
		
		new AnswerQuestion(piero);
		// new Home(new TestController("pierino"));
		System.out.println("Sto eseguedo il main");
	}
}