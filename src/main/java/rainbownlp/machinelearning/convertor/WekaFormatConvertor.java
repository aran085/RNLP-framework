package rainbownlp.machinelearning.convertor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import rainbownlp.core.FeatureValuePair;
import rainbownlp.machinelearning.MLExample;
import rainbownlp.machinelearning.MLExampleFeature;
import rainbownlp.util.FileUtil;
import rainbownlp.util.HibernateUtil;
import rainbownlp.util.ConfigurationUtil;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SparseInstance;
import weka.core.converters.ArffSaver;
import weka.core.converters.Saver;

public class WekaFormatConvertor {
	static int numClassRatio = ConfigurationUtil.getValueInteger("numClassesRatio");
	
	public static void writeToFile(List<Integer> exampleIdsToWrite, String filePath,String taskName
			,String[] possibleClasses) 
		throws Exception
	{
		if(new File(filePath).exists()) return;
		
		
		int counter = 0;
	    // set attributes
	    List<FeatureValuePair> fvps = (List<FeatureValuePair>) 
	    		H