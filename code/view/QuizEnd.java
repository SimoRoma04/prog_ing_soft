package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import adapter.GuiManagerAdapter;
import adapter.PlayQuizAdapter;
import model.PageTypes;

public class QuizEnd implements ViewInterface {
	GuiManagerAdapter m_guiManagerAdapter;
	PlayQuizAdapter m_playQuizAdapter;
	
	public QuizEnd(GuiManagerAdapter guiManagerAdapter, PlayQuizAdapter playQuizAdapter) {
		m_guiManagerAdapter = guiManagerAdapter;
		m_playQuizAdapter = playQuizAdapter;
	}


	public void refresh() {
		
		ArrayList<JPanel> panel = new ArrayList<JPanel>();
		
		for(int i=0; i<5; i++) {
			panel.add(new JPanel());
		}
		
		/*
		panel.get(0).setBackground(Color.red);
		panel.get(1).setBackground(Color.green);
		panel.get(2).setBackground(Color.yellow);
		panel.get(3).setBackground(Color.magenta);
		panel.get(4).setBackground(Color.blue);
		*/
		
		panel.get(4).setLayout(new BorderLayout());
				
		panel.get(0).setPreferredSize(new Dimension(100,150));
		panel.get(1).setPreferredSize(new Dimension(100,250));
		panel.get(2).setPreferredSize(new Dimension(100,100));
		panel.get(3).setPreferredSize(new Dimension(100,200));
		panel.get(4).setPreferredSize(new Dimension(100,100));
		
		//------------- sub panels --------------------
		
		JPanel sup = new JPanel();
		JPanel inf = new JPanel();
		sup.setPreferredSize(new Dimension(100, 100));
		inf.setPreferredSize(new Dimension(100, 100));
		//sup.setBackground(Color.orange);
		//inf.setBackground(Color.pink);
		
		//lavoro sul pannello sup in cui inserirò la progress bar
		JProgressBar progress = new JProgressBar(0, 100);
		
	//SOSTITUIRE A 60 IL VALORE PERCENTUALE OTTENUTO	
		progress.setValue((int)((float)m_playQuizAdapter.getRightAnswerCount() / (float)m_playQuizAdapter.getTotalAnswerCount() * 100)); // inserire il punteggio (percentuale) ottenuto
		progress.setStringPainted(true);
		//UIManager.put("ProgressBar.background", Color.BLACK);
	    UIManager.put("ProgressBar.foreground", Color.GREEN);
	    UIManager.put("ProgressBar.selectionBackground", Color.BLUE);
	    UIManager.put("ProgressBar.selectionForeground", Color.BLUE);
	    
	    progress.setPreferredSize(new Dimension(550, 40));
	    
	    progress.setFont(new Font("Roboto", 5, 25));
		sup.add(progress);
		
		panel.get(4).setLayout(new BorderLayout());
		
		//lavoro sul pannello inf in cui scrivo quante risposte corrette sono state date
		JLabel testoRisposte = new JLabel("<html>Hai risposto correttamente a " + m_playQuizAdapter.getRightAnswerCount() + " domande su " + m_playQuizAdapter.getTotalAnswerCount());
		testoRisposte.setPreferredSize(new Dimension(550, 75));
		testoRisposte.setFont(new Font("Arial", 5 , 24));
		inf.add(testoRisposte);

		
		panel.get(4).add(inf, BorderLayout.SOUTH);
		panel.get(4).add(sup, BorderLayout.NORTH);
		
		//lavoro sul pannello principale in alto
		JLabel testoFineCapitolo = new JLabel("<html>QUIZ SUL " + m_playQuizAdapter.getChapterName() + " COMPLETATO!");
		testoFineCapitolo.setPreferredSize(new Dimension(500, 100));
		testoFineCapitolo.setFont(new Font("Arial", 5 , 30));
		panel.get(0).add(testoFineCapitolo);
		
		//lavoro sul pannello principale in basso
		JButton homeButton = new JButton("TORNA ALLA HOME");
		
		homeButton.addActionListener(e -> m_guiManagerAdapter.loadPage(PageTypes.P_HOME));
		homeButton.setPreferredSize(new Dimension(300, 75));
		panel.get(3).add(homeButton);
		
		
		//------------- sub panels --------------------

		m_guiManagerAdapter.add(panel.get(0),BorderLayout.NORTH);
		m_guiManagerAdapter.add(panel.get(1),BorderLayout.WEST);
		m_guiManagerAdapter.add(panel.get(2),BorderLayout.EAST);
		m_guiManagerAdapter.add(panel.get(3),BorderLayout.SOUTH);
		m_guiManagerAdapter.add(panel.get(4),BorderLayout.CENTER);
	}
}