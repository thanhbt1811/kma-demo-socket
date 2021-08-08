package rmi.search_key;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 12:11 AM
 */
public class Word {
    private String key;

    private String meaning;

    public Word(String key, String meaning) {
        this.key = key;
        this.meaning = meaning;
    }

    public String getKey() {
        return key;
    }

    public String getMeaning() {
        return meaning;
    }
}
