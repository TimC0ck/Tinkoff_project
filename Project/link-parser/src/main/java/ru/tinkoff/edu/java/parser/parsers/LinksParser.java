package ru.tinkoff.edu.java.parser.parsers;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public sealed abstract class LinksParser permits GitHubParser, StackOverflowParser {
    protected LinksParser nextParser;

    abstract Record parseLink(String link);
}