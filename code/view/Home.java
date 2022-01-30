package view;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import org.knowm.xchart.XChartPanel;

import adapter.GuiManagerAdapter;
import adapter.QuizAdapter;
import adapter.StatisticsAdapter;
import model.PageTypes;

import javax.swing.*;

public class Home implements ViewInterface{

	GuiManagerAdapter m_guiManagerAdapter;
	QuizAdapter m_quizAdapter;
	StatisticsAdapter m_statisticsAdapter;
	
	public Home(GuiManagerAdapter guiManagerAdapter, QuizAdapter quizAdapter, StatisticsAdapter statisticsAdapter) {
		m_guiManagerAdapter = guiManagerAdapter;
		m_quizAdapter = quizAdapter;
		m_statisticsAdapter = statisticsAdapter;
	}
	
	@Override
	public void refresh() {
		
		int larghezza = 800;
		int altezza = 600;
		
		//JFrame frame = new JFrame();
		
		//prova creazione frame con tabella scrollabile
		
		
		///costruzione della Jtable	
		ArrayList<String> chapterList = m_quizAdapter.getChapterList();
		
		DefaultTableModel model = new DefaultTableModel();
		
        model.addColumn("ARGOMENTI");
        
        for(int i = 0; i < chapterList.size(); i++)
        {
    		model.addRow(new String[] {chapterList.get(i)});
        }
        
		JTable table = new JTable(model) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false; //Disabilitare la modifica della JTable
			}
		};
		
		table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
              if (e.getClickCount() == 2) {
                JTable target = (JTable)e.getSource();
                int row = target.getSelectedRow();
                m_guiManagerAdapter.loadPage(PageTypes.P_QUIZ, chapterList.get(row));
              }
            }
          });
		
		
			
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
		BarChartHome barChartHome = new BarChartHome(m_statisticsAdapter);
		JPanel chartPanel = new XChartPanel(barChartHome.getChart());
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
		startButton.addActionListener(e -> m_guiManagerAdapter.loadPage(PageTypes.P_RANDOM_QUIZ));
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

