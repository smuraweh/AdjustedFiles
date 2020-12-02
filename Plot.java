import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Plot extends JFrame {
	
	Student student = new Student();
	//Add attendance = new Add();
	
	public Plot(Student[] studentList)
	{	
		String chartTitle = "Attendance";
	    String xAxisLabel = "ID Number";
	    String yAxisLabel = "Minutes Attended";
	    
	    XYSeriesCollection data = new XYSeriesCollection();
	    XYSeries series1 = new XYSeries("Attendance 1");
	 
	    /*series1.add(1.0, 2.0);
	    series1.add(2.0, 3.0);
	    series1.add(3.0, 2.5);
	    series1.add(3.5, 2.8);
	    series1.add(4.2, 6.0);*/
	    
	    data.addSeries(series1);
	    
	    XYDataset dataset = data;


	    for(int i = 0; i < studentList.length; i++)
	    {
	    	double idNum = Double.parseDouble(studentList.get(i).getID());
	    	double minutes = Double.parseDouble(student.attendance.); // For attendance
	    	series1.add(idNum, minutes);
	    }
		 
	    JFreeChart chart = ChartFactory.createScatterPlot(chartTitle, xAxisLabel, yAxisLabel, dataset);
		
		JPanel chartPanel = new ChartPanel(chart);
		//JFrame frame = new JFrame();
        this.add(chartPanel, BorderLayout.CENTER);
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void display(LinkedList<Student> studentList)
	{
		new Plot(studentList).setVisible(true);
	}
}
