package wordcrawler.sources;

import wordcrawler.Translation;
import wordcrawler.utils.NotImplementedYetException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * Created by christoph on 11/08/2016.
 */
public class DictCCSource implements SourceObject {

    private URL url;

    public DictCCSource(String word) throws NotImplementedYetException{
        if(word.indexOf(" ") != -1) {
            throw new NotImplementedYetException("Currently only single words supported!");
        }
        try{
            this.url = new URL("http://dees.dict.cc/?s=" + word);
        }catch(MalformedURLException urlExc) {
            System.out.println("Malformed url!");
        }
    }

    public List<Translation> getTranslations(){
        List<Translation> translations = new LinkedList<>();
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            String[] ids = null;
            String[] words = null;
            String[] trans = null;
            while((line = reader.readLine()) != null) {
                if(line.indexOf("var idArr") != -1){
                    System.out.println(line);
                    ids = line.split("\\(")[1].replaceAll("\\);","").split(",");
                }else if(line.indexOf("var c1Arr") != -1){
                    System.out.println(line);
                    words = line.split("\\(")[1].replaceAll("\\);","").split(",");
                }else if(line.indexOf("var c2Arr") != -1){
                    System.out.println(line);
                    trans = line.split("\\(")[1].replaceAll("\\);","").split(",");
                }
            }
            reader.close();
            for(int i = 1; i < ids.length; i++) {
                Translation tr = new Translation(words[i], trans[i], new HashMap<String, String>());
                tr.setAttribute("ID", ids[i]);
                translations.add(tr);
            }
        } catch(IOException ioexc) {
            System.out.println("IOException!");
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return translations;
    }

    /*
     * Todo: Implement real method, this is just a placeholder
     */
    private Map<String, String> getAttributes(String wordID) throws IOException{
        try{
            //insert actual connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        }catch(IOException ex) {
            throw ex;
        }
        return new HashMap<String, String>();
    }
}
