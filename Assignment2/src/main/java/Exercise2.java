import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Rectangle2D;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.fx.FXGraphics2D;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise2 extends Application {
	private static final int PREFIX_EXECUTIONS_PER_SIZE = 5;

	static class ChartCanvas extends Canvas {

		JFreeChart chart;

		private FXGraphics2D g2;

		public ChartCanvas(JFreeChart chart) {
			this.chart = chart;
			this.g2 = new FXGraphics2D(getGraphicsContext2D());
			// Redraw canvas when size changes.
			widthProperty().addListener(e -> draw());
			heightProperty().addListener(e -> draw());
		}

		private void draw() {
			double width = getWidth();
			double height = getHeight();
			getGraphicsContext2D().clearRect(0, 0, width, height);
			this.chart.draw(this.g2, new Rectangle2D.Double(0, 0, width, height));
		}

		@Override
		public boolean isResizable() {
			return true;
		}

		@Override
		public double prefWidth(double height) {
			return getWidth();
		}

		@Override
		public double prefHeight(double width) {
			return getHeight();
		}
	}

	private static JFreeChart createChart(XYDataset dataset) {

		JFreeChart chart = ChartFactory.createXYLineChart(
				"Prefix Avarege - Experimental Analysis", "n value", 
				"Time (s)", dataset);

		String fontName = "Palatino";
		chart.getTitle().setFont(new Font(fontName, Font.BOLD, 18));
		chart.addSubtitle(new TextTitle("prefixAverage1 vs prefixAverage2", 
				new Font(fontName, Font.PLAIN, 14)));

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setDomainPannable(true);
		plot.setRangePannable(false);
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
		plot.getDomainAxis().setLowerMargin(0.0);
		plot.getDomainAxis().setLabelFont(new Font(fontName, Font.BOLD, 14));
		plot.getDomainAxis().setTickLabelFont(new Font(fontName, Font.PLAIN, 12));
		plot.getRangeAxis().setLabelFont(new Font(fontName, Font.BOLD, 14));
		plot.getRangeAxis().setTickLabelFont(new Font(fontName, Font.PLAIN, 12));
		chart.getLegend().setItemFont(new Font(fontName, Font.PLAIN, 14));
		chart.getLegend().setFrame(BlockBorder.NONE);
		chart.getLegend().setHorizontalAlignment(HorizontalAlignment.CENTER);
		XYItemRenderer r = plot.getRenderer();
		if (r instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
			renderer.setDefaultShapesVisible(false);
			renderer.setDrawSeriesLineAsPath(true);
			// set the default stroke for all series
			renderer.setAutoPopulateSeriesStroke(false);
			renderer.setDefaultStroke(new BasicStroke(3.0f, BasicStroke.CAP_ROUND, 
					BasicStroke.JOIN_BEVEL), false);
			renderer.setSeriesPaint(0, Color.RED);
			renderer.setSeriesPaint(1, new Color(24, 123, 58));
			renderer.setSeriesPaint(2, new Color(149, 201, 136));
			renderer.setSeriesPaint(3, new Color(1, 62, 29));
			renderer.setSeriesPaint(4, new Color(81, 176, 86));
			renderer.setSeriesPaint(5, new Color(0, 55, 122));
			renderer.setSeriesPaint(6, new Color(0, 92, 165));
			renderer.setDefaultLegendTextFont(new Font(fontName, Font.PLAIN, 14));
		}

		return chart;

	}

	private static XYDataset createDataset() {

		double[][] arrayNums = generateValues();
		long startTime, endTime, totalTime = 0;

		XYSeries xy1 = new XYSeries("prefixAverage1");
		XYSeries xy2 = new XYSeries("prefixAverage2");

		showAlert("The system will generate the prefixes average time.\n"
				+ "It is going to take up 5 minutes. Please be patience.\n\n"
				+ "Press OK to start.");
		for (int i = 0; i < arrayNums.length; i++) {
			totalTime = 0;
			System.out.printf("Using prefixAverage1 for %d items: ", 
					arrayNums[i].length);
			for (int ct = 0; ct < PREFIX_EXECUTIONS_PER_SIZE; ct++) {
				startTime = System.currentTimeMillis();
				PrefixAverage.prefixAverage1(arrayNums[i]);
				endTime = System.currentTimeMillis();
				System.out.printf("%dms ", (endTime - startTime));
				totalTime += (endTime - startTime);
			}
			totalTime /= PREFIX_EXECUTIONS_PER_SIZE;
			totalTime /= 1000; // Transform in seconds
			System.out.printf(" - Avg: %ds\n", totalTime);
			xy1.add(arrayNums[i].length, totalTime);

			System.out.printf("Using prefixAverage2 for %d items: ", 
					arrayNums[i].length);
			for (int ct = 0; ct < PREFIX_EXECUTIONS_PER_SIZE; ct++) {
				startTime = System.currentTimeMillis();
				PrefixAverage.prefixAverage2(arrayNums[i]);
				endTime = System.currentTimeMillis();
				System.out.printf("%dms ", (endTime - startTime));
				totalTime = (endTime - startTime);
			}
			totalTime /= PREFIX_EXECUTIONS_PER_SIZE;
			totalTime /= 1000; // Transform in seconds
			System.out.printf(" - Avg: %ds\n\n", totalTime);
			xy2.add(arrayNums[i].length, totalTime);
		}

		showAlert("All calculations are done. Press ok to display the chart.");

		XYSeriesCollection collection = new XYSeriesCollection();
		collection.addSeries(xy1);
		collection.addSeries(xy2);

		return collection;
	}

	@Override
	public void start(Stage stage) throws Exception {
		XYDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		ChartCanvas canvas = new ChartCanvas(chart);
		StackPane stackPane = new StackPane();

		stackPane.getChildren().add(canvas);
		// Bind canvas size to stack pane size.
		canvas.widthProperty().bind(stackPane.widthProperty());
		canvas.heightProperty().bind(stackPane.heightProperty());
		stage.setScene(new Scene(stackPane));
		stage.setTitle("Exercise 2 - Prefix Average");
		stage.setWidth(700);
		stage.setHeight(390);

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private static double[][] generateValues() {
		int[] sizes = { 5, 10, 25, 50, 75, 100, 125, 150 };
		double[][] result = new double[sizes.length][];

		for (int i = 0; i < sizes.length; i++) {
			int value = sizes[i];
			result[i] = new double[value];
			for (int j = 0; j < value; j++) {
				result[i][j] = Math.random() * 100;
			}
		}

		return result;
	}

	// Show a Information Alert with header Text
	public static void showAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Exercise 2 - Prefix Average");
		alert.setContentText(message);
		alert.showAndWait();
	}

}
