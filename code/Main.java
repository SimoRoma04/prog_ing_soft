


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.Controller;
import model.Course;
import model.Option;


import javax.swing.JFrame;

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