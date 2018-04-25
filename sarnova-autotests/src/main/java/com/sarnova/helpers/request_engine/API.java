package com.sarnova.helpers.request_engine;

import java.util.ArrayList;

public interface API {

    enum RESPONSE_CONTENT_TYPES {
        JSON(new ArrayList<String>() {{
            add("application/json");
            add("text/javascript");
            add("text/javascript; encoding=utf-8");
            add("application/json;charset=UTF-8");
            add("application/json; charset=utf-8");
        }}),
        XML(new ArrayList<String>() {{
            add("text/xml");
        }}),
        HTML(new ArrayList<String>() {{
            add("text/html;charset=ISO-8859-1");
            add("text/html");
            add("text/html; charset=UTF-8");
            add("text/html;charset=UTF-8");
        }});
        ArrayList<String> contentTypes;

        RESPONSE_CONTENT_TYPES(ArrayList<String> possibleTypes) {
            this.contentTypes = possibleTypes;
        }

        public boolean contains(String contentType) {
            return contentTypes.contains(contentType);
        }
    }

    enum DELIMITER {
        QUESTION_MARK("?"),
        AMPERSAND("&"),
        FORWARD_SLASH("/"),
        EQUALS_SIGN("=");
        String delimiter;

        DELIMITER(String delimiter) {
            this.delimiter = delimiter;
        }

        @Override
        public String toString() {
            return delimiter;
        }
    }

    class PostParameterAndValue<V> {
        String parameter;
        V value;
        DELIMITER delimiter;

        PostParameterAndValue(String parameter, V value, DELIMITER delimiter) {
            this.parameter = parameter;
            this.value = value;
            this.delimiter = delimiter;
        }

        public PostParameterAndValue(String parameter, V value) {
            this.parameter = parameter;
            this.value = value;
            this.delimiter = DELIMITER.AMPERSAND;
        }

        public String getValue() {
//            try {
//                return URLDecoder.decode(value.toString(), "UTF-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//                return null;
//            }
            return value.toString();
        }

        public boolean contains(String parameter) {
            return this.parameter.equals(parameter);
        }

        public boolean containsDelimiter(DELIMITER delimiter) {
            return this.delimiter.equals(delimiter);
        }
    }
}
