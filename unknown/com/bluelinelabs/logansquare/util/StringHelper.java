package com.bluelinelabs.logansquare.util;

import com.fasterxml.jackson.core.JsonParser;

import java.io.IOException;

public class StringHelper {

    public static String parseWithNullInMind(JsonParser jsonParser) throws IOException {
        String value = jsonParser.getText();
        // Latest version of Logan Square returns the field value directly, i.e. "null" but
        // the TFA codebase expects it to be like the old version where it returned as Java null.
        // Update the parser to adjust for the change
        if ("null".equalsIgnoreCase(value)) {
            return null;
        } else {
            return value;
        }
    }
}
