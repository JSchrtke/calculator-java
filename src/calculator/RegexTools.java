package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTools {
    public static boolean stringContainsRegex(String toSearch, String regexPattern) {
        // https://alvinalexander.com/blog/post/java/how-find-string-simple-regex-pattern-matcher
        Pattern p = Pattern.compile(regexPattern);
        Matcher m = p.matcher(toSearch);

        if (m.find()) {
            return true;
        }
        return false;
    }

    public static String extractRegexFromString(String regexPattern, String toSearch) throws Exception {
        // https://alvinalexander.com/blog/post/java/how-extract-group-string-regex-pattern-matcher-find
        Pattern p = Pattern.compile(regexPattern);
        Matcher m = p.matcher(toSearch);
        // if (stringContainsRegex(toSearch, regexPattern))
        if (m.find()) {
            return m.group(1);
        } else {
            throw new Exception("Regex not foud in string!"); // TODO find/make a proper exception for this
        }
    }

    public static String replaceRegexInString(String regexPattern, String replacement, String toSearch)
            throws Exception {
        // if (stringContainsRegex(toSearch, regexPattern))
        Pattern p = Pattern.compile(regexPattern);
        Matcher m = p.matcher(toSearch);
        if (m.find()) {
            toSearch = toSearch.replaceFirst(regexPattern, replacement);
            return toSearch;
        } else {
            throw new Exception("Regex not found in string!"); // TODO find/make a proper exception for this
        }
    }
}