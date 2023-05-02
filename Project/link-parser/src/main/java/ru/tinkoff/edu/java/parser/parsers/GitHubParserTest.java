package ru.tinkoff.edu.java.parser.parsers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GitHubParserTest {
    private final GitHubParser gitHubParser = new GitHubParser(null);
    private final String username = "ShleyovT/";
    private final String repo = "MyRepo";


    @Test
    public void invalidLinkParse() {
        String link1 = "https://github.com/" + username;
        String link2 = "https://github.com/" + username + "/" + repo + "/" + "pulls";

        Record record1 = gitHubParser.parseLink(link1);
        Record record2 = gitHubParser.parseLink(link2);

        Assertions.assertNull(record1);
        Assertions.assertNull(record2);
    }
}