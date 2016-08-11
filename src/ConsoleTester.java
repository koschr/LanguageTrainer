import wordcrawler.WordCrawler;
import wordcrawler.utils.NoSuchSourceException;

import java.util.List;

/**
 * Created by christoph on 11/08/2016.
 */
public class ConsoleTester {
    public static void main(String[] args){
        WordCrawler crawler = null;
        if(args.length != 2){
            System.out.println("Invalid number of arguments");
            return;
        }
        try {
            crawler = new WordCrawler(args[0], args[1]);
        } catch (NoSuchSourceException e) {
            e.printStackTrace();
            return;
        }
        List<String> output = crawler.crawl();
        for(String s: output){
            System.out.println(s);
            System.out.println("-----------------------");
        }
    }
}
