package view;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import org.knowm.xchart.XChartPanel;

import adapter.GuiManagerAdapter;
import adapter.QuizAdapter;
import model.PageTypes;

import javax.swing.*;

public class Home implements ViewInterface{

	GuiManagerAdapter m_guiManagerAdapter;
	QuizAdapter m_quizAdapter;
	
	public Home(GuiManagerAdapter guiManagerAdapter, QuizAdapter quizAdapter) {
		m_guiManagerAdapter = guiManagerAdapter;
		m_quizAdapter = quizAdapter;
	}
	
	@Override
	public void refresh() {
		
		int larghezza = 800;
		int altezza = 600;
		
		//JFrame frame = new JFrame();
		
		//prova creazione frame con tabella scrollabile
		
		
		///costruzione della Jtable
		String columnName = "ARGOMENTI";
		
		
		String[] coloumnNames = {"INGEGNERIA DEL SOFTWARE"};
		
		
		
		ArrayList<String> chapterList = m_quizAdapter.getChapterList();
		
		String[][] data = new String[1][chapterList.size()];
		data[0] = chapterList.toArray(new String[chapterList.size()]);
		
		JTable table = new JTable(data, coloumnNames){
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false; //Disabilitare la modifica della JTable
				}
			};
			
        table.setPreferredScrollableViewportSize(new Dimension(60, 60));
        table.setFillsViewportHeight(true);
        table.setRowHeight(30);
        table.setFont(new Font("Roboto", 5, 15));
        
//PANNELLO DI DESTRA
		
        JSubPanel panel_dx =new JSubPanel();
        //JPanel panel_dx = new JPanel();
		panel_dx.setLayout(new BorderLayout());
		panel_dx.setPreferredSize(new Dimension(larghezza/3, altezza));
		
		//aggiungo al pannello centrale un pannello scrollabile
        //costruzione del pannello scorribile
		JScrollPane panel_dx_scroll = new JScrollPane(table);
		panel_dx.add(panel_dx_scroll,BorderLayout.CENTER);
		panel_dx.addSubPanels(panel_dx_scroll, 70, 25);

		//aggiungo il pannello di destra al frame
		m_guiManagerAdapter.add(panel_dx, BorderLayout.EAST);

//PANNELLO DI SINISTRA
		JPanel panel_sx = new JPanel();
		panel_sx.setLayout(new BorderLayout());
		panel_sx.setPreferredSize(new Dimension(larghezza*2/3, altezza));
        
		//sottopannello di sx alto
		JSubPanel panel_sx_up =new JSubPanel();
        //JPanel panel_dx = new JPanel();
		panel_sx_up.setLayout(new BorderLayout());
		panel_sx_up.setPreferredSize(new Dimension(larghezza*2/3, altezza/2));
		
		//aggiungo al pannello centrale un pannello scrollabile
        //costruzione del pannello scorribile
		JPanel pannelloGrafico = new JPanel();
		JPanel chartPanel = new XChartPanel(new BarChartHome().getChart());
		panel_sx_up.addSubPanels(chartPanel, 25, 25);
		

		//aggiungo il pannello di sinistra al frame
		panel_sx.add(panel_sx_up, BorderLayout.NORTH);
			
		//sottopannello sx basso
		JSubPanel panel_sx_down =new JSubPanel();
        //JPanel panel_dx = new JPanel();
		panel_sx_down.setLayout(new BorderLayout());
		panel_sx_down.setPreferredSize(new Dimension(larghezza*2/3, altezza/2));
		
        //pannello per i bottoni
		JPanel pannelloBottoni = new JPanel();
		pannelloBottoni.setLayout(new GridLayout(2, 2, 10, 30));
		
		JButton startButton = new JButton("START QUIZ");
		startButton.addActionListener(e -> m_guiManagerAdapter.loadPage(PageTypes.P_QUIZ));
		pannelloBottoni.add(startButton);
		
		JButton setButton = new JButton("SETTINGS");
		setButton.addActionListener(e -> System.out.println("prova pulsante SET"));
		pannelloBottoni.add(setButton);
		
		
		panel_sx_down.addSubPanels(pannelloBottoni, 60, 70);

		//aggiungo il pannello di destra al frame
		panel_sx.add(panel_sx_down, BorderLayout.SOUTH);
		
		//aggiungo i due sotto pannellia sinistro e lo centro a west
		m_guiManagerAdapter.add(panel_sx, BorderLayout.WEST);
		
		return;
	}
	
}

