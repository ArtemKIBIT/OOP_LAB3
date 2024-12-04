package LAB3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class PlotDisplayer {
    public static void showChart(double[] arr, double step) {
        XYSeries series = new XYSeries("Function values");

        double x = -15;
        for (double val : arr) {
            series.add(x, val);
            x += step;
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Function Graph",
                "X",
                "f(X)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        JFrame frame = new JFrame("Function Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}
