package com.harsh.jsonparser;

import org.json.JSONObject;
import org.json.XML;

public class JSONToXMLConverter {
    public static String convert(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            return XML.toString(jsonObject);
        } catch (Exception e) {
            return "Invalid JSON for XML conversion.";
        }
    }
}
