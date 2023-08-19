package rainbownlp.machinelearning;

import java.sql.SQLException;

import rainbownlp.util.ConfigurationUtil;
import rainbownlp.util.ConfigurationUtil.OperationMode;

public class LearnerCommon {

	public static void includeExamples(String updateTo) throws SQLException {
//		if(Setting.Mode==OperationMode.EDGE)
//		{
//			RelationExampleTable.setTestAsTrain();
//			RelationExampleTable.include(updateTo);
//		}
//		if(Setting.Mode==OperationMode.TRIGGER)
//		{
//			ArtifactExampleTable.setTestAsTrain();
//			ArtifactExampleTable.include(updateTo);
//		}
	}

	public static String[] getClassTitles() {
		String[] class_titles = new String[1];
		if (ConfigurationUtil.getValue("RelationMode").equals("BioNLP")) {
//			if(Configuration.Mode==OperationMode.EDGE)
//			{
//				class_titles = new String[BioConceptsRelation.BioRelationTypes.values().length];
//				for(int i=0;i<BioConceptsRelation.BioRelationTypes.values().length;i++)
//					class_titles[i] = BioConceptsRelation.BioRelationTypes.values()[i].name();
//			}else
//			{
//				class_titles = new String[BioNLPLoader.TriggerTypes.values().length