# 📄 JSON to CSV Parser – Java

## 🔧 Project Overview

This Java-based application reads structured JSON data and converts it into a clean, readable CSV format. It supports nested objects (like `context`, `qas`, etc.), making it ideal for converting datasets used in NLP, surveys, chatbots, and FAQ-based systems.

---

## 🧠 Why We Made This

Working with JSON data is common in web development, APIs, and machine learning. However, analyzing or sharing this data often requires converting it to a flat format like CSV, which can be easily opened in Excel or used in data pipelines.

This tool:
- Bridges the gap between human-readable formats (JSON) and analysis-ready formats (CSV).
- Simplifies handling of multilingual or structured Q&A datasets (e.g., Hindi FAQs).
- Makes JSON data accessible to non-programmers.

---

## ✅ Features and Benefits

- ✅ Converts structured Q&A-style JSON to CSV.
- ✅ Preserves context, questions, answers, and IDs.
- ✅ Supports Unicode (e.g., Hindi, Tamil, etc.).
- ✅ Easy to run via command line.
- ✅ Outputs a CSV readable by Excel, Google Sheets, etc.

---

## 📁 Input JSON Format

The application expects a JSON object structured like this:

```json
{
  "domains": [
    {
      "qas": [
        {
          "question": "...",
          "answer": "...",
          "id": "..."
        }
      ],
      "context": "..."
    }
  ]
}
```

---

## 📤 Output Format (CSV)

Each row of the CSV will contain:

| Context | Question | Answer | ID |
|--------|----------|--------|----|

---

## 🏗️ Technologies Used

- Java (SE 8+)
- org.json library (`json-20210307.jar`)

---

## 🚀 How to Run

1. Place your JSON in `input.json` (same directory).
2. Make sure you’ve added the `json-20210307.jar` to the `lib` folder.
3. Compile:
   ```bash
   javac -cp "lib/json-20210307.jar" -d out src/com/harsh/jsonparser/Main.java
   ```
4. Run:
   ```bash
   java -cp ".;lib/json-20210307.jar;out" com.harsh.jsonparser.Main
   ```

---

## 🛠️ Problems Faced During Development

| Problem | Solution |
|--------|----------|
| JSON had nested structure | Handled using recursive or loop-based extraction |
| Unicode characters in Hindi | Used `StandardCharsets.UTF_8` for file writing |
| File access error | Ensured file not open in other apps during writing |
| Incorrect JSON format error | Added error handling to validate structure |
| Type mismatch (`FileWriter` issue) | Used `OutputStreamWriter` with UTF-8 encoding |

---

## 📌 Future Improvements

- Add GUI using JavaFX or Swing.
- Allow selecting input/output files dynamically.
- Support multiple nested formats.
- Export to Excel (`.xlsx`) using Apache POI.

---

## 👨‍💻 Author

**Harsh Mishra**  
Department of CSE (AI/ML + IoT), GLA University  
📧 [Email](mailto:harshmishra83022@gmail.com) | 🌐 [LinkedIn](www.linkedin.com/in/harsh-mishra-5a5031266)