package utils;


import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

import java.util.Arrays;

public class Chart {
    public static void main(String[] args) {
        CategoryChart c = new Chart().getChart();
        new SwingWrapper<CategoryChart>(c).displayChart();

    }

    public void drawChart(){

    }

    public CategoryChart getChart() {

        // Create Chart
        CategoryChart chart =
                new CategoryChartBuilder()
                        .width(800)
                        .height(600)
                        .title("Score Histogram")
                        .xAxisTitle("Score")
                        .yAxisTitle("Number")
                        .build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setPlotGridLinesVisible(false);

        // Series
        chart.addSeries("test 1", Arrays.asList(0, 1, 2, 3, 4), Arrays.asList(4, 5, 9, 6, 5));

        return chart;
    }
}
