package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuController extends ControllerAbs {
	
	
	
	public MenuController(String name) {
		super(name);
	}
	
	
	public class StartQuizListener implements ActionListener {
		
		JFrame m_frame;
		
		public StartQuizListener(JFrame frame) {
			m_frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			m_frame.removeAll();
			m_frame.add(new JPanel());
		}
		
	}
}
