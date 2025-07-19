package com.harsh.jsonparser;

import org.json.JSONObject;
import org.json.JSONArray;

public class JSONValidator {
    public static boolean isValidJSON(String json) {
        try {
            json = json.trim();
            if (json.startsWith("{")) {
                new JSONObject(json);
            } else if (json.startsWith("[")) {
                new JSONArray(json);
            } else {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
