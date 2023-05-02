package ru.tinkoff.edu.java.parser.parsers;

import ru.tinkoff.edu.java.parser.records.StackOverflowRecord;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StackOverflowParser extends LinksParser {
    private final Pattern PATTERN =
            Pattern.compile("^https://stackoverflow.com/questions/(\\d+)/[a-z-\\d]+");

    public StackOverflowParser(LinksParser nextLink) {
        super(nextLink);
    }
    public Record parseLink(String link) {
        Matcher matcher = PATTERN.matcher(link);
        if (matcher.matches()) {
            return new StackOverflowRecord(Long.parseLong(matcher.group(1)));
        }
        if (nextParser != null) {
            return nextParser.parseLink(link);
        }
        return null;
    }
}