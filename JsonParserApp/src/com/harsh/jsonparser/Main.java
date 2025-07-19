package com.harsh.jsonparser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import org.json.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the path of your JSON file: ");
            String jsonFilePath = scanner.nextLine().trim();
            String content = new String(Files.readAllBytes(Paths.get(jsonFilePath)), StandardCharsets.UTF_8);
            JSONObject obj = new JSONObject(content);
            if (!obj.has("domains")) {
                System.out.println("❌ Error: No 'domains' array found in the JSON.");
                return;
            }
            JSONArray domains = obj.getJSONArray("domains");
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv", StandardCharsets.UTF_8));
            writer.write("Context,Question,Answer,ID\n");
            for (int i = 0; i < domains.length(); i++) {
                JSONObject domain = domains.getJSONObject(i);
                String context = domain.optString("context", "");
                JSONArray qas = domain.optJSONArray("qas");
                if (qas == null)
                    continue;
                for (int j = 0; j < qas.length(); j++) {
                    JSONObject qa = qas.getJSONObject(j);
                    String question = qa.optString("question", "");
                    String answer = qa.optString("answer", "");
                    String id = qa.optString("id", "");

                    writer.write(
                            escapeCsv(context) + "," +
                                    escapeCsv(question) + "," +
                                    escapeCsv(answer) + "," +
                                    escapeCsv(id) + "\n");
                }
            }

            writer.close();
            System.out.println("✅ CSV exported successfully to output.csv");
        } catch (IOException e) {
            System.out.println("❌ File error: " + e.getMessage());
        } catch (JSONException e) {
            System.out.println("❌ JSON parsing error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Unknown error: " + e.getMessage());
        }
    }
    private static String escapeCsv(String input) {
        if (input == null)
            return "";
        String escaped = input.replace("\"", "\"\"");
        return "\"" + escaped + "\"";
    }
}
