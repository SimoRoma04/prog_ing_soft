package model;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import adapter.*;
import view.Home;
import view.ViewInterface;

public class GuiManager extends JFrame{

	ViewInterface m_view;
	GuiManagerAdapter m_guiManagerAdapter;
	QuizAdapter m_quizAdapter;
	//JFrame m_frame = new JFrame();
	
	public GuiManager()
	{
		super();
		
		m_guiManagerAdapter = new GuiManagerAdapter(this);
		m_quizAdapter = new QuizAdapter();
		
		m_view = new Home(m_guiManagerAdapter, m_quizAdapter);
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(800, 600);
		super.setResizable(false);
		super.setLayout(new BorderLayout(10,10));
		super.setVisible(true);
		m_view.refresh();
	}
	
	public void add(Component comp, Object constraints)
	{
		super.add(comp, constraints);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void loadPage(PageTypes type) {
		super.setVisible(false);
		super.removeAll();
		m_view = null;
		
		switch(type){
			case P_HOME:
				m_view = new Home(m_guiManagerAdapter, m_quizAdapter);
				break;
			case P_SETTINGS:
				// m_view = new Settings(m_guiManagerAdapter, m_quizAdapter);
				break;
			case P_CHAPTER_SELECTION:
				// m_view = new ChapterSelection(m_guiManagerAdapter, m_quizAdapter);
				break;
			case P_STATISTICS:
				// m_view = new Statistics(m_guiManagerAdapter, m_quizAdapter);
				break;
			case P_QUIZ:
				// m_view = new Quiz(m_guiManagerAdapter, m_quizAdapter);
				break;
		}
		
		super.setVisible(true);
		m_view.refresh();
		
	}
}