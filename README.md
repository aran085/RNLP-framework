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

2. Instantiate 'Phrase' and 'PhraseLink' to load annotations, and persist them with Hi