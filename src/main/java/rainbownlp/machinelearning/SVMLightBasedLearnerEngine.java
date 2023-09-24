package rainbownlp.machinelearning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import rainbownlp.machinelearning.convertor.SVMLightFormatConvertor;
import rainbownlp.util.ConfigurationUtil;
import rainbownlp.util.HibernateUtil;
import rainbownlp.util.SystemUtil;


public abstract class SVMLightBasedLearnerEngine extends LearnerEngine {

	
	public void train(List<MLExample> pTrainExamples) throws Exception {
		ConfigurationUtil.TrainingMode = true;
		HibernateUtil.clearLoaderSession();
		
		//This part added since the session was so slow
		List<Integer> train_example_ids = new ArrayList<Integer>();
		for(MLExample example : pTrainExamples)
		{
			train_example_i