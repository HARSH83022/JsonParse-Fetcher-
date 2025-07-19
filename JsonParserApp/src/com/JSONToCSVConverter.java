package com.harsh.jsonparser;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Set;
import java.util.Iterator;

public class JSONToCSVConverter {
    public static String convert(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            StringBuilder csvBuilder = new StringBuilder();

            if (jsonArray.length() == 0) return "";

            JSONObject first = jsonArray.getJSONObject(0);
            Set<String> keys = first.keySet();

            // Header
            for (String key : keys) {
                csvBuilder.append(key).append(",");
            }
            csvBuilder.setLength(csvBuilder.length() - 1);
            csvBuilder.append("\n");

            // Data rows
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                for (String key : keys) {
                    csvBuilder.append(obj.optString(key, "")).append(",");
                }
                csvBuilder.setLength(csvBuilder.length() - 1);
                csvBuilder.append("\n");
            }

            return csvBuilder.toString();
        } catch (Exception e) {
            return "Invalid JSON Array for CSV conversion.";
        }
    }
}
