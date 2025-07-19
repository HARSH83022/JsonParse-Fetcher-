package com.harsh.jsonparser;

import org.json.JSONObject;
import org.json.JSONArray;

public class JSONFormatter {
    public static String format(String json) {
        try {
            json = json.trim();
            if (json.startsWith("{")) {
                return new JSONObject(json).toString(4);
            } else if (json.startsWith("[")) {
                return new JSONArray(json).toString(4);
            }
        } catch (Exception e) {
            return "Invalid JSON!";
        }
        return "Unknown format";
    }
}
