package com.sarnova;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public final class RegexUtils {

    private RegexUtils() { }

    public static String matchPattern(String text, String pattern, int regexGroupNumber) {
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        if (matcher.find()) {
            return matcher.group(regexGroupNumber);
        }
        return EMPTY;
    }
}
