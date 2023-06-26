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
	   priv