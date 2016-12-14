package de.l3s.souza.tagMeClient;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import it.acubelab.tagme.AnnotatedText;
import it.acubelab.tagme.Annotation;
import it.acubelab.tagme.preprocessing.TopicSearcher;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    public void testApp() throws IOException
    {
    	 TagmeAnnotator annotation = new TagmeAnnotator ("en");
         String test = "Nelson Mandela was the father of the current democratic South Africa that replaced the odious apartheid state.";
         annotation.annotate(test);
        
         List<Annotation> annots = annotation.getAnnots();
         AnnotatedText ann_text = annotation.getAnn_text();
         TopicSearcher searcher = annotation.getSearcher();
         
         for (Annotation a : annots) {
  			if (a.isDisambiguated() && a.getRho() >= 0.1) {
  				System.out.println("wid: " + a.getTopic() + "\nspot: "
  						+ ann_text.getOriginalText(a) + "\nrho: " + a.getRho());
  				System.out.println("Wikipedia Page: "
  						+ searcher.getTitle(a.getTopic()));
  			}
  		}
  		
         test = "Obama meets Merkel in Berlin to discuss TTIP and Russia in wake of Trump win";
         annotation.annotate(test);
         annots = annotation.getAnnots();
         ann_text = annotation.getAnn_text();
         searcher = annotation.getSearcher();
         
        
         for (Annotation a : annots) {
      			if (a.isDisambiguated() && a.getRho() >= 0.1) {
      				System.out.println("wid: " + a.getTopic() + "\nspot: "
      						+ ann_text.getOriginalText(a) + "\nrho: " + a.getRho());
      				System.out.println("Wikipedia Page: "
      						+ searcher.getTitle(a.getTopic()));
      			}
      		}
        
     
    }
}
