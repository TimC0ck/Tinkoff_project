import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws MalformedURLException {
        Scanner sc = new Scanner(System.in);
        String str_link = sc.next();

        abstract_parser gp = new github_parser();
        abstract_parser so = new stackoverflow_parser();
        abstract_parser op = new other_parser();

        gp.parse(str_link);
        so.parse(str_link);
        op.parse(str_link);

    }
}
