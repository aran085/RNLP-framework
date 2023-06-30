package rainbownlp.analyzer.evaluation.regression;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class RegressionGraph extends JPanel {
	   private static final int MAX_SCORE = 20;
	   private static final int PREF_W = 800;
	   private static final int PREF_H = 650;
	   private static final int BORDER_GAP = 30;
	   private static final Color GRAPH_COLOR = Color.green;
	   private static final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
	   private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
	   private static final int GRAPH_POINT_WIDTH = 12;
	   private static final int Y_HATCH_CNT = 10;
	   List<Double> xValues;
	   List<Double> yValues;
	

	   public RegressionGraph(List<Double> xs, List<Double> ys) throws Exception {
		   if(xs.size()!=ys.size())
			   throw(new Exception("X and Y values must have same size"));
			xValues = xs;
			yValues = ys;
		}

	@Override
	   protected void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      Graphics2D g2 = (Graphics2D)g; 
	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	      double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (xValues.size() - 1);
	      double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (yValues.size() - 1);

	      List<Point> graphPoints = new ArrayList<Point>();
	      for (int i = 0; i < xValues.size(); i++) {
	         int x1 = (int) (xValues.get(i) * xScale + BORDER_GAP);
	         int y1 = (int) (yValues.get(i) * yScale + BORDER_GAP);