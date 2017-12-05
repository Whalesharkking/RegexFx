package application;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private Matcher matchers;

    public List<String> makeRegexAndTestIt(final String textFlag, final String textRegex, final String textString) {
        try {
            if (!textFlag.isEmpty()) {
                for (final Flags flags : Flags.values()) {
                    if (flags.getFlagName().equals(textFlag.toUpperCase())) {
                        return createMatcherAnfFindMatches(textString, Pattern.compile(textRegex, flags.getPattern()));
                    }
                }
            } else {
                return createMatcherAnfFindMatches(textString, Pattern.compile(textRegex));
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getResults(final Matcher matcher) {
        return "I found the text " + matcher.group() + " starting at index " + matcher.start() + " and ending at index " + matcher.end();
    }

    private List<String> matcherFind(final Matcher matcher) {
        final List<String> matchs = new ArrayList<>();
        while (matcher.find()) {
            matchs.add(getResults(matcher));
        }
        return matchs;
    }

    private List<String> createMatcherAnfFindMatches(final String text, final Pattern pattern) {
        matchers = pattern.matcher(text);
        return matcherFind(matchers);
    }

    public int getNumberOfGroups() {
        return matchers.groupCount();
    }
}
