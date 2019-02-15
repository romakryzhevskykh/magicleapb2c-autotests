package com.template.utils;

public class SiteUtil {

    private SiteUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static String[] separateWordsByWhiteSpace(String input) {
        final String separator = "[\u202F\u00A0]";
        final String alternateSeparator = "&nbsp;";
        if (input.contains(alternateSeparator)) {
            return input.split(alternateSeparator);
        } else
            return input.split(separator);
    }
}
