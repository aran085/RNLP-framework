package rainbownlp.machinelearning.featurecalculator;

import java.util.ArrayList;
import java.util.List;

import rainbownlp.core.Artifact;

public class FeatureCalculatorUtil {

	public static List<String> getNGramBefore(Artifact startArtifact, int n) {
		ArrayList<String> ngrams = new ArrayList<String>();
		int stepRemained = n;
		Artifact curArtifact = startArtifact.getPreviousArtifact();
		String curInclusiveString = startArtifact.getContent();
		while(stepRemained > 0 && curArtifact != null)
		{
			String curContent = curArtifact.getContent().trim();
			if(curContent.equals(""))
				continue;
			
			curInclusiveString = curContent + "_" + curInclusiveString;
			String jumpString = curContent+"_"+startArtifact.getContent();
			curArtifact = curArtifact.getPreviousArtifact();
			stepRemained--;
			
			ngrams.ad