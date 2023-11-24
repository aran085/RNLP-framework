package rainbownlp.parser;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleGraph;

import rainbownlp.analyzer.sentenceclause.SentenceClauseManager;
import rainbownlp.core.Artifact;
import rainbownlp.core.graph.GraphEdge;

// This uses  Stanford Dependencies (SD)  file
public class DependenciesTreeUtil {
	
	public 