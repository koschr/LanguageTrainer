package wordcrawler;

import wordcrawler.sources.Source;
import wordcrawler.sources.SourceBuilder;
import wordcrawler.sources.SourceObject;
import wordcrawler.utils.NoSuchSourceException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by christoph on 10/08/2016.
 */
public class WordCrawler {
    private SourceBuilder srcBuilder;
    private SourceObject srcObj;

    public  WordCrawler(String word, String sourceStr) throws NoSuchSourceException {
        Source src = null;
        for (Source c : Source.values()) {
            if (c.name().equals(sourceStr)) {
                src = c;
            }
        }
        if(src == null) {
            throw new NoSuchSourceException("No such source. Please choose one of the following: " + Source.values().toString());
        }
        srcBuilder = new SourceBuilder(src, word);
        srcObj = srcBuilder.buildSourceObject();
    }

    public List<String> crawl(){
        List<Translation> tr = srcObj.getTranslations();
        List<String> outputTrans = new LinkedList<String>();
        for(Translation t: tr){
            outputTrans.add(t.toString());
        }
        return outputTrans;
    }
}
