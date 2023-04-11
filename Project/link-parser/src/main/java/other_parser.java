import java.net.MalformedURLException;
import java.net.URL;

public class other_parser extends abstract_parser{
    URL url;
    @Override
    public void parse(String string) throws MalformedURLException {
        url = new URL (string);
        if (url.getHost().equals("stackoverflow.com") == false) {
            if (url.getHost().equals("github.com") == false){
                System.out.println("null");
            }
        }
    }
}
