import java.util.ArrayList;
import java.util.Arrays;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.style.Styler.ChartTheme;

public class BarChartHome {
	public CategoryChart getChart() {
		 
	    // Create Chart
	    CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Progressi").xAxisTitle("Capitoli").yAxisTitle("Risposte").theme(ChartTheme.GGPlot2).build();
	 
	    // Customize Chart
	 
	    // Series
	    chart.addSeries("Corrette", new ArrayList<String>(Arrays.asList(new String[] { "Cap1", "Cap2", "Cap3", "Cap4", "Cap5" })), new ArrayList<Number>(Arrays.asList(new Number[] { 40, 30, 20, 60,
	        60 })));
	    chart.addSeries("Sbagliate", new ArrayList<String>(Arrays.asList(new String[] { "Cap1", "Cap2", "Cap3", "Cap4", "Cap5" })), new ArrayList<Number>(Arrays.asList(new Number[] { 50, 10, 20, 40,
	        60 })));

	 
	    return chart;
	  }
	
	
}
