package view;
import java.util.ArrayList;
import java.util.Arrays;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.style.Styler.ChartTheme;

import adapter.StatisticsAdapter;
import model.StatisticsManager;

public class BarChartHome {
	StatisticsAdapter m_statisticsAdapter;
	
	public BarChartHome(StatisticsAdapter statisticsAdapter)
	{
		m_statisticsAdapter = statisticsAdapter;
	}
	
	public CategoryChart getChart() {
		 
	    // Create Chart
	    CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Progressi").xAxisTitle("Capitoli").yAxisTitle("Risposte").theme(ChartTheme.GGPlot2).build();
	 
	    // Customize Chart
	 
	    // Series
	    
	    ArrayList<String> chapters = m_statisticsAdapter.getChapterList();
	    ArrayList<Integer> rights = m_statisticsAdapter.getRightAnswerList();
	    ArrayList<Integer> wrongs = m_statisticsAdapter.getWrongAnswerList();
	    
	    if(chapters.size() == 0)
	    {
	    	chapters.add("No data");
	    	rights.add(0);
	    	wrongs.add(0);
	    }
	    
	    chart.addSeries(
	    		"Corrette", 
	    		chapters,
	    		rights
	    		);
	    chart.addSeries(
	    		"Sbagliate", 
	    		chapters, 
	    		wrongs
	    		);
	    

	 
	    return chart;
	  }
	
	
}
