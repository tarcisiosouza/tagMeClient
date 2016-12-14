TagMeClient@L3S
=================

TagMe client at L3S for Java applications

Adding tagMeClient to your Maven pom.xml
-----------------------------------

		<dependency>
			<groupId>de.l3s.souza</groupId>
  			<artifactId>tagMeClient</artifactId>
  			<version>1.0-SNAPSHOT</version>
  			<scope>compile</scope>
		</dependency>

In the TagMeClient project
-----------------------------------
```
mvn clean install
```

In your application folder
-----------------------------------
```
mvn eclipse:eclipse
```

Example
-----------------------------------
Instanciate a TagMeAnnotator selecting the Language:
```
TagmeAnnotator annotation = new TagmeAnnotator ("en");
```
And then get the annotations:
```
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
 ```
