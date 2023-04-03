import java.net.MalformedURLException;
import java.net.URL;

public class stackoverflow_parser extends abstract_parser{
    URL url;
    @Override
    public void parse(String string) throws MalformedURLException {
        url = new URL (string);
        if (url.getHost().equals("stackoverflow.com")){
            int fst = String.valueOf(url).lastIndexOf("s/") + 2;
            int lst = String.valueOf(url).lastIndexOf("/");
            System.out.println(String.valueOf(url).substring(fst,lst));
        }
    }
}
