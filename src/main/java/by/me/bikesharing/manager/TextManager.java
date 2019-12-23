package by.me.bikesharing.manager;

import java.util.Locale;
import java.util.ResourceBundle;

public class TextManager {
    private ResourceBundle bundle;
    public TextManager(String language) {
        if (language.equals("en_US")) {
            bundle = ResourceBundle.getBundle("property.text", new Locale("en", "US"));
        } else {
            bundle = ResourceBundle.getBundle("property.text", new Locale("ru", "RU"));
        }
    }
    public String getProperty(String key) {
        return bundle.getString(key);
    }

}
