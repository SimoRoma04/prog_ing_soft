package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import adapter.GuiManagerAdapter;
import adapter.PlayQuizAdapter;
import model.Image;
import model.Option;
import model.PageTypes;

public class AnswerQuestion implements ViewInterface{

	GuiManagerAdapter m_guiManagerAdapter;
	PlayQuizAdapter m_playQuizAdapter;
	ArrayList<JButton> m_buttons;
	
	public AnswerQuestion(GuiManagerAdapter guiManagerAdapter, PlayQuizAdapter playQuizAdapter) {
		m_guiManagerAdapter = guiManagerAdapter;
		m_playQuizAdapter = playQuizAdapter;

		m_playQuizAdapter.startRandomChapter();
	}
	
	public AnswerQuestion(GuiManagerAdapter guiAdapter, PlayQuizAdapter quizAdapter, String chapterName) {
		m_guiManagerAdapter = guiAdapter;
		m_playQuizAdapter = quizAdapter;
		
		m_playQuizAdapter.startChapter(chapterName);
	}
	
	
	@Override
	public void refresh() {
		// Creazione della label per inserimento immagine in pannello blu (4)
		JLabel label = new JLabel();
		ImageIcon image2 = new ImageIcon("Effect_Aard.png");
		label.setIcon(image2);

		
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
		
		//-----
		//inserimento del testo della domanda dal riferimento del controller
		JLabel jLabel = new JLabel(m_playQuizAdapter.getQuestion().getText());
		
		//INSERIMENTO BOTTONE PER LA HOME
		JPanel sup = new JPanel();
		JPanel inf = new JPanel();
		sup.setBackground(Color.orange);
		
		//bottone con icona home
		Icon homeImage = new ImageIcon("home.png");
		JButton homeButton = new JButton(homeImage);
		
		homeButton.addActionListener(e -> m_guiManagerAdapter.loadPage(PageTypes.P_HOME));
		homeButton.setPreferredSize(new Dimension(20, 20));
		homeButton.setOpaque(false);
		homeButton.setContentAreaFilled(false);
		homeButton.setBorderPainted(false);
		
		panel.get(0).setLayout(new BorderLayout());
		
		sup.setPreferredSize(new Dimension(100, 20));
		inf.setPreferredSize(new Dimension(100, 80));
		inf.add(jLabel);
		
		sup.setLayout(new BorderLayout());
		sup.add(homeButton, BorderLayout.EAST);
		
		panel.get(0).add(sup, BorderLayout.NORTH);
		panel.get(0).add(inf, BorderLayout.SOUTH);
		//-----
		
		
		// Inserimento dell'immagine (se c'è)
		if(m_playQuizAdapter.getQuestion().getHasImage()) {
			Image img = m_playQuizAdapter.getQuestion().getImage();
			ImageIcon pic = img.getImage();
			label.setIcon(pic);
		}

		// Panel per immagine
		panel.get(4).add(label); 
		
		// Inserimento del testo della domanda dal riferimento del controller
		panel.get(0).add(new JLabel(m_playQuizAdapter.getQuestion().getText()));
		
		// Inizializzazione dell'ArrayList dei bottoni
		m_buttons = new ArrayList<JButton>();
		
		
		
		// Creazione di un bottone per ogni domanda
		ArrayList<Option> optionList = m_playQuizAdapter.getQuestion().getOptions();
		List<Integer> optionOrderList = new ArrayList<Integer>();
		
		for(int i = 0; i < optionList.size(); i++)
		{
			optionOrderList.add(i);
		}
		Collections.shuffle(optionOrderList);
		
		for(int i = 0; i<optionList.size(); i++) {
			Option o = optionList.get(optionOrderList.get(i));
			JButton temp = new JButton(o.getText());
			
			if(m_playQuizAdapter.isOptionSelected())
			{
				temp.setBackground(o.getIsRight() ? Color.GREEN : Color.RED);
				temp.setOpaque(true);
			}
			
			temp.addActionListener(e -> m_playQuizAdapter.answer(o));  //al posto della stringa bisogna inserire il metodo che viene invocato
			m_buttons.add(temp);
		}
		
		
		// Comandi per sistemare il layout dei pannelli: struttura a griglia
		panel.get(3).setLayout(new GridLayout(2, 2, 10, 10));
		
		// Aggiunta automatica dei bottoni alla pagina
		for (JButton b: m_buttons) {
			panel.get(3).add(b);
		}
		
		
		m_guiManagerAdapter.add(panel.get(0),BorderLayout.NORTH);
		m_guiManagerAdapter.add(panel.get(1),BorderLayout.WEST);
		m_guiManagerAdapter.add(panel.get(2),BorderLayout.EAST);
		m_guiManagerAdapter.add(panel.get(3),BorderLayout.SOUTH);
		m_guiManagerAdapter.add(panel.get(4),BorderLayout.CENTER);

	}
	
	public void disableButtons() {
		for (JButton b: m_buttons) {
			b.setEnabled(false);
		}
	}
}