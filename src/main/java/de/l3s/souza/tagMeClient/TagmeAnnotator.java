package de.l3s.souza.tagMeClient;

import it.acubelab.tagme.AnnotatedText;
import it.acubelab.tagme.Annotation;
import it.acubelab.tagme.Disambiguator;
import it.acubelab.tagme.RelatednessMeasure;
import it.acubelab.tagme.RhoMeasure;
import it.acubelab.tagme.Segmentation;
import it.acubelab.tagme.TagmeParser;
import it.acubelab.tagme.config.TagmeConfig;
import it.acubelab.tagme.preprocessing.TopicSearcher;

import java.io.IOException;
import java.util.List;



public class TagmeAnnotator {

	private List<Annotation> annots;
	private TopicSearcher searcher; 
	private AnnotatedText ann_text;
	private RelatednessMeasure rel;
	private TagmeParser parser;
	private Disambiguator disamb;
	private Segmentation segmentation;
	private RhoMeasure rho;
	private String lang;
	
	public AnnotatedText getAnn_text() {
		return ann_text;
	}

	public TagmeAnnotator (String l) throws IOException {

		lang = l;
		TagmeConfig.init("/home/souza/tagme.acubelab/config.xml");
		rel = RelatednessMeasure.create(lang);
		parser = new TagmeParser(lang, true);
		disamb = new Disambiguator(lang);
		segmentation = new Segmentation();
		rho = new RhoMeasure();
	
	}
	
	public void annotate (String text) throws IOException
	{
		ann_text = new AnnotatedText(text);
		parser.parse(ann_text);
		segmentation.segment(ann_text);
		disamb.disambiguate(ann_text, rel);
		rho.calc(ann_text, rel);
		annots = ann_text.getAnnotations();
		searcher = new TopicSearcher(lang);
	
	}

	public List<Annotation> getAnnots() {
		return annots;
	}

	
	public TopicSearcher getSearcher() {
		return searcher;
	}


}

