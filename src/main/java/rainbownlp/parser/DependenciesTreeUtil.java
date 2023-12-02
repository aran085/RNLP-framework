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
	
	public Artifact sentenceArtifact;
	
	UndirectedGraph<String, GraphEdge> sentenceTree =
            new SimpleGraph<String, GraphEdge>(GraphEdge.class);
	
	List<DependencyLine> dependencies;
	SentenceClauseManager clauseManager;
	public DependenciesTreeUtil(Artifact pSentence) throws Exception
	{
		sentenceArtifact = pSentence;
		clauseManager =
				new SentenceClauseManager(sentenceArtifact);
		dependencies = clauseManager.sentDepLines;
		makeTrees();
	}
	



	private void makeTrees() {
			
			for(DependencyLine depLine:dependencies)
			{
				if(!sentenceTree.containsVertex(depLine.firstPart+depLine.firstOffset))
					sentenceTree.addVertex(depLine.firstPart+depLine.firstOffset);
				if(!sentenceTree.containsVertex(depLine.secondPart+depLine.secondOffset))
					sentenceTree.addVertex(depLine.secondPart+depLine.secondOffset);
				
				//make link v1 & v2
				sentenceTree.addEdge(depLine.firstPart+depLine.firstOffse