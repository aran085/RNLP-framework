package rainbownlp.machinelearning;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.annotations.GenericGenerator;

import rainbownlp.core.Artifact;
import rainbownlp.core.Artifact.Type;
import rainbownlp.core.FeatureValuePair;
import rainbownlp.core.Phrase;
import rainbownlp.core.PhraseLink;
import rainbownlp.core.PhraseLink.LinkType;
import rainbownlp.util.FileUtil;
import rainbownlp.util.HibernateUtil;
import rainbownlp.util.ConfigurationUtil;

@Entity
@Table( name = "MLExample" )
public class MLExample  implements Serializable {
	int exampleId;


	String predictedClass;
	String expectedClass;
	boolean forTrain;
	String corpusName;
	String predictionEngine;
	Artifact relatedArtifact;
	Phrase relatedPhrase;
	
	PhraseLink relatedPhraseLink;
	private String associatedFilePath;
	private double predictionWeight;
	private int expectedReal;
	private int expectedClosure;
	private int expectedIntegrated;
	private String expectedClassOptionalCategory;
	private String predictedClassOptionalCategory;
	private String relatedConcept;
	
	@Transient
	List<MLExampleFeature> exampleFeatures;
	static public Session hibernateSession; 
	@Transient
	public List<MLExampleFeature> getExampleFeatures()
	{
		if(exampleFeatures==null)
		{
			if(hibernateSession == null)
				hibernateSession = HibernateUtil.sessionFactory.openSession();
			String hql = "from MLExampleFeature where relatedExample = "+
			 getExampleId()+ 
			 " order by featureValuePair.tempFeatureIndex";
			exampleFeatures = (List<MLExampleFeature>) HibernateUtil.executeReader(hql, null,null, hibernateSession);
		}
		return exampleFeatures;
	}

	@Transient
	public MLExampleFeature getExampleFeatureById(int featureValuePairId)
	{
		
		if(hibernateSession == null)
			hibernateSession = HibernateUtil.sessionFactory.open