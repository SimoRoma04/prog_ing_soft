import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JSubPanel extends JPanel{
	
	public JSubPanel() {
		super();
	}
	
	public void addSubPanels(JPanel centralPanel, int altezza, int larghezza) {
		
		//------------- sub panels --------------------
		
		ArrayList<JPanel> subPanel = new ArrayList<JPanel>();
		
			for(int i=0; i<4; i++) {
				subPanel.add(new JPanel());
			}
		
		
		subPanel.get(0).setBackground(Color.black);
		subPanel.get(1).setBackground(Color.darkGray);
		subPanel.get(2).setBackground(Color.gray);
		subPanel.get(3).setBackground(Color.lightGray);
		//centralPanel.setBackground(Color.white);
		
		this.setLayout(new BorderLayout());
		
		for(int i=0; i<4; i++) {
			subPanel.get(i).setPreferredSize(new Dimension(altezza, larghezza));
		}
		
		centralPanel.setPreferredSize(new Dimension(altezza, larghezza));
		
		
		this.add(subPanel.get(0),BorderLayout.NORTH);
		this.add(subPanel.get(1),BorderLayout.SOUTH);
		this.add(subPanel.get(2),BorderLayout.WEST);
		this.add(subPanel.get(3),BorderLayout.EAST);
		this.add(centralPanel, BorderLayout.CENTER);
		
		
	}
	
public void addSubPanels(JScrollPane centralPanel, int larghezza, int altezza) {
		
		//------------- sub panels --------------------
		
		ArrayList<JPanel> subPanel = new ArrayList<JPanel>();
		
			for(int i=0; i<4; i++) {
				subPanel.add(new JPanel());
			}
		
		
		subPanel.get(0).setBackground(Color.black);
		subPanel.get(1).setBackground(Color.darkGray);
		subPanel.get(2).setBackground(Color.gray);
		subPanel.get(3).setBackground(Color.lightGray);
		//centralPanel.setBackground(Color.white);
		
		this.setLayout(new BorderLayout());
		
		for(int i=0; i<4; i++) {
			subPanel.get(i).setPreferredSize(new Dimension(altezza, larghezza));
		}
		
		centralPanel.setPreferredSize(new Dimension(50,50));
		
		
		this.add(subPanel.get(0),BorderLayout.NORTH);
		this.add(subPanel.get(1),BorderLayout.SOUTH);
		this.add(subPanel.get(2),BorderLayout.WEST);
		this.add(subPanel.get(3),BorderLayout.EAST);
		this.add(centralPanel, BorderLayout.CENTER);
		
		
	}
}
