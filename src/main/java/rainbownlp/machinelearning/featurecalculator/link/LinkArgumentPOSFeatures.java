
/**
 * 
 */
package rainbownlp.machinelearning.featurecalculator.link;

import java.util.List;

import rainbownlp.core.FeatureValuePair;
import rainbownlp.core.FeatureValuePair.FeatureName;
import rainbownlp.core.Phrase;
import rainbownlp.core.PhraseLink;
import rainbownlp.machinelearning.IFeatureCalculator;
import rainbownlp.machinelearning.MLExample;
import rainbownlp.machinelearning.MLExampleFeature;
import rainbownlp.util.FileUtil;

/**
 * @author ehsan-Azadeh
 * 
 */
public class LinkArgumentPOSFeatures implements IFeatureCalculator {
	static int window = 2;
	public static void main (String[] args) throws Exception
	{
		String experimentgroup = "LinkClassificationEventEvent";
		List<MLExample> trainExamples = 
			MLExample.getAllExamples(experimentgroup, true);
		int counter = 0;
		for (MLExample example:trainExamples)
		{
			LinkArgumentPOSFeatures lbf = new LinkArgumentPOSFeatures();
			lbf.calculateFeatures(example);
			counter++;
			FileUtil.logLine(null, "Processed : "+counter +"/"+trainExamples.size());
		}
		List<MLExample> testExamples = 
			MLExample.getAllExamples(experimentgroup, false);
		counter = 0;
		for (MLExample example:testExamples)
		{
			LinkArgumentPOSFeatures lbf = new LinkArgumentPOSFeatures();
			lbf.calculateFeatures(example);
			counter++;
			FileUtil.logLine(null, "Processed : "+counter +"/"+trainExamples.size());
		}
		
	}
	@Override
	public void calculateFeatures(MLExample exampleToProcess) throws Exception {
			PhraseLink phraseLink = exampleToProcess.getRelatedPhraseLink();
			Phrase phrase1 = phraseLink.getFirstPhrase();
			Phrase phrase2 = phraseLink.getSecondPhrase();
			
			// POS of the phrases
		
			FeatureValuePair fromPhrasePOSFeature = FeatureValuePair.getInstance(
					FeatureName.FromPhrasePOS, 
					phrase1.getPOS(), "1");
			MLExampleFeature.setFeatureExample(exampleToProcess, fromPhrasePOSFeature);
			
			FeatureValuePair toPhrasePOSFeature = FeatureValuePair.getInstance(
					FeatureName.ToPhrasePOS, 
					phrase2.getPOS(), "1");
			MLExampleFeature.setFeatureExample(exampleToProcess, toPhrasePOSFeature);
			
//			Artifact start_artifact = phrase1.getStartArtifact();
//			Artifact end_Artifact  = phrase1.getEndArtifact();
//			Artifact cur_artifact = start_artifact;
//			Artifact fromBackwardPointer = start_artifact.getPreviousArtifact();
//			Artifact fromForwardPointer = end_Artifact.getNextArtifact();
//			while(!cur_artifact.equals(end_Artifact))
//			{