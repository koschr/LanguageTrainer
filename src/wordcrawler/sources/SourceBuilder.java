package wordcrawler.sources;

import wordcrawler.sources.DictCCSource;
import wordcrawler.sources.Source;
import wordcrawler.sources.SourceObject;
import wordcrawler.utils.NotImplementedYetException;

/**
 * Created by christoph on 11/08/2016.
 */
public class SourceBuilder {
    private Source source;
    private String word;

    public SourceBuilder(Source source, String word) {
        this.source = source;
        this.word = word;
    }

    public SourceObject buildSourceObject () {
        SourceObject srcObj = null;

        switch(this.source) {
            case DictCC:
                try {
                    srcObj = new DictCCSource(this.word);
                } catch (NotImplementedYetException e) {
                    e.printStackTrace();
                }

            //TODO: Do we want a default?
            default:
                try {
                    srcObj = new DictCCSource(this.word);
                } catch (NotImplementedYetException e) {
                    e.printStackTrace();
                }
        }

        return srcObj;
    }
}
