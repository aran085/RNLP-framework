/**
 * 
 */
package rainbownlp.machinelearning.featurecalculator.link;

import java.util.List;

import rainbownlp.core.Artifact;
import rainbownlp.core.FeatureValuePair;
import rainbownlp.core.Phrase;
import rainbownlp.core.PhraseLink;
import rainbownlp.core.FeatureValuePair.FeatureName;
import rainbownlp.core.graph.GraphEdge;
import rainbownlp.machinelearning.IFeatureCalculator;
import rainbownlp.machinelearning.MLExample;
import rainbownlp.machinelearning.MLExampleFeature;
import rainbownlp.parser.DependenciesTreeUtil;

/**
 * @author ehsan
 * 
 */
public class ParseTreeFeatures implements IFeatureCalculator {
	public static void main(String[] args) throws Exception
	{
//		List<MLExample> trainExamples = 
//			MLExample.getAllExamples(LinkExampleBuilder.ExperimentGroupEventEvent, true);
//		trainExamples.addAll(
//				MLExample.getAllExamples(LinkExampleBuilder.ExperimentGroupTimexEvent, true));
//		for ( MLExample example_to_process: trainExamples )
//		{
//			ParseTreeFeatures pt =  new ParseTreeFeatures();
//			
//			pt.calc