package rainbownlp.machinelearning.featurecalculator.sentence;

import rainbownlp.core.Artifact;
import rainbownlp.core.FeatureValuePair;
import rainbownlp.core.Artifact.Type;
import rainbownlp.machinelearning.IFeatureCalculator;
import rainbownlp.machinelearning.MLExample;
import rainbownlp.machinelearning.MLExampleFeature;

public class SentenceSyntax implements IFeatureCalculator {

	@Override
	public void calculateFeatures(MLExample exampleToProcess) {
		Artifact sentence = exampleToProce