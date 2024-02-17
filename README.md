RNLP Framework
==========

RNLP Framework is a comprehensive tool for various natural language processing tasks including: supervised name entity recognition and relationship extraction.

Configuration
==========
RNLP Framework is built on Hibernate and is easily configured to use different data sources (e.g. mysql).
Hibernate settings are in hibernate.cfg.xml, ensure to correctly set connection.url, connection.username and connection.password. Other application settings are in configuration.conf, paths should be updated and exist.

The following instructions illustrate how to use RNLP Framework for distinct applications.

Relationship Extraction
==========
The system requires the text document and entities annotations for relationship extraction.

1. Utilize 'SimpleDocumentLoader' or create a new document loader by implementing 'IDocumentAnalyzer' interface to load test/train documents into the framework.

2. Instantiate 'Phrase' and 'PhraseLink' to load annotations, and persist them with HibernateUtil.

3. Create machine learning examples by creating Phrase/PhraseLink and MLExample objects.

4. Determine features for every machine learning example (MLExample objects).

5. Train a machine learning model with train examples.

6. Test and evaluate the model using test examples.

This is an example of temporal relationship extraction implementation: https://github.com/aran085/temporal-relation.git

How to cite in your publication?
==========
Please cite the following publication if RNLP Framework is used in your projects: 

Emadzadeh, E.; Jonnalagadda, S.; Gonzalez, G., 'Evaluating Distributional Semantic and Feature Selection for Extracting Relationships from Biological Text,' Machine Learning and Applications and Workshops (ICMLA), 2011 10th International Conference on, vol.2, no., pp.66,71, 18-21 Dec. 2011

Questions/Comments
==========
Do not hesitate to contact us with your questions and comments.