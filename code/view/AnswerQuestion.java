package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import adapter.GuiManagerAdapter;
import adapter.QuizAdapter;
import model.Image;
import model.Option;

public class AnswerQuestion implements ViewInterface{

	GuiManagerAdapter m_guiAdapter;
	QuizAdapter m_quizAdapter;
	ArrayList<JButton> m_buttons;
	private JPanel frame;
	
	public AnswerQuestion(GuiManagerAdapter guiAdapter, QuizAdapter quizAdapter) {

		m_guiAdapter = guiAdapter;
		m_quizAdapter = quizAdapter;

		// Creazione della label per inserimento immagine in pannello blu (4)
		JLabel label = new JLabel();
		ImageIcon image2 = new ImageIcon("Effect_Aard.png");
		label.setIcon(image2);

		frame = new JPanel();
		
		// Creazione di tutti i pannelli insieme
		ArrayList<JPanel> panel = new ArrayList<JPanel>();
		
		for(int i=0; i<5; i++) {
			panel.add(new JPanel());
		}
		
		// DEBUGGING DA ELIMINARE
		panel.get(0).setBackground(Color.red);
		panel.get(1).setBackground(Color.green);
		panel.get(2).setBackground(Color.yellow);
		panel.get(3).setBackground(Color.magenta);
		panel.get(4).setBackground(Color.blue);
		
				
		panel.get(0).setPreferredSize(new Dimension(100,100));
		panel.get(1).setPreferredSize(new Dimension(150,100));
		panel.get(2).setPreferredSize(new Dimension(150,100));
		panel.get(3).setPreferredSize(new Dimension(100,200));
		panel.get(4).setPreferredSize(new Dimension(100,100));
		
		
		// Inserimento dell'immagine (se c'è)
		if(m_quizAdapter.getQuestion().getHasImage()) {
			Image img = m_quizAdapter.getQuestion().getImage();
			ImageIcon pic = img.getImage();
			label.setIcon(pic);
		}

		// Panel per immagine
		panel.get(4).add(label); 
		
		// Inserimento del testo della domanda dal riferimento del controller
		panel.get(0).add(new JLabel(m_quizAdapter.getQuestion().getText()));
		
		// Inizializzazione dell'ArrayList dei bottoni
		m_buttons = new ArrayList<JButton>();
		
		// Creazione di un bottone per ogni domanda
		for (Option o: m_quizAdapter.getQuestion().getOptions()) {
			JButton temp = new JButton(o.getText());
			temp.addActionListener(e -> System.out.println("prova pulsante" + o.getText()));  //al posto della stringa bisogna inserire il metodo che viene invocato
			m_buttons.add(temp);
		}
		
		
		// Comandi per sistemare il layout dei pannelli: struttura a griglia
		panel.get(3).setLayout(new GridLayout(2, 2, 10, 10));
		
		// Aggiunta automatica dei bottoni alla pagina
		for (JButton b: m_buttons) {
			panel.get(3).add(b);
		}
		
		
		frame.add(panel.get(0),BorderLayout.NORTH);
		frame.add(panel.get(1),BorderLayout.WEST);
		frame.add(panel.get(2),BorderLayout.EAST);
		frame.add(panel.get(3),BorderLayout.SOUTH);
		frame.add(panel.get(4),BorderLayout.CENTER);
		
		this.refresh();
		
	}

	@Override
	public void refresh() {
		SwingUtilities.updateComponentTreeUI(frame);	
	}
	
	public void disableButtons() {
		for (JButton b: m_buttons) {
			b.setEnabled(false);
		}
	}
}