/**
 * 
 */
package rainbownlp.machinelearning.featurecalculator.link;

import java.util.List;

import rainbownlp.core.FeatureValuePair;
import rainbownlp.core.Phrase;
import rainbownlp.core.PhraseLink;
import rainbownlp.core.FeatureValuePair.FeatureName;
import rainbownlp.machinelearning.IFeatureCalculator;
import rainbownlp.machinelearning.MLExample;
import rainbownlp.machinelearning.MLExampleFeature;
import rainbownlp.util.FileUtil;

/**
 * @author Azadeh
 * 
 */
public class LinkGeneralFeatures implements IFeatureCalculator {
	
	public static void main (String[] args) throws Exception
	{
		String experimentgroup = "LinkClassificationEventEvent";
		List<MLExample> trainExamples = 
			MLExample.getAllExamples(experimentgroup, true);
		int counter = 0;
		for (MLExample example:trainExamples)
		{
			LinkGeneralFeatures lbf = new LinkGeneralFeatures();
			lbf.calculateFeatures(example);
			counter++;
			FileUtil.logLine(null, "Processed : "+counter +"/"+trainExamples.size());
		}
		
	}
	@Override
	public void calculateFeatures(MLExample exampleToProcess) {
			
			PhraseLink phraseLink = exampleToProcess.getRelatedPhraseLink();
			Phrase phrase1 = phraseLink.getFromPhrase();
			Phrase phrase2 = phraseLink.getToPhrase();
			
			String relation_location_type = getInterMentionLocationType(phrase1,phrase2);
			
			
			FeatureValuePair argumentTypeFeature = FeatureValuePair.getInstance(
						FeatureName.InterMentionLocationType, 
						relation_location_type,"1");
				
			MLExampleFeature.setFeatureExample(exampleToProcess, argumentTypeFeature);
			
			// The content of the args
			FeatureValuePair fromPhraseContentFeature = FeatureValuePai