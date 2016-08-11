package wordcrawler;

import java.util.Map;

/**
 * Created by christoph on 11/08/2016.
 */
public class Translation {
    private String word;
    private String translation;
    private Map<String,String> attributes;

    public Translation(String word, String translation, Map<String, String> attributes) {
        this.word = word;
        this.translation = translation;
        this.attributes = attributes;
    }

    public Translation(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public void setAttribute(String key, String value){
        this.attributes.put(key, value);
    }

    public String getWord(){
        return this.word;
    }

    public String getTranslation() {
        return this.translation;
    }

    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    public String toString(){
        StringBuilder output = new StringBuilder("");
        output.append("Word: " + this.word + "\n");
        output.append("Translation: " + this.translation + "\n");
        output.append("Attributes: " + "\n");
        for (Map.Entry<String, String> entry : attributes.entrySet())
            {
                output.append(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        return output.toString();
    }

}
