package model;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import adapter.*;
import view.Home;
import view.ViewInterface;

public class GuiManager extends JFrame{
	ViewInterface m_view;
	GuiManagerAdapter m_guiManagerAdapter;
	
	public GuiManager()
	{
		super();
		
		m_guiManagerAdapter = new GuiManagerAdapter(this);
		m_view = new Home(m_guiManagerAdapter);
		
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(10,10));
		this.setResizable(false);
		
		paint(m_view.refresh());
	}
	
	public void paint(JPanel jPanel)
	{
		
	}
}